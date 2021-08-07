<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="Dao.*"%>
<%@ page import="Model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>History | SaveTime</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700"
	rel="stylesheet">

<link rel="stylesheet" href="fonts2/icomoon/style.css">

<link rel="stylesheet" href="css2/owl.carousel.min.css">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css2/bootstrap.min.css">

<!-- Style -->

<!-- Font Icon -->
<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css2/style.css">
<style>
body {
	background-image: url('pay1.jpg');
	background-repeat: no-repeat;
	background-size: cover;
	background-attachment: fixed;
	background-position: center center;
}

@media only screen and (max-width: 720px) {
	body {
		background-image: url('pay1.jpg');
	}
}

table {
	font-size: 15px;
	border: 1px solid black;
}

th, td {
	font-size: 15px;
	width: 400%;
}

#h {
	color: black;
}
</style>
</head>
<body>
	<div class="site-mobile-menu">
		<div class="site-mobile-menu-header">
			<div class="site-mobile-menu-close mt-3">
				<span class="icon-close2 js-menu-toggle"></span>
			</div>
		</div>
		<div class="site-mobile-menu-body"></div>
	</div>

	<header class="site-navbar" role="banner">
		<div class="container-fluid">
			<div class="row align-items-center">

				<div class="col-11 col-xl-2">
					<h1 class="mb-0 site-logo">
						<a href="#" class="text-white mb-0"><h3>
								<strong>SaveTime</strong>
							</h3></a>
					</h1>
				</div>
				<div class="col-12 col-md-10 d-none d-xl-block">
					<nav class="site-navigation position-relative text-right"
						role="navigation">
						<ul class="site-menu js-clone-nav mr-auto d-none d-lg-block">
							<li><a href="Dashboard.jsp"><span>Home</span></a></li>
							<li class="has-children"><a href="#"><span>Services</span></a>
								<ul class="dropdown arrow-top">
									<li><a href="Recharge.jsp">Recharge</a></li>
									<li><a href="#">Transactions</a></li>

									<li class="active"><a href="Transactions.jsp">History</a></li>
								</ul></li>
							<li class="has-children"><a href="#"><span>Profile</span></a>
								<ul class="dropdown arrow-top">
									<li><a href="EditProfile.jsp">Edit Profile</a></li>
								</ul></li>
							<li><a href="index.jsp"><span>Sign Out</span></a></li>
						</ul>
					</nav>
				</div>
				<div class="d-inline-block d-xl-none ml-md-0 mr-auto py-3"
					style="position: relative; top: 3px;">
					<a href="#" class="site-menu-toggle js-menu-toggle text-white"><span
						class="icon-menu h3"></span></a>
				</div>
			</div>
		</div>
	</header>
	<br>
	<br>
	<br>
	<section class="signup">
		<!-- Sign up form -->

		<div class="container" align="">
			<div class="signup-content">
				<div class="signup-form">
					<h3 id="h" class="form-title"><strong>Recharge Transactions</strong></h2>
					<c:if test="${requestScope.message !=null}">
					NOTE : ${message}
					</c:if>
					<c:if
						test="${requestScope.rech !=null and
 					not empty requestScope.rech}">

						<div class="table-responsive">
							<table class="table table-bordered table-hover table-striped">
								<thead>
									<tr>
										<th>Username</th>
										<th>Mobile No</th>
										<th>Amount</th>
										<th>Service Provider</th>
										<th>Date</th>
									</tr>
								</thead>
								<c:forEach items="${requestScope.rech}" var="c">
									<tbody>
										<tr>
											<td><c:out value="${c.usrname }" /></td>
											<td><c:out value="${c.mobno }" /></td>
											<td><c:out value="${c.amt }" /></td>
											<td><c:out value="${c.operator }" /></td>
											<td><c:out value="${c.date}" /></td>
										</tr>
								</c:forEach>
								</tbody>
							</table>
						</div>
					</c:if>
				</div>
			</div>
		</div>
	</section>
	<section class="signup">
		<!-- Sign up form -->

		<div class="container">
			<div class="signup-content">
				<div class="signup-form">
					<h3 id="h" class="form-title"><strong>Deposit/Withdrawl Transactions</strong></h3>
					<c:if
						test="${requestScope.rech2 !=null and
 					not empty requestScope.rech2}">

						<div class="table-responsive">
							<table class="table table-bordered table-hover table-striped">
								<thead>
									<tr>
										<th>Username</th>
										<th>Amount</th>
										<th>Date</th>
										<th>Transaction Type</th>
									</tr>
								</thead>

								<tbody>
									<c:forEach items="${requestScope.rech2}" var="d">
										<tr>
											<td><c:out value="${d.username }" /></td>
											<td><c:out value="${d.amount }" /></td>
											<td><c:out value="${d.date1 }" /></td>
											<td><c:out value="${d.type }" /></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>

					</c:if>
				</div>
			</div>
		</div>
	</section>

	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>
	<script src="js2/jquery-3.3.1.min.js"></script>
	<script src="js2/popper.min.js"></script>
	<script src="js2/bootstrap.min.js"></script>
	<script src="js2/jquery.sticky.js"></script>
	<script src="js2/main.js"></script>
</body>
</html>