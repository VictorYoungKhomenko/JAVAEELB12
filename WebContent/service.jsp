<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Services</title>
<style>
table, tr, td, th {
    border: 1px solid #ccc;
}
</style>
</head>
<body>
<h2>Services List</h2>
<p><a href='<c:url value="/menu" />' style="color: #000000; text-decoration:none; padding: 5px 30px; border: 1px solid black;">Back to menu</a></p>
<p><a href='<c:url value="/createService" />' style="color: #FFA500; text-decoration:none; padding: 5px 30px; border: 1px solid black;">Create new service</a></p>
<p><a href='<c:url value="/searchService" />' style="color: #4682B4; text-decoration:none; padding: 5px 30px; border: 1px solid black;">Search service by rate</a></p>
<table style="border: 1px solid #ccc">
<tr><th>Name</th><th>Rate</th><th>Actions</th></tr>
<c:forEach var="service" items="${services}">
 <tr><td>${service.name}</td>
    <td>${service.rate}</td>
    <td>
    <a href='<c:url value="/editService?id=${service.id}"/>' style="text-decoration: none; color: green; padding: 5px 30px; border: 2px solid black; border-radius: 5px; display: inline-block" >Edit client</a>
    <form method="post" action='<c:url value="/deleteService" />' style="display:inline;">
        <input type="hidden" name="id" value="${service.id}">
        <input type="submit" value="Delete service" style="color: red; border-radius: 5px; padding: 6px 30px; background-color: white; border-color: black">
    </form>
 </td></tr>
</c:forEach>
</table>
</body>
</html>