<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit service</title>
</head>
<body>
<h3>Edit service</h3>
<form method="post">
<input type="hidden" value="${service.id}" name="id" />
<label>Name</label><br>
<input name="name" value="${service.name}" /><br><br>
<label>Rate</label><br>
<input name="rate" value="${service.rate}" type="number"/><br><br>
<input type="submit" value="Apply" />
</form>
</body>
</html>