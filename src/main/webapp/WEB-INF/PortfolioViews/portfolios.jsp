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
    <link href="css/custom.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="css/theme.css" rel="stylesheet" media="all">
    <link href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css" rel="stylesheet">

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
                        <a  id= "createPortfolio" class="js-arrow" href="#">
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
                    <div class = "row">
                        <div class="col-xl-12">
                            <!-- PAGE CONTENT-->
                            <div class="page-content">
                                <div class="row">
                                    <div class="col-lg-6">
                                        <div class="card">
                                            <div class="card-header">
                                                <strong>Trade</strong>
                                            </div>
                                            <div class="card-body card-block">
                                                <div class="row form-group">
                                                    <div class="col col-md-3">
                                                        <label for="selectType" class=" form-control-label">Type</label>
                                                    </div>
                                                    <div class="col-12 col-md-6">
                                                        <select name="selectLg" id="selectType" class="form-control-lg form-control"
                                                                onchange="selectTypeOnchang(this)">
                                                            <option value="bonds">Bonds</option>
                                                            <option value="equity">Equity</option>
                                                            <option value="futures">Futures</option>
                                                            <option value="etfs">ETFS</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="row form-group">
                                                    <div class="col col-md-3">
                                                        <label for="selectSymbol" class=" form-control-label">Company</label>
                                                    </div>
                                                    <div class="col-12 col-md-6">
                                                        <select id="selectSymbol" class="selectpicker form-control"  data-live-search="true"
                                                        onchange="selectSymbolOnchang(this)">
                                                        </select>
                                                    </div>
                                                    <!--<div class="col-12 col-md-6">-->
                                                        <!--<select name="select" id="selectSymbol2" class="form-control"-->
                                                                <!--onchange="selectOnchang(this)">-->
                                                            <!--<option value="0">Google</option>-->
                                                            <!--<option value="1">Apple</option>-->
                                                            <!--<option value="2">Baidu</option>-->
                                                            <!--<option value="3">Alibaba</option>-->
                                                        <!--</select>-->
                                                    <!--</div>-->
                                                </div>
                                                <div class="row form-group">
                                                    <div class="col col-md-3">
                                                        <label for="quantity-input" class=" form-control-label">Quitity</label>
                                                    </div>
                                                    <div class="col-12 col-md-6">
                                                        <input type="number" id="quantity-input" name="text-input"
                                                               placeholder="quantity" class="form-control" required>
                                                        <small class="form-text text-muted">This is required</small>
                                                        <!--<small class="form-text text-muted"></small>-->
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col marginLeft">
                                                        <button type="button" class="btn btn-primary" id="buyPosition">Buy</button>
                                                    </div>
                                                    <div class="col marginRight">
                                                        <button type="button" class="btn btn-primary" id="sellPosition">Sell</button>
                                                    </div>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-6">
                                        <!-- CHART PERCENT-->
                                        <div class="card">
                                            <div class="card-header">
                                                <strong id = "chartDate">line chart</strong>
                                            </div>
                                            <div class="card-body card-block">
                                                <canvas id="myChart"></canvas>
                                            </div>
                                        </div>
                                        <!-- END CHART PERCENT-->
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="card">
                                            <div class="card-header">
                                                <div class="row">
                                                    <div class="col-md-3">
                                                       <span id ="portfolioName"><strong>Portfolio</strong></span>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <form class="form-inline" role="form">
                                                            <div class="form-group">
                                                                <label class="form-label">curCash</label>
                                                                <Button id = "curCash" class ="btn btn-info contentPading">20</Button>
                                                            </div>
                                                        </form>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <form class="form-inline" role="form">
                                                            <div class="form-group">
                                                                <label class="form-label">curValue</label>
                                                                <Button id = "curValue" class ="btn btn-info contentPading">25</Button>
                                                            </div>
                                                        </form>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <form class="form-inline" role="form">
                                                            <div class="form-group">
                                                                <label class="form-label">profit/loss</label>
                                                                <Button id = "offset" class ="btn btn-info contentPading">5</Button>
                                                            </div>
                                                        </form>
                                                    </div>
                                                    <!--<div class="col-md-2">-->
                                                        <!--<form class="form-inline" role="form">-->
                                                            <!--<div class="form-group">-->
                                                                <!--<label class="form-label">Percentage</label>-->
                                                                <!--<Button class ="btn btn-info contentPading">20%</Button>-->
                                                            <!--</div>-->
                                                        <!--</form>-->
                                                    <!--</div>-->
                                                </div>

                                            </div>
                                            <div class="card-body">
                                                <table id ="showPositions" class="table">
                                                    <thead>
                                                    <tr>
                                                        <th>Symbol</th>
                                                        <th>Type</th>
                                                        <th>Qty</th>
                                                        <th>Price</th>
                                                        <th>Value(USD)</th>
                                                        <th>CurValue</th>
                                                        <th>Profit/Loss</th>
                                                        <th>Date</th>
                                                    </tr>
                                                    </thead>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- END PAGE CONTENT-->
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="copyright">
                                <p>Copyright © 2018 Colorlib. All rights reserved. Template by <a href="https://colorlib.com">Colorlib</a>.</p>
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
                        <input type="text" name="portfolio_name" class="form-control" id="portfolio_name" placeholder="name">
                        <small class="form-text text-muted">This is required</small>
                    </div>
                    <div class="form-group">
                        <label for="portfolio_cash">Cash</label>
                        <input type="text" name="portfolio_cash" class="form-control" id="portfolio_cash" placeholder="cash">
                        <small class="form-text text-muted">This is required</small>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>Close</button>
                    <button type="button" id="btn_submit" class="btn btn-primary" data-dismiss="modal"><span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>Save</button>
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

<!-- Main JS-->
<script src="js/main.js"></script>
<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script src="js/portfolioJs.js"></script>
<script src="js/commonJs.js"></script>

</body>

</html>
<!-- end document-->
