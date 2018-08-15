/**
 * Created by Dong on 2018/8/15.
 */

var portfolioData;
$(document).ready(function() {
    console.log($('#chartDate'));
    var date = new Date();
    month = date.getMonth() + 1;
    var dateStr = date.getFullYear() + "-" + month + "-" + date.getDate();
    $('#chartDate')[0].innerText = dateStr;
//        var jsonStr = "${portfolioData}";
    portfolioData = {
        "portfolioName": "port1",
        "initCash":20,
        "curCash":30,
        "curValue":50,
        "offset":20,
        "percentage":0.2,
        "positions":[
            {
                "symbol":"Apple",
                "type":"Bonds",
                "qty":20,
                "price":2020,
                "value":50000,
                "curValue":52365,
                "offset":50,
                "date":"2018-08-17"
            },
            {
                "symbol":"Goole",
                "type":"Bonds",
                "qty":22,
                "price":2020,
                "value":50000,
                "curValue":52365,
                "offset":50,
                "date":"2018-08-17"
            },
            {
                "symbol":"Alibaba",
                "type":"Bonds",
                "qty":23,
                "price":2020,
                "value":50000,
                "curValue":52365,
                "offset":50,
                "date":"2018-08-17"
            },
            {
                "symbol":"Baidu",
                "type":"Bonds",
                "qty":20,
                "price":2020,
                "value":50000,
                "curValue":52365,
                "offset":50,
                "date":"2018-08-17"
            }
        ]
    };
    showPositions(portfolioData);
});
function showPositions(data){
    var tableData = data.positions;
    $('#portfolioName').innerText = data.portfolioName;
    $('curCash').innerText  = data.curCash;
    $('curValue').innerText  = data.curValue;
    $('offset').innerText =  data.offset;

    if( $('#showPositions').dataTable()){
        $('#showPositions').dataTable().fnDestroy();
    }
    $('#showPositions').DataTable( {
//         ajax: {
//             url: '/getPostions',
//             type:POST,
//             data:{}
// //                dataSrc: 'staff',
//
//         },
        data: tableData,
        columns: [
            { data: 'symbol' },
            { data: 'type' },
            { data: 'qty' },
            { data: 'price' },
            { data: 'value' },
            { data: 'curValue' },
            { data: 'offset' },
            { data: 'date' }
        ]
    } );
}

$('#createPortfolio').click(function(){
    $('#myModal').css('display', 'block');
    var modalHeight = $(window).height() / 2 - $('#myModal .modal-dialog').height() / 2;
    $('#myModal').find('.modal-dialog').css({
        'margin-top': modalHeight
    });
    $('#myModal').modal();
});

$('#myModal').on('shown.bs.modal', function (e) {
    // 关键代码，如没将modal设置为 block，则$modala_dialog.height() 为零
    $(this).css('display', 'block');
    var modalHeight = $(window).height() / 2 - $('#myModel .modal-dialog').height() / 2;
    $(this).find('.modal-dialog').css({
        'margin-top': modalHeight
    });
});
function selectTypeOnchange(e){
    var type = $('#selectType').find("option:selected").attr("value");
    console.log($('#selectType').find("option:selected").attr("value"));
//       $.ajax({
//           url:"/getSymbols",
//           dataType:"json",
//           data:{type:type},
//           success:function(response){
//               var optArr = [];
//               for(var i =0; i < response.length;i++){
//                   $('#selectSymbol').append("<option value =" + response[i].symbol + ">" +  response[i].symbol + "</option>");
//               }
//           }
//       })
}
function selectSymbolOnchang(e){
    var symbol = $('#selectSymbol').find("option:selected").attr("value");
    var type = $('#selectType').find("option:selected").attr("value");
//        根据symbol去请求近期的数据
    $.ajax({
        url:"/getSymbolInformation",
        dataType:"json",
        data: {
            symbol:symbol,
            type:type},
        success:function(response){
//               根据返回的数据构建chart!

        }
    })
}
var ctx = document.getElementById("myChart").getContext('2d');
var myChart = new Chart(ctx, {
    type: 'line', // line 表示是 曲线图，当然也可以设置其他的图表类型 如柱形图 : bar  或者其他
    data: {
        labels : ["January","February","March","April","May","June","July"], //按时间段 可以按星期，按月，按年
        datasets : [
            {
                label: "123",  //当前数据的说明
                fill: true,  //是否要显示数据部分阴影面积块  false:不显示
                borderColor: "rgba(200,187,205,1)",//数据曲线颜色
                pointBackgroundColor: "#fff", //数据点的颜色
                data: [80, 90, 100, 30, 67, 59, 88],  //填充的数据
            },
            {
                label: "456",  //当前数据的说明
                fill: true,  //是否要显示数据部分阴影面积块  false:不显示
                borderColor: "rgba(75,192,192,1)",//数据曲线颜色
                pointBackgroundColor: "#fff", //数据点的颜色
                data: [21, 34, 35, 50, 45, 21, 70],  //填充的数据
            }
        ]
    }
});
$("#buyPosition").click(function(){
    if($("#quantity-input")[0].value == ""){
        console.log("i am in");
        $("#quantity-input")[0].focus();
    }
    // if(){
    // //    如果钱不够买的话，则提示
    //
    // }
    else{

        var qty = $("#quantity-input")[0].value;
        var type = $('#selectType').find("option:selected").attr("value");
        var symbol = $('#selectSymbol').find("option:selected").attr("value");
        var position = {
            "symbol":symbol,
            "type":type,
            "qty":qty,
            "price":2020,
            "value":50000,
            "curValue":52365,
            "offset":0,
            "date":"2018-08-17"

        }
        portfolioData.positions.push(position);
        $("#showPositions").append(
            "<tr>" +
            "<td>" + position.symbol + "</td>" +
            "<td>" + position.type + "</td>" +
            "<td>" + position.qty + "</td>" +
            "<td>" + position.price + "</td>" +
            "<td>" + position.value + "</td>" +
            "<td>" + position.curValue + "</td>" +
            "<td>" + position.offset + "</td>" +
            "<td>" + position.date + "</td>" +
            "</tr>")
        $.ajax({
            url:"/buyProduct",
            dataType:'json',
            data:{qty:qty,type:type,symbol:symbol},
            success:function(response){
                //这里得到新的table数据
            }
        });

    }


})
$("#sellPosition").click(function(){
    if($("#quantity-input")[0].value == ""){
        $("#quantity-input")[0].focus();
    }
    // if(){
    // //    卖出的股大于拥有的股
    // }
    else{
    //    从最早的股票开始卖
    }
    var qty = $("#quantity-input").innerText;
    var type = $('#selectType').find("option:selected").attr("value");
    var symbol = $('#selectSymbol').find("option:selected").attr("value");
    $.ajax({
        url:"/sellProduct",
        dataType:'json',
        data:{qty:qty,type:type,symbol:symbol},
        success:function(response){
            //这里得到新的table数据
        }
    });

})

