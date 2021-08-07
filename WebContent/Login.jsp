<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Login Here | SaveTime</title>
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
h4 {
	color: red;
}

#col {
	color: green;
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
						<a href="#" class="text-white mb-0"><h3 style="color: black;">SaveTime</h3>
						</a>
					</h1>
				</div>
				<div class="col-12 col-md-10 d-none d-xl-block">
					<nav class="site-navigation position-relative text-right"
						role="navigation">

						<ul class="site-menu js-clone-nav mr-auto d-none d-lg-block">
							<li><a href="index.jsp"><span style="color: black;">Home</span></a></li>
							<li><a href="Register.jsp"><span style="color: black;">Sign
										Up</span></a></li>
							<li class="active"><a href="Login.jsp"><span
									style="color: black;">Sign In</span></a></li>

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
	<%!String un = null;
	String m = null;
	int fl = 0;%>
	<%
	if (!session.isNew()) {
		un = (String) session.getAttribute("reg");
		m = (String) session.getAttribute("log");
		if (m != null) {
	%>
	<script type="text/javascript">
		alert("NOT REGISTRED");
	</script>
	<%
	}
		else if (un != null) {
	%>
	<script type="text/javascript">
		alert("Registered SuccessFully");
	</script>

	<%
	}
	}
	
	%>
	<br>
	<section class="sign-in">
		<div class="container">
			<div class="signin-content">
				<div class="signin-image">
					<figure>
						<img src="images/signin-image.jpg" alt="sing up image">
					</figure>
					<a href="Register.jsp" class="signup-image-link">Create an
						account</a>
				</div>

				<div class="signin-form">
					<h2 class="form-title">Sign in</h2>
					<form method="POST" class="register-form" id="login-form"
						action="LoginController">
						<div class="form-group">
							<label for="username"><i
								class="zmdi zmdi-account material-icons-name"></i></label> <input
								type="text" name="username" id="username"
								pattern="^([A-Za-z]+[,.]?[ ]?|[A-Za-z]+['-]?)+$"
								placeholder="Your UserName" required />
						</div>
						<div class="form-group">
							<label for="pass"><i class="zmdi zmdi-lock"></i></label> <input
								type="password" name="password" id="password"
								pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,12}$"
								title="Must Contain 1 Uppercase letter or lowercase letter and minimum 2 digits"  placeholder="Password" required />
						</div>
						<div class="form-group">
							<input type="checkbox" name="remember-me" id="remember-me"
								class="agree-term" /> <label for="remember-me"
								class="label-agree-term"><span><span></span></span>Remember
								me</label>
						</div>
						<div class="form-group form-button">
							<input type="submit" name="signin" id="signin"
								class="form-submit" value="Log in" />
						</div>
					</form>
					<div class="social-login">
						<span class="social-label">Or login with</span>
						<ul class="socials">
							<li><a href="#"><i
									class="display-flex-center zmdi zmdi-facebook"></i></a></li>
							<li><a href="#"><i
									class="display-flex-center zmdi zmdi-twitter"></i></a></li>
							<li><a href="#"><i
									class="display-flex-center zmdi zmdi-google"></i></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- JS -->
	 <script src="vendor/jquery/jquery.min.js"></script>
    <script src="js/main.js"></script>
    <script src="js2/jquery-3.3.1.min.js"></script>
	<script src="js2/popper.min.js"></script>
	<script src="js2/bootstrap.min.js"></script>
	<script src="js2/jquery.sticky.js"></script>
	<script src="js2/main.js"></script>
</body>
</html>