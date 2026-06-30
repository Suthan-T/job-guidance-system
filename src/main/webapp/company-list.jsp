<%@page import="java.util.List"%>
<%@page import="com.job.model.Companies"%>

<%
List<Companies> companies =
(List<Companies>)request.getAttribute("companies");
%>

<!DOCTYPE html>

<html>

<head>

<title>Companies</title>

</head>

<body>

<h2>Company List</h2>

<a href="company-form.jsp">

Add New Company

</a>

<br><br>

<table border="1">

<tr>

<th>ID</th>
<th>Name</th>
<th>Description</th>
<th>Website</th>
<th>Headquarters</th>
<th>Action</th>

</tr>

<%

for(Companies c : companies){

%>

<tr>

<td><%=c.getId()%></td>

<td><%=c.getName()%></td>

<td><%=c.getDescription()%></td>

<td><%=c.getWebsite()%></td>

<td><%=c.getHeadquarters()%></td>

<td>

<a href="company?action=view&id=<%=c.getId()%>">

View

</a>

|

<a href="company?action=delete&id=<%=c.getId()%>">

Delete

</a>

</td>

</tr>

<%

}

%>

</table>

</body>

</html>