<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<title>Add Company</title>
</head>

<body>

<h2>Add Company</h2>

<form action="company" method="post">

<input type="hidden"
name="action"
value="add">

Company Name

<input
type="text"
name="name">

<br><br>

Description

<input
type="text"
name="description">

<br><br>

Website

<input
type="text"
name="website">

<br><br>

Headquarters

<input
type="text"
name="headquarters">

<br><br>

<button type="submit">

Save Company

</button>

</form>

</body>

</html>