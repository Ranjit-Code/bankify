

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Bankify</title>
<link href="style.css" rel="stylesheet" type="text/css">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<!-- jQuery library -->
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	
<script type="text/javascript">
	function ctck() {
		var sds = document.getElementById("dum");

	}
</script>

</head>

<body>

	<div id="top_links">


		<%@ include file="Header.html"%>

		<div id="navigation">
			<ul>
				<li><a href="Reg.jsp">REGISTERATION</a></li>
				<li><a href="Login.jsp">LOGIN</a></li>
			</ul>
		</div>

		<table style="width: 897px; background: #FFFFFF; margin: 0 auto;">
			<tr>

				<td width="1200" valign="top">
					<div id="welcome">
						<h1 style="text-align:center">REGISTERATION</h1>
						<br>
						<table align="center" bgcolor="white">
							<tr>

							</tr>
							<tr>
								<td>
									<form class="form-horizontal" name=F1 action="Register" onSubmit="return dil(this)" method="post">
										<div class="form-group">
											<label class="control-label col-sm-2" for="full_name">Fullname:</label>
											<div class="col-sm-10">
												<input type="text" name="full_name" style="margin-left:20px"  class="form-control" id="full_name"
													placeholder="Enter fullname">
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2" for="username">Username:</label>
											<div class="col-sm-10">
												<input type="text" name=username style="margin-left:20px"  class="form-control" id="username"
													placeholder="Enter username">
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2" for="password">Password:</label>
											<div class="col-sm-10">
												<input type="password" name="password" style="margin-left:20px" class="form-control" id="password"
													placeholder="Enter password">
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2" for="address">Address:</label>
											<div class="col-sm-10">
												<input type="text" name="address" style="margin-left:20px" class="form-control" id="address"
													placeholder="Enter address">
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2" for="phone">Phone</label>
											<div class="col-sm-10">
												<input type="text" name=phone style="margin-left:20px"  class="form-control" id="phone"
													placeholder="Enter phone number">
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-offset-2 col-sm-10">
												<div class="checkbox">
													<label><input type="checkbox"> Remember me</label>
												</div>
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-offset-2 col-sm-10">
												<button type="submit" class="btn btn-default">Submit</button>
											</div>
										</div>
									</form>
								</td>
							</tr>

						</table>
					</div>
				</td>
			</tr>
		</table>

		<%@ include file="Footer.html"%>

		<script type="text/javascript">
			document.onload = ctck();
		</script>
	</div>

</body>
</html>