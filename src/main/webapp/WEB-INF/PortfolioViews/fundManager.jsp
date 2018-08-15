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
    <title>Card</title>

    <!-- Fontfaces CSS-->
    <link href="css/font-face.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
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

    <!-- Main CSS-->
    <link href="css/theme.css" rel="stylesheet" media="all">

</head>

<body class="animsition">
    <div class="page-wrapper">

        <!-- MENU SIDEBAR-->
        <aside class="menu-sidebar d-none d-lg-block">
            <div class="logo">
                <a href="#">
                    <img src="images/icon/logo.png" alt="Cool Admin" />
                </a>
            </div>
            <div class="menu-sidebar__content js-scrollbar1">
                <nav class="navbar-sidebar">
                    <ul class="list-unstyled navbar__list">
                        <li>
                            <a href="chart.html">
                                <i class="fas fa-chart-bar"></i>Add Portfolio</a>
                        </li>
                        <li class="has-sub">
                            <a class="js-arrow" href="fundManager.jsp">
                                <i class="fas fa-tachometer-alt"></i>Show Protfolios</a>
                        </li>
                        <!--<li>-->
                            <!--<a href="form.html">-->
                                <!--<i class="far fa-check-square"></i>Protfolios</a>-->
                        <!--</li>-->
                        <!--<li class="has-sub">-->
                            <!--<a class="js-arrow" href="#">-->
                                <!--<i class="fas fa-copy"></i>Pages</a>-->
                        <!--</li>-->

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
                                <div class="account-wrap" style="float: right">
                                    <div class="account-item clearfix js-item-menu">
                                        <div class="image">
                                            <img src="images/icon/avatar-01.jpg" alt="John Doe" />
                                        </div>
                                        <div class="content">
                                            <a class="js-acc-btn" href="#">john doe</a>
                                        </div>
                                        <div class="account-dropdown js-dropdown">
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
                            <div class="col-md-4">
                                <div class="card">
                                    <div class="card-header">
                                        <strong class="card-title mb-3">Portfolio</strong>
                                    </div>
                                    <div class="card-body">
                                        <div class="mx-auto mr-auto text-center d-block">
                                            <h4 id="name" class="text-sm-center mt-2 mb-1"></h4>
                                            <label class="text-sm-center mt-2 mb-1">Cash :</label>
                                            <span id="cash"></span>
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
                            <div class="col-md-4">
                                <div class="card">
                                    <div class="card-header">
                                        <strong class="card-title mb-3">Portfolio</strong>
                                    </div>
                                    <div class="card-body">
                                        <div class="mx-auto mr-auto text-center d-block">
                                            <h4 class="text-sm-center mt-2 mb-1">PortfolioName</h4>
                                            <label class="text-sm-center mt-2 mb-1">Cash :</label>
                                            <span>$1500</span>
                                            <br>
                                            <label class="text-sm-center mt-2 mb-1">Value :</label>
                                            <span>$3000</span>
                                            <br>
                                            <label class="text-sm-center mt-2 mb-1">Rate :</label>
                                            <span>10%</span>
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
        </div>
        <!-- END PAGE CONTAINER-->

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

    <script>
        $(document).ready(function() {
            $.ajax({
           url:"/getPortfolios",
           dataType:"json",
//           data:{type:type},
           success:function(response){
               console.log(response);
               for(var i = 0; i < response.length; i++){

                   displayProtfolios(response[i]);
               }
           }
       })});

        function displayProtfolios(protfolio) {
            var card = '<div class="col-md-4"> <div class="card"> <div class="card-header"> <strong class="card-title mb-3">Portfolio</strong> </div> <div class="card-body"> <div class="mx-auto mr-auto text-center d-block">';
            card += '<h4 id="name" class="text-sm-center mt-2 mb-1">'+ protfolio.name +'</h4> <label class="text-sm-center mt-2 mb-1">Cash :</label>'+ '<span id="cash">'+ protfolio.cash + '</span>'+ '<br> <label class="text-sm-center mt-2 mb-1">Value :</label> <span id="value">'+ protfolio.value+ '</span> <br> <label class="text-sm-center mt-2 mb-1">ProfitRate :</label> <span id="rate">'+ protfolio.rate
                + '</span> </div> <hr> <div class="table-data-feature"> <button type="button" id="edit" class="item" data-toggle="tooltip" data-placement="top" title="Edit" onclick="editProtfolio()"> <i class="zmdi zmdi-edit"></i> </button> <button  type="button" id="delete" class="item" data-toggle="tooltip" data-placement="top" title="Delete" onclick="deleteProtfolio()"> <i class="zmdi zmdi-delete"></i> </button> </div> </div> </div> </div>';
            $(".row").append(card);
        }

        function deleteProtfolio() {
            $.ajax({
                url:"/fundManager/deletePortfolio",
                dataType:"json",
                type:"get",
                data:{
                    portfolioID:$("#name").text()
                },
                // async:true,
                success:function(data){
                    for(var protfolio in data.parseJSON){
                        displayProtfolios(protfolio);
                    }
                }
            });
        }

        function editProtfolio() {
            $.ajax({
                url:"/fundManager/editPortfolio",
                dataType:"json",
                type:"get",
                data:{
                    portfolioID:$("#name").text()
                },
                async:true,
                success:function(){
                    $("#name").text(data.parseJSON.name);
                }
            });
        }
    </script>
    <script>
        $.ajax({
            url: "/fundManager",
            dataType: "json",
            type: "get",
            data: null,
            success: function () {
                // for (var portfolio in data.parseJSON) {
                //     displayPortfolios(portfolio);
                // }
                console.log("success");
            }
        });
    </script>

</body>

</html>
<!-- end document-->