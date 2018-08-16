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
                    <img src="images/icon/logo.png" alt="Cool Admin" />
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
                            <a id="updatePrice" class="js-arrow" href="updatePrice.jsp">
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
                                            <img src="images/icon/avatar-01.jpg" alt="John Doe" />
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

                        <!--createReport-->
                        <!--<div class="row">-->
                        <!--<div class="col-lg-6">-->
                            <!--<div class="card">-->
                                <!--<div class="card-header"></div>-->
                                <!--<div class="card-body">-->
                                    <!--<div class="card-title">-->
                                        <!--<h3 class="text-center title-2">Report</h3>-->
                                        <!--<label class="text-sm-center mt-2 mb-1">Best Portfolio :</label>-->
                                        <!--<span id="bestPortfolioName"></span>-->
                                        <!--<br>-->
                                        <!--<label class="text-sm-center mt-2 mb-1">Its FundManager :</label>-->
                                        <!--<span id="bestfundManagerName"></span>-->
                                        <!--<br>-->
                                        <!--<label class="text-sm-center mt-2 mb-1">Worst Portfolio :</label>-->
                                        <!--<span id="worstPortfolioName"></span>-->
                                        <!--<br>-->
                                        <!--<label class="text-sm-center mt-2 mb-1">Its FundManager :</label>-->
                                        <!--<span id="worstfundManagerName"></span>-->
                                    <!--</div>-->
                                <!--</div>-->
                            <!--</div>-->
                        <!--</div>-->
                    <!--</div>-->

                        <!--createFundManager-->
                        <!--<div id="createFundManager" class="row">-->
                            <!--<div class="col-lg-6">-->
                                <!--<div class="card">-->
                                    <!--<div class="card-header"></div>-->
                                    <!--<div class="card-body">-->
                                        <!--<div class="card-title">-->
                                            <!--<h3 class="text-center title-2">FundManager</h3>-->
                                        <!--</div>-->
                                        <!--<hr>-->
                                        <!--<form action="" method="post" novalidate="novalidate">-->
                                            <!--<div class="form-group has-success">-->
                                                <!--<label for="cc-name1" class="control-label mb-1">Soeid</label>-->
                                                <!--<input id="cc-name1" name="cc-name" type="text" class="form-control cc-name valid" data-val="true" data-val-required="Please enter the soeid"-->
                                                       <!--autocomplete="cc-name" aria-required="true" aria-invalid="false" aria-describedby="cc-name-error">-->
                                                <!--<span class="help-block field-validation-valid" data-valmsg-for="cc-name" data-valmsg-replace="true"></span>-->
                                            <!--</div>-->
                                            <!--<div>-->
                                                <!--<button id="create-button1" type="submit" class="btn btn-lg btn-info btn-block">-->
                                                    <!--<span id="submit-button1">Create</span>-->
                                                <!--</button>-->
                                            <!--</div>-->
                                        <!--</form>-->
                                    <!--</div>-->
                                <!--</div>-->
                            <!--</div>-->
                        <!--</div>-->

                        <!--displayFundManager-->
                        <div class="row">
                            <!--<div class="col-md-4">-->
                                <!--<div class="card">-->
                                    <!--<div class="card-header">-->
                                        <!--<strong class="card-title mb-3">FundManager</strong>-->
                                    <!--</div>-->
                                    <!--<div class="card-body">-->
                                        <!--<div class="mx-auto mr-auto text-center d-block">-->
                                            <!--<h4 class="text-sm-center mt-2 mb-1">XS99159</h4>-->
                                            <!--<label class="text-sm-center mt-2 mb-1">Total Cash :</label>-->
                                            <!--<span>$2500</span>-->
                                            <!--<br>-->
                                            <!--<label class="text-sm-center mt-2 mb-1">Total Value :</label>-->
                                            <!--<span>$5000</span>-->
                                            <!--<br>-->
                                            <!--<label class="text-sm-center mt-2 mb-1">Profit Rate :</label>-->
                                            <!--<span>20%</span>-->
                                        <!--</div>-->
                                        <!--<hr>-->
                                        <!--<div class="table-data-feature">-->
                                            <!--<button class="item" data-toggle="tooltip" data-placement="top" title="Edit">-->
                                                <!--<i class="zmdi zmdi-edit"></i>-->
                                            <!--</button>-->
                                            <!--<button id="submit" class="item" data-toggle="tooltip" data-placement="top" title="Delete">-->
                                                <!--<i class="zmdi zmdi-delete"></i>-->
                                            <!--</button>-->
                                        <!--</div>-->
                                    <!--</div>-->
                                <!--</div>-->
                            <!--</div>-->
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- END PAGE CONTAINER-->
        <!--create fundmanager dialog-->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title" id="myModalLabel">New FundManager</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="fundManager_name">FundManager Name</label>
                            <input type="text" name="FundManager_name" class="form-control" id="fundManager_name" placeholder="name">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>Close</button>
                        <button type="button" id="btn_submit" onclick="submitFundManager(this)" class="btn btn-primary" data-dismiss="modal"><span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>Submit</button>
                    </div>
                </div>
            </div>
        </div>

        <!--create report dialog-->
        <div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel1">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title" id="myModalLabel1">Report</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                    </div>
                    <div class="modal-body">
                        <label class="text-sm-center mt-2 mb-1">Best Portfolio :</label>
                        <span id="bestPortfolioName"></span>
                        <br>
                        <label class="text-sm-center mt-2 mb-1">Its FundManager :</label>
                        <span id="itsBestfundManagerName"></span>
                        <br>
                        <label class="text-sm-center mt-2 mb-1">Worst Portfolio :</label>
                        <span id="worstPortfolioName"></span>
                        <br>
                        <label class="text-sm-center mt-2 mb-1">Its FundManager :</label>
                        <span id="itsWorstfundManagerName"></span>
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
    <script src="vendor/select2/select2.min.js"></script>

    <!-- Main JS-->
    <script src="js/main.js"></script>

    <script>
        $('#createFundManager').click(function(){
            $('#myModal').css('display', 'block');
            var modalHeight = $(window).height() / 2 - $('#myModal .modal-dialog').height() / 2;
            $('#myModal').find('.modal-dialog').css({
                'margin-top': modalHeight
            });
            $('#myModal').modal();
        });

        $('#myModal').on('shown.bs.modal', function (e) {
            // 关键代码，如没将modal设置为 block，则$modala_dialog.height() 为零
            $(this).css('display', 'block');
            var modalHeight = $(window).height() / 2 - $('#myModel .modal-dialog').height() / 2;
            $(this).find('.modal-dialog').css({
                'margin-top': modalHeight
            });
        });

        function submitFundManager(e) {
            //
            $.ajax({
                type:'POST',
                url:'/admin/createFundManager',
                data:{
                    name:$('#fundManager_name').val(),
                },
                dataType:'json',
                success:function(){
                    console.log("create success");
                    //get data from backend-model

                    // var fundManager = "${requestScope.fundManager}";
                    // fundManager = eval("(" + fundManager + ")");
                    // $.each(fundManager, function(i, result){
                    //     displayFMs(result);
                    // });
                }
            })
        }
    </script>

    <script>
        $('#createReport').click(function(){
            //get report information from database
            $.ajax({
                type:'get',
                url:'/admin/createReport',
                data:null,
                dataType:'json',
                success:function(){
                    //get data from backend-model

                    // var report = "${requestScope.report}";
                    // report = eval("(" + report + ")");
                    // $.each(report, function(i, result){
                    //     $("#bestPortfolioName").innerHTML = result.bestPortfolioName;
                    //     $("#itsBestFundManagerName").innerHTML = result.itsBestFundManagerName;
                    //     $("#worstPortfolioName").innerHTML = result.worstPortfolioName;
                    //     $("#itsWorstFundManagerName").innerHTML = result.itsWorstFundManagerName;
                    // });
                }
            });

            $('#myModal1').css('display', 'block');
            var modalHeight = $(window).height() / 2 - $('#myModal1 .modal-dialog').height() / 2;
            $('#myModal1').find('.modal-dialog').css({
                'margin-top': modalHeight
            });
            $('#myModal1').modal();
        });

        $('#myModal1').on('shown.bs.modal', function (e) {
            // 关键代码，如没将modal设置为 block，则$modala_dialog.height() 为零
            $(this).css('display', 'block');
            var modalHeight = $(window).height() / 2 - $('#myModel1 .modal-dialog').height() / 2;
            $(this).find('.modal-dialog').css({
                'margin-top': modalHeight
            });
        });

    </script>

    <script>
        // $('.card').click(function () {
        //     $(location).attr("href", "fundManager.jsp");
        // });

    function displayFMs(fm) {
        var card = '<div class="col-md-4"> <div class="card"> <div class="card-header"> <strong class="card-title mb-3">FundManager</strong> </div> <div class="card-body"> <div class="mx-auto mr-auto text-center d-block">';
        card += '<h4 id="name" class="text-sm-center mt-2 mb-1">'+ fm.name +'</h4><label class="text-sm-center mt-2 mb-1">Initial Cash :</label><span id="initialCash">'+ fm.initCash + '<label class="text-sm-center mt-2 mb-1">Total Cash :</label>'+ '<span id="cash">'+ fm.curCash + '</span>'+ '<br> <label class="text-sm-center mt-2 mb-1">Total Value :</label> <span id="value">'+ fm.value+ '</span> <br> <label class="text-sm-center mt-2 mb-1">Profit Rate :</label> <span id="rate">'+ fm.rate
            + '</span> </div> <hr> <div class="table-data-feature"> <button type="button" id="edit" class="item" data-toggle="tooltip" data-placement="top" title="Edit" onclick="editFM()"> <i class="zmdi zmdi-edit"></i> </button> <button  type="button" id="delete" class="item" data-toggle="tooltip" data-placement="top" title="Delete" onclick="deleteFM($(this))"> <i class="zmdi zmdi-delete"></i> </button> </div> </div> </div> </div>';
        $(".row").append(card);
    }

    function deleteFM(e) {
        // $('#delete').parent().prev().prev().find('h4').text()   checked;
        var name = e.parent().prev().prev().find('h4').innerHTML;
        $.ajax({
            url:"/admin/deleteFundManager" + name,
            contentType:"application/json",
            dataType:"json",
            type:"delete",
            // data:null,
            // async:true,
            success:function(response){
                for(var i = 0; i < response.length; i++){
                    displayFMs(response[i]);
                }
            }
        });
    }

    function editFM(e) {
        // $.ajax({
        //             url:"/admin/editFundManager",
        //             dataType:"json",
        //             type:"post", //编辑
        //             data:{
        //                 portfolioID:$("#name").text()
        //             },
        //             // async:true,
        //             success:function(response){
        //                     $("#name").text(response.name);
        //                 });
        //             }
        // });
    }


    $(document).ready(function () {
        $.ajax({
            url:"/getFundManager",
            dataType:"json",
//           data:{type:type},
            success:function(response){
                // console.log(response);
                for(var i = 0; i < response.length; i++){
                    displayFMs(response[i]);
                }
            }
        })
    });

    </script>
</body>

</html>
<!-- end document-->