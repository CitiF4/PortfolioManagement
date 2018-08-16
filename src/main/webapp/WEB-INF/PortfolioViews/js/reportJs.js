
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


