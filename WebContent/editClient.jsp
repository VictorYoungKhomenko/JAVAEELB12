<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit client</title>
</head>
<body>
<h3>Edit client</h3>
<form method="post">
<input type="hidden" value="${client.id}" name="id" />
<label>Name</label><br>
<input name="firstName" value="${client.firstName}" /><br><br>
<label>Price</label><br>
<input name="phoneNumber" value="${client.phoneNumber}"/><br><br>
<input type="submit" value="Apply" />
</form>
</body>
</html>