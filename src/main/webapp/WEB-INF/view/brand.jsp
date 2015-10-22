<!DOCTYPE html>
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   <title>Brand</title>
   <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
   <script src="js/jquery-2.1.4.js"></script>
   <script src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<form class="form-horizontal" role="form" action="brand/add">
	  <div class="form-group">
	      <label for="logoBigUrl" class="col-sm-2 control-label">logoBigUrl</label>
	      <div class="col-sm-10">
	         <input type="text" class="form-control" id="logoBigUrl" name="logoBigUrl"
	            placeholder="logoBigUrl">
	      </div>
	   </div>
	   <div class="form-group">
	      <label for="name" class="col-sm-2 control-label">品牌名</label>
	      <div class="col-sm-10">
	         <input type="text" class="form-control" id="name" name="name"
	            placeholder="品牌名">
	      </div>
	   </div>
	   <div class="form-group">
	      <label for="enName" class="col-sm-2 control-label">英文名</label>
	      <div class="col-sm-10">
	         <input type="text" class="form-control" id="enName" name="enName"
	            placeholder="英文名">
	      </div>
	   </div>
	   <div class="form-group">
	      <label for="description" class="col-sm-2 control-label">description</label>
	      <div class="col-sm-10">
	         <input type="text" class="form-control" id="description" name="description"
	            placeholder="description">
	      </div>
	   </div>
	   <div class="form-group">
	      <div class="col-sm-offset-2 col-sm-10">
	         <button type="submit" class="btn btn-default">Submit</button>
	      </div>
	   </div>
	</form>
</body>
</html>