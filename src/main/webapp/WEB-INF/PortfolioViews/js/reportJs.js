var jsonData = [
            {
            "portfolioName":"port1",
            "initCash":500,
            "curCash":300,
            "value":600,
            "rate":0.2
           }, {
                "portfolioName":"port2",
                "initCash":500,
                "curCash":300,
                "value":600,
                "rate":0.2
            },
            {
                "portfolioName":"port3",
                "initCash":500,
                "curCash":300,
                "value":600,
                "rate":0.2
            },
            {
                "portfolioName":"port4",
                "initCash":500,
                "curCash":300,
                "value":600,
                "rate":0.2
            },
            {
                "portfolioName":"port5",
                "initCash":500,
                "curCash":300,
                "value":600,
                "rate":02
            }, {
                "portfolioName":"port6",
                "initCash":500,
                "curCash":300,
                "value":600,
                "rate":0.2
            },
            {
                "portfolioName":"port7",
                "initCash":500,
                "curCash":300,
                "value":600,
                "rate":0.2
            },
            {
                "portfolioName":"port8",
                "initCash":500,
                "curCash":300,
                "value":600,
                "rate":0.2
            },
            {
                "portfolioName":"port9",
                "initCash":500,
                "curCash":300,
                "value":600,
                "rate":0.2
            },
            {
                "portfolioName":"port10",
                "initCash":500,
                "curCash":300,
                "value":600,
                "rate":0.2
            },
          {
          "portfolioName":"worsest",
          "initCash":500,
          "curCash":300,
          "value":600,
          "rate":0.2
      }
    ]


$(document).ready(function() {
      //     $.ajax({
      //     type:"GET",
      //     url:"/getTopTenPortfolios",   //以及最坏的portfolio
      //     dataType:"json",
      //     success:function(response){
      //         //更新图和表！
      //
      //         // var optArr = [];
      //         // for(var i =0; i < response.length;i++){
      //         //     $('#selectSymbol').append("<option value =" + response[i].symbol + ">" +  response[i].symbol + "</option>");
      //         // }
      //     }
      // });
          var labelData = [];
          var data = [];
          for(var i = 0; i < jsonData.length-1 ;i++){
            labelData.push(jsonData[i].portfolioName);
            data.push(jsonData[i].rate);
          }
          var topTenData = jsonData.slice(0,jsonData.length-1);
          createChart(labelData,data);
          showTopTable(topTenData);
          var bestAndWorsest = {
              best:topTenData[0],
              worsest:jsonData[jsonData.length -1]};
          showBestAndWorsest(bestAndWorsest);
});
function createChart(labelData,data){
    var ctx = document.getElementById("reportBarChart");
    if (ctx) {
        ctx.height = 150;
        var myChart = new Chart(ctx, {
            type: 'bar',
            data: {
                labels: labelData,
                datasets: [
                    {
                        label: "My First dataset",
                        data: data,
                        borderColor: "rgba(0, 123, 255, 0.9)",
                        borderWidth: "0",
                        backgroundColor: "rgba(0, 123, 255, 0.5)"
                    }
                ]
            },
            options: {
                legend: {
                    position: 'top',
                    labels: {
                        fontFamily: 'Poppins'
                    }

                },
                scales: {
                    xAxes: [{
                        ticks: {
                            fontFamily: "Poppins"

                        }
                    }],
                    yAxes: [{
                        ticks: {
                            beginAtZero: true,
                            fontFamily: "Poppins"
                        }
                    }]
                }
            }
        });
    }

}
function showTopTable(topTenData){
    for(var i = 0; i < topTenData.length; i++){
        var portfolio = topTenData[i];
        $("#topPortfolios").append(
            "<tr>" +
            "<td>" + portfolio.portfolioName + "</td>" +
            "<td>" + portfolio.rate + "</td>" +
            "</tr>")
    }
    }
function showBestAndWorsest(bestAndWorsest){
    $("#bestPortfolio").children("h4")[0].innerText = bestAndWorsest.best.portfolioName;
    $("#bestPortfolio").children("span")[0].innerText = bestAndWorsest.best.initCash;
    $("#bestPortfolio").children("span")[1].innerText = bestAndWorsest.best.curCash;
    $("#bestPortfolio").children("span")[2].innerText = bestAndWorsest.best.value;
    $("#bestPortfolio").children("span")[3].innerText = bestAndWorsest.best.rate;
    $("#worsestPortfolio").children("h4")[0].innerText = bestAndWorsest.worsest.portfolioName;
    $("#worsestPortfolio").children("span")[0].innerText = bestAndWorsest.worsest.initCash;
    $("#worsestPortfolio").children("span")[1].innerText = bestAndWorsest.worsest.curCash;
    $("#worsestPortfolio").children("span")[2].innerText = bestAndWorsest.worsest.value;
    $("#worsestPortfolio").children("span")[3].innerText = bestAndWorsest.worsest.rate;




}


