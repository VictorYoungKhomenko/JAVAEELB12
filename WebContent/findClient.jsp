<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find Client</title>
<style>
table, tr, td, th {
    border: 1px solid #ccc;
}
</style>
</head>
<body>
<h2>Find List</h2>
<table>
<tr><th>Name</th><th>Phone Number</th></tr>
<c:forEach var="client" items="${clients}">
 <tr><td>${client.firstName}</td>
    <td>${client.phoneNumber}</td></tr>
</c:forEach>
</table>
</body>
</html>