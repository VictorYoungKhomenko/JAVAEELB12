<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit payment</title>
</head>
<body>
<h3>Edit payment</h3>
<form method="post">
<input type="hidden" value="${payment.id}" name="id" />
<label>Phone Number</label><br>
<input name="phoneNumber" value="${payment.phoneNumber}" /><br><br>
<label>Total</label><br>
<input name="total" value="${payment.total}" type="number"/><br><br>
<input type="submit" value="Apply" />
</form>
</body>
</html>