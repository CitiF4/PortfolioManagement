/**
 * Created by Dong on 2018/8/15.
 */
$('#create').click(function(){
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


