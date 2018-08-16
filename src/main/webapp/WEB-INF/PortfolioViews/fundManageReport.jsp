<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="au theme template">
    <meta name="author" content="Hau Nguyen">
    <meta name="keywords" content="au theme template">

    <!-- Title Page-->
    <title>Dashboard</title>

    <!-- Fontfaces CSS-->
    <link href="css/font-face.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all">
    <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">

    <!-- Bootstrap CSS-->
    <link href="vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet" media="all">

    <!-- Vendor CSS-->
    <link href="vendor/animsition/animsition.min.css" rel="stylesheet" media="all">
    <link href="vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet" media="all">
    <link href="vendor/wow/animate.css" rel="stylesheet" media="all">
    <link href="vendor/css-hamburgers/hamburgers.min.css" rel="stylesheet" media="all">
    <link href="vendor/slick/slick.css" rel="stylesheet" media="all">
    <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="vendor/perfect-scrollbar/perfect-scrollbar.css" rel="stylesheet" media="all">
    <link href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css" rel="stylesheet">

    <!-- Main CSS-->
    <link href="css/theme.css" rel="stylesheet" media="all">

</head>

<body class="animsition">
<div class="page-wrapper">
    <!-- MENU SIDEBAR-->
    <aside class="menu-sidebar d-none d-lg-block">
        <div class="logo">
            <a href="#">
                <img src="images/icon/logo.png" alt="FundManager" />
            </a>
        </div>
        <div class="menu-sidebar__content js-scrollbar1">
            <nav class="navbar-sidebar">
                <ul class="list-unstyled navbar__list">
                    <li class="active has-sub">
                        <a id = "createPortfolio" class="js-arrow" href="#" >
                            <i class="fas fa-tachometer-alt"></i>Create</a>
                    </li>
                    <li>
                        <a href="chart.html">
                            <i class="fas fa-chart-bar"></i>Portfolios</a>
                    </li>
                    <li>
                        <a href="DisplayInformation.jsp">
                            <i class="fas fa-table"></i>Information</a>
                    </li>
                </ul>
            </nav>
        </div>
    </aside>
    <!-- END MENU SIDEBAR-->

    <!-- PAGE CONTAINER-->
    <div class="page-container">
        <!-- HEADER DESKTOP-->
        <header class="header-desktop">
            <div class="section__content section__content--p30">
                <div class="container-fluid">
                    <div class="header-wrap" style="display:block">
                        <div class="header-button" style="float:right">
                            <div class="account-wrap" style="float:right">
                                <div class="account-item clearfix js-item-menu">
                                    <div class="image">
                                        <img src="images/icon/avatar-01.jpg" alt="John Doe" />
                                    </div>
                                    <div class="content">
                                        <a class="js-acc-btn" href="#">john doe</a>
                                    </div>
                                    <div class="account-dropdown js-dropdown">
                                        <div class="info clearfix">
                                            <div class="image">
                                                <a href="#">
                                                    <img src="images/icon/avatar-01.jpg" alt="John Doe" />
                                                </a>
                                            </div>
                                            <div class="content">
                                                <h5 class="name">
                                                    <a href="#">john doe</a>
                                                </h5>
                                                <span class="email">johndoe@example.com</span>
                                            </div>
                                        </div>
                                        <div class="account-dropdown__body">
                                            <div class="account-dropdown__item">
                                                <a href="#">
                                                    <i class="zmdi zmdi-account"></i>Account</a>
                                            </div>
                                            <div class="account-dropdown__item">
                                                <a href="#">
                                                    <i class="zmdi zmdi-settings"></i>Setting</a>
                                            </div>
                                            <div class="account-dropdown__item">
                                                <a href="#">
                                                    <i class="zmdi zmdi-money-box"></i>Billing</a>
                                            </div>
                                        </div>
                                        <div class="account-dropdown__footer">
                                            <a href="#">
                                                <i class="zmdi zmdi-power"></i>Logout</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <!-- HEADER DESKTOP-->

        <!-- MAIN CONTENT-->
        <div class="main-content">
            <div class="section__content section__content--p30">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-4 col-lg-7">
                            <!-- TOP Chart-->
                            <div class="card">
                                <div class="card-header">
                                    <strong>Top Ten</strong>
                                </div>
                                <div class="card-body card-block">
                                    <div class="chart-wrap">
                                        <canvas id="reportBarChart"></canvas>
                                    </div>
                                </div>
                            </div>
                            <!-- END Chart-->
                        </div>
                        <div class="col-md-4 col-lg-5">
                            <!-- TOP CAMPAIGN-->
                            <div class="card">
                                <div class="card-header">
                                    <strong>Top Portfolios</strong>
                                </div>
                                <div class="card-body card-block">
                                    <div class="table-responsive">
                                        <table id ="topPortfolios" class="table table-top-campaign">
                                            <thead>
                                               <th>Symbol</th>
                                               <th>profitRate</th>
                                            </thead>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <!-- END TOP CAMPAIGN-->
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="card">
                                <div class="card-header">
                                    <strong class="card-title mb-3">Best Portfolio</strong>
                                </div>
                                <div class="card-body">
                                    <div  id = "bestPortfolio" class="mx-auto mr-auto text-center d-block">
                                        <h4  class="text-sm-center mt-2 mb-1">PortfolioName</h4>
                                        <label class="text-sm-center mt-2 mb-1">initCash :</label>
                                        <span id="cash"></span>
                                        <br>
                                        <label class="text-sm-center mt-2 mb-1">curCash :</label>
                                        <span id="curCash"></span>
                                        <br>
                                        <label class="text-sm-center mt-2 mb-1">Value :</label>
                                        <span id="value"></span>
                                        <br>
                                        <label class="text-sm-center mt-2 mb-1">ProfitRate :</label>
                                        <span id="rate"></span>
                                    </div>
                                    <hr>
                                    <div class="table-data-feature">
                                        <button id="edit" class="item" data-toggle="tooltip" data-placement="top" title="Edit" onclick="editProtfolio()">
                                            <i class="zmdi zmdi-edit"></i>
                                        </button>
                                        <button id="delete" class="item" data-toggle="tooltip" data-placement="top" title="Delete" onclick="deleteProtfolio()">
                                            <i class="zmdi zmdi-delete"></i>
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="card">
                                <div class="card-header">
                                    <strong class="card-title mb-3">Worst Portfolio</strong>
                                </div>
                                <div class="card-body">
                                    <div  id = "worstPortfolio"  class="mx-auto mr-auto text-center d-block">
                                        <h4  class="text-sm-center mt-2 mb-1">PortfolioName</h4>
                                        <label class="text-sm-center mt-2 mb-1">initCash :</label>
                                        <span >200</span>
                                        <br>
                                        <label class="text-sm-center mt-2 mb-1">curCash :</label>
                                        <span ></span>
                                        <br>
                                        <label class="text-sm-center mt-2 mb-1">Value :</label>
                                        <span ></span>
                                        <br>
                                        <label class="text-sm-center mt-2 mb-1">ProfitRate :</label>
                                        <span ></span>
                                    </div>
                                    <hr>
                                    <div class="table-data-feature">
                                        <button class="item" data-toggle="tooltip" data-placement="top" title="Edit">
                                            <i class="zmdi zmdi-edit"></i>
                                        </button>
                                        <button class="item" data-toggle="tooltip" data-placement="top" title="Delete">
                                            <i class="zmdi zmdi-delete"></i>
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- END MAIN CONTENT-->
        <!-- END PAGE CONTAINER-->
    </div>
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title" id="myModalLabel">New Portfolio</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                </div>
                <div class="modal-body">

                    <div class="form-group">
                        <label for="portfolio_name">Portfolio Name</label>
                        <input type="text" name="portfolio_name" class="form-control" id="portfolio_name" placeholder="This is required">
                    </div>
                    <div class="form-group">
                        <label for="portfolio_cash">Cash</label>
                        <input type="text" name="portfolio_cash" class="form-control" id="portfolio_cash" placeholder="This is required">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>Close</button>
                    <button type="button" id="btn_submit" onclick="submitPorfolio(this)" class="btn btn-primary" data-dismiss="modal"><span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>Submit</button>
                </div>
            </div>
        </div>
    </div>

</div>

<!-- Jquery JS-->
<script src="vendor/jquery-3.2.1.min.js"></script>
<!-- Bootstrap JS-->
<script src="vendor/bootstrap-4.1/popper.min.js"></script>
<script src="vendor/bootstrap-4.1/bootstrap.min.js"></script>
<!-- Vendor JS       -->
<script src="vendor/slick/slick.min.js">
</script>
<script src="vendor/wow/wow.min.js"></script>
<script src="vendor/animsition/animsition.min.js"></script>
<script src="vendor/bootstrap-progressbar/bootstrap-progressbar.min.js">
</script>
<script src="vendor/counter-up/jquery.waypoints.min.js"></script>
<script src="vendor/counter-up/jquery.counterup.min.js">
</script>
<script src="vendor/circle-progress/circle-progress.min.js"></script>
<script src="vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
<script src="vendor/chartjs/Chart.bundle.min.js"></script>
<script src="vendor/select2/select2.min.js">
</script>
<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>

<!-- Main JS-->
<script src="js/main.js"></script>
<!--common.js-->
<script src="js/commonJs.js"></script>
<script src="js/reportJs.js"></script>
<script>

    $(document).ready(function() {
        $.ajax({
            type:"GET",
            url:"/getTopTenAndWorst",   //以及最坏的portfolio
            dataType:"json",
            success:function(response){
                console.log(response);
                var labelData = [];
                var data = [];
                for(var i = 0; i < response.length-1 ;i++){
                    labelData.push(response[i].name);
                    data.push(response[i].rate);
                }
                var topTenData = response.slice(0,response.length-1);
                createChart(labelData,data);
                showTopTable(topTenData);
                var bestAndWorsest = {
                    best:topTenData[0],
                    worst:response[response.length -1]};
                showBestAndWorsest(bestAndWorsest);
            },
            error:function(){
                console.log("fail");
            }
        });
    });
</script>
</body>

</html>
<!-- end document-->
