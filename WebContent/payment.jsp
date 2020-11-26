<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payments</title>
<style>
table, tr, td, th {
    border: 1px solid #ccc;
}
</style>
</head>
<body>
<h2>Payments List</h2>
<p><a href='<c:url value="/menu" />' style="color: #000000; text-decoration:none; padding: 5px 30px; border: 1px solid black;">Back to menu</a></p>
<p><a href='<c:url value="/createPayment" />' style="color: #FFA500; text-decoration:none; padding: 5px 30px; border: 1px solid black;">Create new payment</a></p>
<p><a href='<c:url value="/searchPayment" />' style="color: #4682B4; text-decoration:none; padding: 5px 30px; border: 1px solid black;">Search payment by phone number</a></p>
<table style="border: 1px solid #ccc">
<tr><th>Phone Number</th><th>Total</th><th>Actions</th></tr>
<c:forEach var="payment" items="${payments}">
 <tr><td>${payment.phoneNumber}</td>
    <td>${payment.total}</td>
    <td>
    <a href='<c:url value="/editPayment?id=${payment.id}"/>' style="text-decoration: none; color: green; padding: 5px 30px; border: 2px solid black; border-radius: 5px; display: inline-block" >Edit payment</a>
    <form method="post" action='<c:url value="/deletePayment" />' style="display:inline;">
        <input type="hidden" name="id" value="${payment.id}">
        <input type="submit" value="Delete payment" style="color: red; border-radius: 5px; padding: 6px 30px; background-color: white; border-color: black">
    </form>
 </td></tr>
</c:forEach>
</table>
</body>
</html>