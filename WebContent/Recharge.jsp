<%@page import="org.apache.catalina.ant.SessionsTask"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recharge | SaveTime</title>
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
select, option {
	width: 100%;
	display: block;
	outline: none;
	border: none;
	color: #999;
	border-bottom: 1px solid #999;
	padding: 4px 28px;
	font-family: Poppins;
	box-sizing: border-box;
}

select:focus, option:focus {
	color: black;
}

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

h3 {
	color: white;
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
	<%!String msg,m = null;%>
		<%
		if (!session.isNew()) {
			msg = (String) session.getAttribute("recharge");
			m = (String) session.getAttribute("rech");
			if(msg != null){
				%>
			<script type="text/javascript">
				alert("Recharge Successfully");
			</script>
			<%
			}
			
			else if(m != null){
				%>
			<script type="text/javascript">
				alert("Amount is greater than your existing balance...Plzz try again !");
			</script>
			<%
			}
		}
		
		%>
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
									<li class="active"><a href="#">Recharge</a></li>
									<li><a href="Transaction.jsp">Transactions</a></li>
									<li><a href="history.jsp">History</a></li>
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
	<br>
	<br>
	<!-- codee -->
	<section class="signup">
		<!-- Sign up form -->

		<div class="container">
			<div class="signup-content">
				<div class="signup-form">
					<h2 class="form-title">Mobile Recharge</h2>
					<form method="POST" class="register-form" id="register-form"
						action="RechargeController">

						<div class="form-group">
							<label for="mobile"><i class="zmdi zmdi-phone"></i></label> <input
								type="text" name="mobile" id="mobile"
								title="Must contain 10 digits and it starts from 7,8 or 9"
								pattern="[789][0-9]{9}" placeholder="Mobile Number" required />
						</div>
						<div class="form-group">
							<label for="amount"><i class="zmdi zmdi-balance-wallet"></i></label>
							<input type="number" name="amount" id="amount" pattern="[0-9]+"
								placeholder="Amount" required />
						</div>
						<div class="form-group">
							<label for="service"><i class="zmdi zmdi-balance-wallet"></i></label>

							<select name="service">
								<option selected disabled>Select Service Provider</option>
								<option value="bsnl">BSNL</option>
								<option value="airtel">Airtel</option>
								<option value="idea">Idea</option>
								<option value="vodafone">Vodafone</option>
								<option value="jio">Jio</option>
							</select>
						</div>


						<div class="form-group">
							<input type="checkbox" name="agree-term" id="agree-term"
								class="agree-term" /> <label for="agree-term"
								class="label-agree-term"><span><span></span></span>I
								agree all statements in <a href="#" class="term-service">Terms
									of service</a></label>
						</div>

						<div class="form-group form-button">
							<input type="submit" name="recharge" id="recharge"
								class="form-submit" value="Recharge Now" />
						</div>
					</form>
				</div>
				<div class="signup-image">
					<figure>
						<img src="images/rech.jpg" alt="recharge image">
					</figure>
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