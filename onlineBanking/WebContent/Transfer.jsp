<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<SCRIPT LANGUAGE="JavaScript">
	function dil(form) {
		for (var i = 0; i < form.elements.length; i++) {
			if (form.elements[i].value == "") {
				alert("Fill out all Fields")
				document.F1.username.focus()
				return false
			}
		}

		return true
	}
</SCRIPT>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Bankify</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	function ctck() {
		var sds = document.getElementById("dum");

	}
</script>

</head>

<body>

	<div id="top_links">

		<%@ include file="Header.html" %>

		<%@ include file="navigationBar.html"%>

		<table style="width: 897px; background: #FFFFFF; margin: 0 auto;">
			<tr>
				<td width="1200" valign="top">
					<div id="welcome">
						<h1>TRANSFER AMOUNT</h1>
						<br>
						<table align="center" bgcolor="white">
							<tr>

							</tr>
							<tr>
								<td>
									<form name=F1 onSubmit="return dil(this)" action="Transfer"
										method="post">
										<table cellspacing="5" cellpadding="3">
											<tr>
												<td><label for="accountType">YOUR ACCOUNT TYPE:</label></td>
												<td><select name="accountType" id="accountType">
														<option value="savings">SAVINGS</option>
														<option value="Checking">CHECKING</option>
														<option value="gic">GIC</option>
												</select></td>
											</tr>
											
											<tr>
												<td>RECEIVER ACCOUNT NO:</td>
												<td><input type="text" name="toAccountNumber" /></td>
											</tr>
											<tr>
												<td><label for="accountType">RECEIVER ACCOUNT TYPE:</label></td>
												<td><select name="recaccountType" id="accountType">
														<option value="savings">SAVINGS</option>
														<option value="Checking">CHECKING</option>
														<option value="gic">GIC</option>
												</select></td>
											</tr>
											
											<tr>
												<td>AMOUNT:</td>
												<td><input type="text" name="amountTransfer" /></td>
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
									</form>
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