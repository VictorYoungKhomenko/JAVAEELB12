<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find Payment</title>
<style>
table, tr, td, th {
    border: 1px solid #ccc;
}
</style>
</head>
<body>
<h2>Find List</h2>
<table>
<tr><th>Phone Number</th><th>Total</th></tr>
<c:forEach var="payment" items="${payments}">
 <tr><td>${payment.phoneNumber}</td>
    <td>${payment.total}</td></tr>
</c:forEach>
</table>
</body>
</html>