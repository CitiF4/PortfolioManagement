<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <!-- Bootstrap CSS-->
    <link href="vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet" media="all">
    <!-- Jquery JS-->
    <script src="vendor/jquery-3.2.1.min.js"></script>
    <!-- Bootstrap JS-->
    <script src="vendor/bootstrap-4.1/popper.min.js"></script>
    <script src="vendor/bootstrap-4.1/bootstrap.min.js"></script>
    <script>
        //注册新增按钮的事件
     function showAdd () {
            console.log("hello");
            console.log("hello");
//            $("#myModalLabel").text("新增");
            $('#myModal').modal();
        }
    </script>
</head>
<body>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">New Portfolio</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
            </div>
            <div class="modal-body">

                <div class="form-group">
                    <label for="txt_departmentname">Portfolio Name</label>
                    <input type="text" name="txt_departmentname" class="form-control" id="txt_departmentname" placeholder="name">
                </div>
                <div class="form-group">
                    <label for="txt_parentdepartment">Cash</label>
                    <input type="text" name="txt_parentdepartment" class="form-control" id="txt_parentdepartment" placeholder="cash value">
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>关闭</button>
                <button type="button" id="btn_submit" class="btn btn-primary" data-dismiss="modal"><span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>保存</button>
            </div>
        </div>
    </div>
</div>
<Button id ="add" onclick="showAdd()">add</Button>
</body>
</html>