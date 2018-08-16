/**
 * Created by Dong on 2018/8/15.
 */

var portfolioData;
var portfolioId;
$(document).ready(function() {
    var date = new Date();
    month = date.getMonth() + 1;
    var dateStr = date.getFullYear() + "-" + month + "-" + date.getDate();
    $('#chartDate')[0].innerText = dateStr;
    portfolioId = "${id}";

    console.log("get portfolio id: " + portfolioId);
      $.ajax({
          url:"/getPortfolio",
          dataType:"json",
          data:{id:portfolioId},
          success:function(response){
              console.log(response);
              showPositions(response);//这里展示position和渲染图表
              showChart(response,response);
          }
      })

    // portfolioData = {
    //     "portfolioName": "port1",
    //     "initCash":20,
    //     "curCash":30,
    //     "curValue":50,
    //     "offset":20,
    //     "percentage":0.2,
    //     "positions":[
    //         {
    //             "symbol":"Apple",
    //             "type":"Bonds",
    //             "qty":20,
    //             "price":2020,
    //             "value":50000,
    //             "curValue":52365,
    //             "offset":50,
    //             "date":"2018-08-17"
    //         },
    //         {
    //             "symbol":"Goole",
    //             "type":"Bonds",
    //             "qty":22,
    //             "price":2020,
    //             "value":50000,
    //             "curValue":52365,
    //             "offset":50,
    //             "date":"2018-08-17"
    //         },
    //         {
    //             "symbol":"Alibaba",
    //             "type":"Bonds",
    //             "qty":23,
    //             "price":2020,
    //             "value":50000,
    //             "curValue":52365,
    //             "offset":50,
    //             "date":"2018-08-17"
    //         },
    //         {
    //             "symbol":"Baidu",
    //             "type":"Bonds",
    //             "qty":20,
    //             "price":2020,
    //             "value":50000,
    //             "curValue":52365,
    //             "offset":50,
    //             "date":"2018-08-17"
    //         }
    //     ]
    // };
    // showPositions(portfolioData);
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
function selectTypeOnchange(e){
    var type = $('#selectType').find("option:selected").attr("value");
    console.log($('#selectType').find("option:selected").attr("value"));
      $.ajax({
          url:"/getSymbols",
          dataType:"json",
          data:{type:type},
          success:function(response){
              var optArr = [];
              for(var i =0; i < response.length;i++){
                  $('#selectSymbol').append("<option value =" + response[i].symbol + ">" +  response[i].symbol + "</option>");
              }
          }
      })
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
            //根据返回的信息渲染页面
            showChart(lableData,data);
        }
    })
}
function showChart(lableData,data){
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
                }
            ]
        }
    });

}
$("#buyPosition").click(function(){
    if($("#quantity-input")[0].value == ""){
        $("#quantity-input")[0].focus();
    }
    var qty = $("#quantity-input")[0].value;
    var type = $('#selectType').find("option:selected").attr("value");
    var symbol = $('#selectSymbol').find("option:selected").attr("value");
    $.ajax({
        url:"/canBuy",
        type:"POST",
        dataType:"json",
        data:{qty:qty,type:type,symbol:symbol,portfolioId:portfolioId},
        success:function(response){
            if(response == "no"){
                alert("can't buy the product")
            }
            else{
                showPositions(response)
            }
        }
    })
    // function buyPostion(){
    //     var qty = $("#quantity-input")[0].value;
    //     var type = $('#selectType').find("option:selected").attr("value");
    //     var symbol = $('#selectSymbol').find("option:selected").attr("value");
    //
    //     // var position = {
    //     //     "symbol": symbol,
    //     //     "type": type,
    //     //     "qty": qty,
    //     //     "price": 2020,
    //     //     "value": 50000,
    //     //     "curValue": 52365,
    //     //     "offset": 0,
    //     //     "date": "2018-08-17"
    //     //
    //     // }
    //     // portfolioData.positions.push(position);
    //     // $("#showPositions").append(
    //     //     "<tr>" +
    //     //     "<td>" + position.symbol + "</td>" +
    //     //     "<td>" + position.type + "</td>" +
    //     //     "<td>" + position.qty + "</td>" +
    //     //     "<td>" + position.price + "</td>" +
    //     //     "<td>" + position.value + "</td>" +
    //     //     "<td>" + position.curValue + "</td>" +
    //     //     "<td>" + position.offset + "</td>" +
    //     //     "<td>" + position.date + "</td>" +
    //     //     "</tr>")
    // }


})
$("#sellPosition").click(function(){
    var qty = $("#quantity-input").innerText;
    var type = $('#selectType').find("option:selected").attr("value");
    var symbol = $('#selectSymbol').find("option:selected").attr("value");
    if($("#quantity-input")[0].value == ""){
        $("#quantity-input")[0].focus();
    }
    $.ajax({
        url:"/canSell",
        type:"POST",
        dataType:"json",
        data:{qty:qty,type:type,symbol:symbol,portfolioId:portfolioId},
        success:function(response){
            if(response == "no"){
                alert("can't sell the product")
            }
            else{
                showPositions(response)
            }
        }
    })

})

