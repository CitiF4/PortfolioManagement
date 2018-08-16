/**
 * Created by Dong on 2018/8/15.
 */
$('#create').click(function(){
    console.log("i am click");
    $('#myModal').css('display', 'block');
    var modalHeight = $(window).height() / 2 - $('#myModal .modal-dialog').height() / 2;
    $('#myModal').find('.modal-dialog').css({
        'margin-top': modalHeight
    });
    $('#myModal').modal();
})

$('#myModal').on('shown.bs.modal', function (e) {
    // 关键代码，如没将modal设置为 block，则$modala_dialog.height() 为零
    $(this).css('display', 'block');
    var modalHeight = $(window).height() / 2 - $('#myModel .modal-dialog').height() / 2;
    $(this).find('.modal-dialog').css({
        'margin-top': modalHeight
    });
});
function submitPorfolio(e){
    if($("#portfolio_name")[0].value == "" ){
        $("#portfolio_name")[0].focus();
    }
    else if($("#portfolio_cash")[0].value == "" ){
        $("#portfolio_cash")[0].focus();
    }
    else{
        //传portfolio数据给后台
        $.ajax({
            type:'POST',
            url:'/createPortfolio',
            data:{
                portfolioName: $('#portfolio_name')[0].value,
                portfolioCash:$('#portfolio_cash')[0].value
            },
            dataTpe:'json',
            success:function(response){
                        for(var i =0;i< response.length; i++){
                            displayPortfolios(response[i]);

                        }

            }
        });
    }

}