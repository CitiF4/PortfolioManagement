<!DOCTYPE html>
<html>
<head>
	<title>Order Matching System</title>
	<script src="vendor/jquery-3.2.1.min.js"></script>
	<link rel="stylesheet" href="vendor/bootstrap-4.1/bootstrap.min.css" />
	<script src="vendor/bootstrap-4.1/bootstrap.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-bootgrid/1.3.1/jquery.bootgrid.js"/>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-bootgrid/1.3.1/jquery.bootgrid.fa.js"/>
	<link rel="stylesheet"
		  href="https://cdnjs.cloudflare.com/ajax/libs/jquery-bootgrid/1.3.1/jquery.bootgrid.css">

	<script>
		function showSymbol() {
            if($("#orderList").css("display")=='block'){
                $("#orderList").css("display","none");
            }
            if($("#sybmolList").css("display")=='none'){
                $("#sybmolList").css("display","block");
            }else{
                $("#orderList").css("display","none");
            }
        }
        function showOrder() {
            if($("#sybmolList").css("display")=='block'){
                $("#sybmolList").css("display","none");
            }
            if($("#orderList").css("display")=='none'){
                $("#orderList").css("display","block");
            }else{
                $("#sybmolList").css("display","none");
            }
        }
	</script>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<nav class="navbar navbar-inverse">
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar">*****</span>
						</button>
						<a class="navbar-brand" href="mainPage.html">Order Matching</a>
					</div>
					<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li><a href="login.html">Logout</a></li>
							<!-- <%=basePath %>trader/logout -->
						</ul>
					</div>
				</div>
			</nav>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<h2>Order Matching System</h2>
			<!-- <%=basePath %>order/orderList -->
			<!-- <%=basePath %>symbol/symbolList -->
			<a class="btn btn-primary" href="#" onclick="showOrder()">OrderList</a>
			<a class="btn btn-primary" href="#" onclick="showSymbol()">symbolList</a>
			<div class="btn-group"></div>
			<div class="orderList" id="orderList">
				<table id="grid-data" class="table table-condensed table-hover table-striped">
					<thead>
					<tr>
						<th data-column-id="orderId"  data-identifier="true" data-type="numeric">ID</th>
						<th data-column-id="symbol">symbol</th>
						<th data-column-id="traderId">traderId</th>
						<th data-column-id="side">side</th>
						<th data-column-id="Qty">Qty</th>
						<th data-column-id="price">price</th>
						<th data-column-id="FOK">FOK</th>
						<th data-column-id="condition">condition</th>
						<th data-column-id="status">status</th>
						<th data-column-id="commands" data-formatter="commands" data-sortable="false">Commands</th>
					</tr>
					</thead>
				</table>
			</div>
			<div class="symbolList" id="sybmolList" style="display: none;">
				<table id="grid-data2" class="table table-condensed table-hover table-striped">
					<thead>
					<tr>
						<th data-column-id="symbol"  data-identifier="true" data-type="numeric">ID</th>
						<th data-column-id="company">company</th>
						<th data-column-id="last_sale">lastSale</th>
						<th data-column-id="change_net">changeNet</th>
						<th data-column-id="share_volume">shareVolume</th>
						<th data-column-id="commands" data-formatter="commands" data-sortable="false">Commands</th>
					</tr>
					</thead>
				</table>
			</div>
		</div>
	</div>
</div>
<script>
    $(document).ready(function(){
        var grid = $("#grid-data").bootgrid({
            ajax:true,
            post: function ()
            {
                return {
                    id: "b0df282a-0d67-40e5-8558-c9e93b7befed"
                };
            },
            url:"#",
			// <%=basePath %>order/orderList
            formatters: {
                "commands": function(column, row)
                {
                    return "<button type=\"button\" class=\"btn btn-xs btn-default command-delete\" data-row-id=\"" + row.id + "\">Delete<span class=\"fa fa-trash-o\"></span></button>";
                }
            }
        }).on("loaded.rs.jquery.bootgrid", function()
		{
            grid.find(".command-delete").on("click", function(e)
            {
              		alert("You pressed delete on row: " + $(this).data("row-id"));
             		$.post("<%=basePath %>order/deleteOrder",{userId:$(this).data("row-id")},function(){
                    	alert("Delete Done");
                    	$("#grid-data").bootgrid("reload");
                }); 
            });
        });
    });

	$(document).ready(function(){
        var grid = $("#grid-data2").bootgrid({
            ajax:true,
            post: function ()
            {
                return {
                    id: "b0df282a-0d67-40e5-8558-c9e93b7befed"
                };
            },
            url:"#",
			// <%=basePath %>symbol/symbolList
            formatters: {
                "commands": function(column, row)
                {
                    return "<button type=\"button\" class=\"btn btn-xs btn-default command-delete\" data-row-id=\"" + row.id + "\">Delete<span class=\"fa fa-trash-o\"></span></button>";
                }
            }
        }).on("loaded.rs.jquery.bootgrid", function()
		{
            grid.find(".command-delete").on("click", function(e)
            {
              		alert("You pressed delete on row: " + $(this).data("row-id"));
             		$.post("<%=basePath %>order/addOrder",{symbol:$(this).data("row-id")},function(){
                    	// alert("Delete Done");
                    	// $("#grid-data").bootgrid("reload");
                }); 
            });
        });
    }); 
</script>
</body>
</html>