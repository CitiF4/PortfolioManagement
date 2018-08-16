/**
 * Created by Dong on 2018/8/15.
 */
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
function selectSymbolOnchange(e){
    console.log("symbol has been selected");
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

