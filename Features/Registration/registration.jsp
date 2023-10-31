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
	<%
	String message = request.getParameter("message");
	%>

	<section class="container">
		<header>Registration Form</header>
		
		<form action="./RegisterSrv" class="form" method="post">
		<div style="font-weight: bold;" class="text-center">
					<%
					if (message != null) {
					%>
					<p style="color: blue;">
						<%=message%>
					</p>
					<%
					}
					%>
				</div>
				<div></div>
			<div class="input-box">

				<input type="text" name="username" name="first_name" id="first_name"
					placeholder="Enter full name" required />
			</div>

			<div class="input-box">
				
				<input type="email" name="email"  id="last_name" name="last_name"
					placeholder="Enter email address" required />
			</div>
			<div class="column">
				<div class="input-box">
					 <input type="password" name="password" id="last_name"
							name="last_name"
						placeholder="Enter password" required />
				</div>
				<div class="input-box">
					 <input type="password" name="confirmPassword" name="confirmPassword"
						placeholder="Enter password again" required />
				</div>
			</div>

			<div class="column">
				<div class="input-box">
					 <input type="number" name="mobile" id="last_name"
							name="last_name"
						placeholder="Enter phone number" required />
				</div>
				<div class="input-box">
					<input type="number" name="pincode" id="last_name" name="last_name"
						placeholder=" Enter pin code" required />
				</div>
			</div>

			<div class="input-box address ">
				
<!-- 				 <input type="text" -->
<!-- 					placeholder="Enter the address" required /> -->
				<textarea name="address" class="adesign" id="last_name"
						name="last_name" required placeholder="Enter the address"></textarea>

			</div>
			<button type="submit" class="bdesign">Submit</button>
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