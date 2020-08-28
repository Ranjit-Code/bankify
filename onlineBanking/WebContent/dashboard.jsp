
<%@page import="java.util.Hashtable"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@ page import="javax.servlet.*"%>
<%@ page import="bankify.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

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

		<%@ include file="navigationBar.html" %>

		<table style="width: 897px; background: #FFFFFF; margin: 0 auto;">
			<tr>
				<td width="300" valign="top"
					style="border-right:#000 2px solid;">
					<div id="services">
						<h1>Savings Account</h1>
						<br>
						<c:set var="i" value="1" />
						<c:forEach items="${balance}" var="u">
							<c:if test="${u.accountType eq 'SAVINGS'}">
								<p>A/C no: ${u.accountno}</p>
								<p>Balance: $ ${u.amount}</p>
							</c:if>
							<c:set var="i" value="${i+1}" />
						</c:forEach>
					</div>
				</td>

				<td width="1200" valign="top"
					style="border-right: #000 2px solid;">
					<div id="services">
						<h1>Checking Account</h1>
						<br>
						<c:set var="i" value="1" />
						<c:forEach items="${balance}" var="u">
							<c:if test="${u.accountType eq 'CHECKING'}">
								<p>A/C no: ${u.accountno}</p>
								<p>Balance: $ ${u.amount}</p>
							</c:if>
							<c:set var="i" value="${i+1}" />
						</c:forEach>
					</div>
				</td>

				<td width="1200" valign="top">
					<div id="services">
						<h1>GIC Account</h1>
						<br>
						<c:set var="i" value="1" />
						<c:forEach items="${balance}" var="u">
							<c:if test="${u.accountType eq 'GIC'}">
								<p>A/C no: ${u.accountno}</p>
								<p>Balance: $ ${u.amount}</p>
							</c:if>
							<c:set var="i" value="${i+1}" />
						</c:forEach>
					</div>
				</td>
			</table>

		<%@ include file="Footer.html" %>

		<script type="text/javascript">
			document.onload = ctck();
		</script>
	</div>