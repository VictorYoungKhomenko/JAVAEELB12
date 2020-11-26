<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find Service</title>
<style>
table, tr, td, th {
    border: 1px solid #ccc;
}
</style>
</head>
<body>
<h2>Find List</h2>
<table>
<tr><th>Name</th><th>Rate</th></tr>
<c:forEach var="service" items="${services}">
 <tr><td>${service.name}</td>
    <td>${service.rate}</td></tr>
</c:forEach>
</table>
</body>
</html>