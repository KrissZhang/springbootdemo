<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>Index Page</title>
    <script type="application/javascript" src="static/3rd_lib/jQuery/jquery-3.4.1.min.js"></script>
    <script type="application/javascript" src="static/js/common.js"></script>
    <script type="application/javascript">
        /**
         * 跳转到test1页面
         */
        function goTest1() {
            var url = "/test/toTest1?id=3";
            common.loadPage(url);
        }
    </script>
</head>
<body>
    <h1>This is index page</h1>
    <br />
    <input type="button" id="btn" name="btn" value="go test1!!!" onclick="goTest1()" />
</body>
</html>