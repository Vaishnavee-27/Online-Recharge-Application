<%@page import="Dao.RegisterDao"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="Model.*" %>
<!DOCTYPE html>
<html>
<head>
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
td
{
	color:black;
}
h4
{
	color:red;
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
						<a href="#" class="text-white mb-0"><h3 style="color:black">SaveTime</h3></a>
					</h1>
				</div>
				<div class="col-12 col-md-10 d-none d-xl-block">
					<nav class="site-navigation position-relative text-right"
						role="navigation">

						<ul class="site-menu js-clone-nav mr-auto d-none d-lg-block">
							<li ><a href="index.jsp"><span style="color:black;">Home</span></a></li>
							<li class="active"><a href="Register.jsp"><span  style="color:black;" >Sign Up</span></a></li>
							<li><a href="Login.jsp"><span  style="color:black;" >Sign In</span></a></li>

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
	<br><br><br><br><br>
	<%!String msg = null;%>
		<%
		if (!session.isNew()) {
			msg = (String) session.getAttribute("reg2");
			if (msg != null) {
		%>
		<script type="text/javascript">
			alert("Oops ! Username or Password is already Exists..");
		</script>
		<%
		}
		}
		
		%>
	<section class="signup">
        <!-- Sign up form -->
       
            <div class="container">
                <div class="signup-content">
                    <div class="signup-form">
                        <h2 class="form-title">Sign up</h2>
                        <form method="POST" class="register-form" id="register-form" action="RegisterController">
                            <div class="form-group">
                                <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="name" id="name" pattern="^([A-Za-z]+[,.]?[ ]?|[A-Za-z]+['-]?)+$"
                                placeholder="Your Name" required/>
                            </div>
                            <div class="form-group">
                                <label for="email"><i class="zmdi zmdi-email"></i></label>
                                <input type="email" name="email" id="email" placeholder="Your Email" required/>
                            </div>
                            <div class="form-group">
                            	<label for="mobile"><i class="zmdi zmdi-phone"></i></label>
                                <input type="text" name="mobno" id="mobno" title="Must contain 10 digits and it starts from 7,8 or 9"
								pattern="[789][0-9]{9}"
                                placeholder="Your Mobile Number" required/>
                            </div>
                            <div class="form-group">
                            	<label for="balance"><i class="zmdi zmdi-balance-wallet"></i></label>
                                <input type="number" name="balance" id="balance" pattern="[0-9]+"
                                placeholder="Your Balance" required/>
                            </div>
                            <div class="form-group">
                                <label for="username"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="username" id="username" pattern="^([A-Za-z]+[,.]?[ ]?|[A-Za-z]+['-]?)+$"
                                placeholder="Your UserName" required/>
                            </div>
                            <div class="form-group">
                                <label for="pass"><i class="zmdi zmdi-lock"></i></label>
                                <input type="password" name="password" id="password" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,12}$"
                                title="Must Contain 1 Uppercase letter or lowercase letter and minimum 2 digits" placeholder="Your Password" required/>
                            </div>
    
                            <div class="form-group">
                                <input type="checkbox" name="agree-term" id="agree-term" class="agree-term" />
                                <label for="agree-term" class="label-agree-term"><span><span></span></span>I agree all statements in  <a href="#" class="term-service">Terms of service</a></label>
                            </div>
                            
                            <div class="form-group form-button">
                                <input type="submit" name="signup" id="signup" class="form-submit" value="Register"/>
                            </div>
                        </form>
                    </div>
                    <div class="signup-image">
                        <figure><img src="images/signup-image.jpg" alt="sing up image"></figure>
                        <a href="Login.jsp" class="signup-image-link">I am already member</a>
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