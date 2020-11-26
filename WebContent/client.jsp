<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Clients</title>
<style>
table, tr, td, th {
    border: 1px solid #ccc;
}
</style>
</head>
<body>
<h2>Clients List</h2>
<p><a href='<c:url value="/menu" />' style="color: #000000; text-decoration:none; padding: 5px 30px; border: 1px solid black;">Back to menu</a></p>
<p><a href='<c:url value="/createClient" />' style="color: #FFA500; text-decoration:none; padding: 5px 30px; border: 1px solid black;">Create new client</a></p>
<p><a href='<c:url value="/searchClient" />' style="color: #4682B4; text-decoration:none; padding: 5px 30px; border: 1px solid black;">Search client by first name</a></p>
<table style="border: 1px solid #ccc">
<tr><th>First Name</th><th>Phone Number</th><th>Actions</th></tr>
<c:forEach var="client" items="${clients}">
 <tr><td>${client.firstName}</td>
    <td>${client.phoneNumber}</td>
    <td>
    <a href='<c:url value="/editClient?id=${client.id}"/>' style="text-decoration: none; color: green; padding: 5px 30px; border: 2px solid black; border-radius: 5px; display: inline-block" >Edit client</a>
    <form method="post" action='<c:url value="/deleteClient" />' style="display:inline;">
        <input type="hidden" name="id" value="${client.id}">
        <input type="submit" value="Delete client" style="color: red; border-radius: 5px; padding: 6px 30px; background-color: white; border-color: black">
    </form>
 </td></tr>
</c:forEach>
</table>
</body>
</html>