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
    <link href="https://cdn.bootcss.com/bootstrap/4.1.1/css/bootstrap-grid.min.css" rel="stylesheet">

    <!-- Vendor CSS-->
    <link href="vendor/animsition/animsition.min.css" rel="stylesheet" media="all">
    <link href="vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet" media="all">
    <link href="vendor/wow/animate.css" rel="stylesheet" media="all">
    <link href="vendor/css-hamburgers/hamburgers.min.css" rel="stylesheet" media="all">
    <link href="vendor/slick/slick.css" rel="stylesheet" media="all">
    <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="vendor/perfect-scrollbar/perfect-scrollbar.css" rel="stylesheet" media="all">


    <!-- Main CSS-->
    <link href="css/theme.css" rel="stylesheet" media="all">
    <link href="css/custom.css" rel="stylesheet" media="all">
    <link href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css" rel="stylesheet">


</head>

<body class="animsition">
<div class="page-wrapper">
    <!-- MENU SIDEBAR-->
    <aside class="menu-sidebar d-none d-lg-block">
        <div class="navbar-header logo">
            <a class="navbar-brand" href="index.jsp">FundManager</a>
        </div>
        <div class="menu-sidebar__content js-scrollbar1">
            <nav class="navbar-sidebar">
                <ul class="list-unstyled navbar__list">
                    <li class="active has-sub">
                        <a id = "create" class="js-arrow" >
                            <i class="fas fa-tachometer-alt"></i>Create</a>
                    </li>
                    <li>
                        <a id = "information" onclick="handleNavbar(this)">
                            <i class="fas fa-chart-bar"></i>Information</a>
                    </li>
                    <li>
                        <a id = "report" href="#" onclick="handleNavbar(this)">
                            <i class="fas fa-table"></i>Report</a>
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
            <header class="header-desktop3 d-none d-lg-block">
                <div class="section__content section__content--p35">
                    <div class="header__navbar">
                        <ul class="list-unstyled">
                            <li class="has-sub">
                                <a id ="bonds" href = "#" onclick="handleDisplayInformation(this)">
                                    <i class="fas fa-tachometer-alt"></i>Bonds
                                    <span class="bot-line"></span>
                                </a>
                            </li>
                            <li>
                                <a id ="equities"  href = "#"  onclick="handleDisplayInformation(this)">
                                    <i class="fas fa-shopping-basket"></i>
                                    <span class="bot-line"></span>Equity</a>
                            </li>
                            <li>
                                <a id="futures"  href = "#" onclick="handleDisplayInformation(this)">
                                    <i class="fas fa-trophy"></i>
                                    <span class="bot-line"></span>Futures</a>
                            </li>
                            <li >
                                <a id="etfs"  href = "#" onclick="handleDisplayInformation(this)">
                                    <i class="fas fa-copy"></i>
                                    <span class="bot-line"></span>ETFS</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </header>
            <div class = "row">
                <div class="col-md-3 marginTop">
                <form class="form-header" action="" method="POST">
                    <input class="au-input au-input--xl" type="text" name="search" placeholder="Search for datas &amp; reports..." />
                    <button class="au-btn--submit" type="submit">
                        <i class="zmdi zmdi-search"></i>
                    </button>
                </form>
                </div>
            </div>
            <div class="row marginTop">
                <table id="showTypeInfo" class="table">
                    <thead>
                    <tr>
                        <th>Symbol</th>
                        <th>Price</th>
                        <th>Currency</th>
                        <th>Date</th>
                    </tr>
                    </thead>
                </table>
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
                <button type="button" id="btn_submit" class="btn btn-primary" data-dismiss="modal"><span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>Submit</button>
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
<script>

    $(document).ready(function(){
        receiveData("equities");

    });
    function handleDisplayInformation(e) {
        var productType = e.getAttribute("id");
        console.log(productType);
        receiveData(productType);
    }
    function receiveData(type){
        $.ajax({
            url: '/getTypeInformation',
            type:'POST',
            data:{type:type},
            success:function(response){
                console.log(response);
                displayTable(response);

            }
         });
    }
    function displayTable(data){
        if( $('#showTypeInfo').dataTable()){
            $('#showTypeInfo').dataTable().fnDestroy();
        }
        $('#showTypeInfo').DataTable( {
            data: data,
            columns: [
                { data: 'symbol' },
                { data: 'price' },
                { data: 'ccy' },
                { data: 'date' }
            ]
        } );
    }

</script>
<script src="js/commonJs.js"></script>
</body>

</html>
<!-- end document-->
