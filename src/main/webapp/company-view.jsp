<%@page import="com.job.model.Companies"%>

<%

Companies company =
(Companies)request.getAttribute("company");

%>

<!DOCTYPE html>

<html>

<head>

<title>View Company</title>

</head>

<body>

<h2>Company Details</h2>

<p>

ID :

<%=company.getId()%>

</p>

<p>

Name :

<%=company.getName()%>

</p>

<p>

Description :

<%=company.getDescription()%>

</p>

<p>

Website :

<%=company.getWebsite()%>

</p>

<p>

Headquarters :

<%=company.getHeadquarters()%>

</p>

<a href="company?action=list">

Back

</a>

</body>

</html>