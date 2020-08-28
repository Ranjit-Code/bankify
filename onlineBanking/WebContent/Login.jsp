<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<SCRIPT LANGUAGE="JavaScript">
</SCRIPT>

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


		<%@ include file="Header.html" %>

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
						<h1 style="text-align: center">LOGIN FORM</h1>
						<br>
						<table align="center" bgcolor="white">
							<tr>

							</tr>
							<tr>
								<td>
								
								<form class="form-horizontal" name=F1 action="Login" onSubmit="return dil(this)" method="post">
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
										<div class="form-group">
											<div class="col-sm-offset-2 col-sm-10">
												<p style="color: red; font: caption;">${message}</p>
											</div>
										</div>
									</form>
								
									<%-- <form name=F1 onSubmit="return dil(this)" action="Login"
										method="post">
										<table cellspacing="5" cellpadding="3">

											<tr>
												<td>USER NAME:</td>
												<td><input type="text" name="username" /></td>
											</tr>
											<tr>
												<td>PASSWORD:</td>
												<td><input type="password" name="password" /></td>
											</tr>
											<tr>
												<td></td>
												<td><input type="submit" value="Submit" /> <INPUT
													TYPE=RESET VALUE="CLEAR"></td>
											</tr>

											<tr>
												<td style="color: red; font: caption;">${message}</td>
											</tr>
										</table>
									</form> --%>
								</td>
							</tr>

						</table>
					</div>
				</td>


			</tr>
		</table>

		<%@ include file="Footer.html" %>

		<script type="text/javascript">
			document.onload = ctck();
		</script>
	</div>

</body>
</html>








<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Form</title>
</head>
<body>
<form action="Login" method="post">
		<table style="with: 50%">
 
			<tr>
				<td>UserName</td>
				<td><input type="text" name="username" /></td>
			</tr>
				<tr>
				<td>Password</td>
				<td><input type="password" name="password" /></td>
			</tr>
		</table>
		<input type="submit" value="Login" /></form>
</body>
</html> --%>