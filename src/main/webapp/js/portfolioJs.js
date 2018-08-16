/**
 * Created by Dong on 2018/8/15.
 */
function showPositions(response){
    var tableData = response.positions;
    $('#portfolioName')[0].innerText = response.portfolioName;
    $('#curCash')[0].innerText  = response.restCash;
    $('#curValue')[0].innerText  = response.totalValue;
    $('#offset')[0].innerText =  response.profit;
    if( $('#showPositions').dataTable()){
        $('#showPositions').dataTable().fnDestroy();
    }
    $('#showPositions').DataTable( {
        data: tableData,
        columns: [
            { data: 'symbol' },
            { data: 'type' },
            { data: 'qty' },
            { data: 'price' },
            { data: 'value' },
            { data: 'curValue' },
            { data: 'profit' },
            { data: 'date' }
        ]
    } );
}
function selectTypeOnchange(e){
    var type = $('#selectType').find("option:selected").attr("value");
      $.ajax({
          url:"/getSymbols",
          dataType:"json",
          data:{type:type},
          success:function(response){
              console.log(response);
              var symbolArray = response.symbol;
              for(var i =0; i < symbolArray.length;i++){
                  $('#selectSymbol').append("<option value =" + symbolArray[i] + ">" +  symbolArray[i] + "</option>");
              }
          }
      })
}
function selectSymbolOnchange(e){
    var symbol = $('#selectSymbol').find("option:selected").attr("value");
    var type = $('#selectType').find("option:selected").attr("value");
//        根据symbol去请求近期的数据
    $.ajax({
        url:"/getRecentPrice",
        dataType:"json",
        data: {
            symbol:symbol,
            type:type},
        success:function(response){
            console.log(response);
            //根据返回的信息渲染页面
            var labelData = [];
            var data = [];
            var recentPrice = response.recentPrice;
            for(var i = 0; i < recentPrice.length; i++){
                labelData.push(recentPrice[i].date);
                data.push(recentPrice[i].price);
            }
            showChart(labelData,data);
        }
    })
}
function showChart(labelData,data){
    var ctx = document.getElementById("myChart").getContext('2d');
    var myChart = new Chart(ctx, {
        type: 'line', // line 表示是 曲线图，当然也可以设置其他的图表类型 如柱形图 : bar  或者其他
        data: {
            labels :labelData, //按时间段 可以按星期，按月，按年
            datasets : [
                {
                    label: "123",  //当前数据的说明
                    fill: true,  //是否要显示数据部分阴影面积块  false:不显示
                    borderColor: "rgba(200,187,205,1)",//数据曲线颜色
                    pointBackgroundColor: "#fff", //数据点的颜色
                    data: data,  //填充的数据
                }
            ]
        }
    });

}

