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
    <title>Administrator</title>

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
                <img src="images/icon/logo.png" alt="Cool Admin"/>
            </a>
        </div>
        <div class="menu-sidebar__content js-scrollbar1">
            <nav class="navbar-sidebar">
                <ul class="list-unstyled navbar__list">
                    <li class="has-sub">
                        <a class="js-arrow" href="admin.jsp">
                            <i class="fas fa-tachometer-alt"></i>Dashboard</a>
                    </li>
                    <li class="has-sub">
                        <a id="createFundManager" class="js-arrow" href="#">
                            <i class="fas fa-copy"></i>AddFundmanager</a>
                    </li>
                    <li class="has-sub">
                        <a class="js-arrow" href="updatePrice.jsp">
                            <i class="fas fa-chart-bar"></i>Update Price</a>
                    </li>
                    <li class="has-sub">
                        <a id="createReport" class="js-arrow" href="#">
                            <i class="far fa-check-square"></i>Create Report</a>
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
                            <div class="account-wrap" style="float: right">
                                <div class="account-item clearfix js-item-menu">
                                    <div class="image">
                                        <img src="images/icon/avatar-01.jpg" alt="John Doe"/>
                                    </div>
                                    <div class="content">
                                        <a class="js-acc-btn" href="#">john doe</a>
                                    </div>
                                    <div class="account-dropdown js-dropdown">
                                        <div class="account-dropdown__footer">
                                            <a href="login.html">
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
                    <div class="row m-t-30">
                        <div class="col-md-12">
                            <div class="table-responsive m-b-40">
                                <table id="price" class="table table-borderless table-data3">
                                    <thead>
                                        <tr>
                                            <th>date</th>
                                            <th>symbol</th>
                                            <th>type</th>
                                            <th>price</th>
                                        </tr>
                                    </thead>
                                    <tbody id="updatePrice">
                                        <tr>
                                            <td id="date"></td>
                                            <td id="symbol"></td>
                                            <td id="type"></td>
                                            <td><input id="newPrice" type="text" value=""></td>
                                        </tr>
                                    </tbody>
                                </table>
                                <br>
                                <button id="submitPrice" type="submit" class="btn btn-secondary btn-lg active" style="float: right">Submit</button>
                            </div>
                        </div>
                    </div>
                    <div class="row m-t-30">
                        <div class="col-md-12">
                            <div class="table-responsive m-b-40">
                                <table id="rate" class="table table-borderless table-data3">
                                    <thead>
                                    <tr>
                                        <th>date</th>
                                        <th>base</th>
                                        <th>term</th>
                                        <th>rate</th>
                                    </tr>
                                    </thead>
                                    <tbody id="updateRate">
                                        <tr>
                                            <td title="rateDate"></td>
                                            <td id="base"></td>
                                            <td id="term"></td>
                                            <td><input id="newRate" type="text"></td>
                                        </tr>
                                    </tbody>
                                </table>
                                <br>
                                <button id="submitFxRate" type="submit" class="btn btn-secondary btn-lg active" style="float: right">Submit</button>
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
<script src="vendor/select2/select2.min.js"></script>

<!-- Main JS-->
<script src="js/main.js"></script>

<script>
    $(document).ready(function () {
        $.ajax({
            url: "/admin/getInformation",
            type: "get",
            // data: null,
            success: function (response) {
                var position = response.Position;
                var FXrate = response.FXrate;
                //get data from backend-model
                for (var i = 0; i < position.length; i++) {
                    var result = position[i];
                    var p = '<tr> <td class="date" contenteditable="true">' + result.date + '</td> <td class="symbol">' + result.symbol + '</td> <td class="type">' + result.type + '</td> <td class="newPrice" contenteditable="true">' + result.price + '</td> </tr>';
                    // $('#date').text();
                    // $('#date').text(new Date());
                    // $('#symbol').text();
                    // $('#type').text();
                    // $('#newPrice').val(result.price);
                    $("#updatePrice").append(p);
                }
                for (var j = 0; j < FXrate.length; j++) {
                    var result1 = FXrate[j];
                    var fxRate = '<tr> <td class="rateDate" contenteditable="true">' + result1.date + '</td> <td class="base">' + result1.base + '</td> <td class="term">' + result1.term + '</td> <td class="newRate" contenteditable="true">' + result1.rate + '</td> </tr>';
                    // $('#rateDate').text(result.date);
                    // $('#rateDate').text(new Date());
                    // $('#base').text(result.base);
                    // $('#term').text(result.term);
                    // $('#newRate').val(result.rate);
                    $('#updateRate').append(fxRate);
                }
            }

        });
    });


    $('#submitPrice').click(function () {
        var data = [];
        for(var i=0; i<$('.newPrice').length;i++){
            data.push({
                date: new Date(),
                symbol: $('.symbol')[i].innerHTML,
                type: $('.type')[i].innerHTML,
                price:$('.newPrice')[i].innerHTML
            });
        }
        $.ajax({
            url: "/admin/updatePrice",
            type: "post",
            data: data,
            success: function () {
                console.log("success.");
            }
        });
    });

    $('#submitFxRate').click(function () {
        var data = [];
        for(var i=0; i<$('.newRate').length;i++){
            data.push({
                date: new Date(),
                base: $('.base')[i].innerHTML,
                term: $('.term')[i].innerHTML,
                rate:$('.newRate')[i].innerHTML
            }) ;
        }
        $.ajax({
            url: "/admin/updateFxRate",
            type: "post",
            data: data,
            success: function () {
               console.log("success.");
            }
        });
    });

</script>
</body>

</html>
<!-- end document-->