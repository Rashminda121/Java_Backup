<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!---Custom CSS File--->
<link rel="stylesheet" href="stylereg.css" />

<%@include file="headerLinks.jsp"%>

</head>

<body>
	<%@ include file="header2.jsp"%>

	<section class="container">
		<header>Registration Form</header>
		
		<form action="#" class="form">
			<div class="input-box">

				<input type="text"
					placeholder="Enter full name" required />
			</div>

			<div class="input-box">
				
				<input type="text"
					placeholder="Enter email address" required />
			</div>
			<div class="column">
				<div class="input-box">
					 <input type="password"
						placeholder="Enter password" required />
				</div>
				<div class="input-box">
					 <input type="password"
						placeholder="Enter password again" required />
				</div>
			</div>

			<div class="column">
				<div class="input-box">
					 <input type="number"
						placeholder="Enter phone number" required />
				</div>
				<div class="input-box">
					<input type="number"
						placeholder=" Enter pin code" required />
				</div>
			</div>

			<div class="input-box address ">
				
<!-- 				 <input type="text" -->
<!-- 					placeholder="Enter the address" required /> -->
				<textarea name="address" class="adesign" id="last_name"
						name="last_name" required placeholder="Enter the address"></textarea>

			</div>
			<button class="bdesign">Submit</button>
			<div class="login-link">
				<p>
					Already have an account? <a href="login2.jsp" >Login</a>
				</p>
			</div>
		</form>
	</section>

	<%-- 	<%@ include file="footer.html"%> --%>

</body>
</html>