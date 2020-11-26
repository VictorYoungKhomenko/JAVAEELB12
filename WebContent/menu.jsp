<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Commpayment Menu</title>
<style>
ul li a{
text-decoration:none;
font-size: 20px;
}
</style>
</head>
	<body>
			<div class="menu" align="center">
				<nav>
					<ul style="list-style: none">
						<li><a href="connection">Checking the connection to the DB</a></li>
						<li><a href="client">Clients</a></li>
						<li><a href="service">Services</a></li>
						<li><a href="payment">Payment</a></li>
						<li><a href="setCookie">Set Cookie</a></li>
						<li><a href="getCookie">Get Cookie</a></li>
						<li><a href="setSession">Set and Get Session (after page refresh)</a></li>
					</ul>
				</nav>
			</div>
	</body>
</html>