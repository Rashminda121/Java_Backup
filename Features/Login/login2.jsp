<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link rel="stylesheet" href="styles.css">
  <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
  
  <link rel="stylesheet" href="css/changes.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	
	<%@include file="headerLinks.jsp" %>
</head>
<body>


	<%@ include file="header2.jsp"%>


	<%
	String message = request.getParameter("message");
	%>
	<div class="wrapper">

		<form action="./LoginSrv" method="post" class="">
			<div style="font-weight: bold;" class="text-center">
				<h2 style="color: white;"><b>Login Form</b></h2>
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

			
			<div class="input-box">
				<input type="email" placeholder="Username" name="username"  id="last_name"  required>
				 <i class='bx bxs-user '></i>
			</div>
			<div class="input-box">
				<input type="password" placeholder="Password" required  name="password" id="last_name"> 
				<i class='bx bxs-lock-alt'></i>
			</div>
			<div class="remember-forgot">
				<label ><input type="checkbox" ><span style="text-weight:100;">Confirm</span></label>
				 <a
					href="#">Forgot Password</a>
			</div>
			<div class="row ">
					<div class="userSelect">
						<label for="userrole" class="lblLogin">Login As</label> 
						<select name="usertype"
							id="userrole" class="form-control sPadding sDes" required>
							<option value="customer"  class="opDesign" selected>CUSTOMER</option>
							<option style="" value="admin"  class="opDesign">ADMIN</option>
						</select>
					</div>
				</div>
			<button type="submit" class="btn">Login</button>
			<div class="register-link">
				<p>
					Don't have an account? <a href="#">Register</a>
				</p>
			</div>
		</form>
	</div>
<%-- 	<%@ include file="footer.html"%> --%>

</body>
</html>