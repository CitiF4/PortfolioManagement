// var jsonData = [
//             {
//             "portfolioName":"port1",
//             "initCash":500,
//             "curCash":300,
//             "value":600,
//             "rate":0.2
//            }, {
//                 "portfolioName":"port2",
//                 "initCash":500,
//                 "curCash":300,
//                 "value":600,
//                 "rate":0.2
//             },
//             {
//                 "portfolioName":"port3",
//                 "initCash":500,
//                 "curCash":300,
//                 "value":600,
//                 "rate":0.2
//             },
//             {
//                 "portfolioName":"port4",
//                 "initCash":500,
//                 "curCash":300,
//                 "value":600,
//                 "rate":0.2
//             },
//             {
//                 "portfolioName":"port5",
//                 "initCash":500,
//                 "curCash":300,
//                 "value":600,
//                 "rate":02
//             }, {
//                 "portfolioName":"port6",
//                 "initCash":500,
//                 "curCash":300,
//                 "value":600,
//                 "rate":0.2
//             },
//             {
//                 "portfolioName":"port7",
//                 "initCash":500,
//                 "curCash":300,
//                 "value":600,
//                 "rate":0.2
//             },
//             {
//                 "portfolioName":"port8",
//                 "initCash":500,
//                 "curCash":300,
//                 "value":600,
//                 "rate":0.2
//             },
//             {
//                 "portfolioName":"port9",
//                 "initCash":500,
//                 "curCash":300,
//                 "value":600,
//                 "rate":0.2
//             },
//             {
//                 "portfolioName":"port10",
//                 "initCash":500,
//                 "curCash":300,
//                 "value":600,
//                 "rate":0.2
//             },
//           {
//           "portfolioName":"worsest",
//           "initCash":500,
//           "curCash":300,
//           "value":600,
//           "rate":0.2
//       }
//     ]

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
    for(var i = 0; i < topTenData.length/2; i++){
        var portfolio = topTenData[i];
        $("#topPortfolios").append(
            "<tr>" +
            "<td>" + portfolio.name + "</td>" +
            "<td>" + portfolio.rate + "</td>" +
            "</tr>")
    }
    }
function showBestAndWorsest(bestAndWorsest){
    console.log("best" + bestAndWorsest.best.curCash);
    console.log("worst" + bestAndWorsest.worst.initCash);

    $("#bestPortfolio").children("h4")[0].innerText = bestAndWorsest.best.name;
    $("#bestPortfolio").children("span")[0].innerText = bestAndWorsest.best.initCash;
    $("#bestPortfolio").children("span")[1].innerText = bestAndWorsest.best.curCash;
    $("#bestPortfolio").children("span")[2].innerText = bestAndWorsest.best.value;
    $("#bestPortfolio").children("span")[3].innerText = bestAndWorsest.best.rate;
    $("#worstPortfolio").children("h4")[0].innerText = bestAndWorsest.worst.name;
    $("#worstPortfolio").children("span")[0].innerText = bestAndWorsest.worst.initCash;
    $("#worstPortfolio").children("span")[1].innerText = bestAndWorsest.worst.curCash;
    $("#worstPortfolio").children("span")[2].innerText = bestAndWorsest.worst.value;
    $("#worstPortfolio").children("span")[3].innerText = bestAndWorsest.worst.rate;
}


