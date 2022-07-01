<%@page import="model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%-- 
<%@ taglib uri="https://java.sun.com/jsp/jstl/core" prefix="c" %> --%>


<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel='stylesheet'
	href='https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css'>

<title>Userlist</title>
</head>

<body>

	<div class="container p-3">

		<div class="page-header">
			<h1>Users</h1>
			<a href="signup">
				<button type="button" class="btn btn-outline-primary ms-1">Add
					Users</button>
			</a>
			
			<a href="postFeed">
				<button type="button" class="btn btn-outline-primary ms-1">Home</button>
			</a>

			<div style="width: 60%">

				<table class="table table-hover">
					<thead>
						<tr>
							<th>Id</th>
							<th>Username</th>
							<th>Password</th>
							<th>Email</th>
							<th>Phone Number</th>
							<th>Address</th>
							<th>Operations</th>

						</tr>
					</thead>
					<tbody>
						<%--  <c:forEach items="${userList}" var="user">
     <tr>
        <td>${user.username}</td>
        <td>${user.email}</td>
        <td>${user.phoneNumber}</td>
        <td>${user.address}</td>
        <td></td>
      </tr>
    </c:forEach>
      --%>

						<%
						List<User> list = (List) getServletContext().getAttribute("usersList");
						for (User user : list) {
						%>
						<tr>

							<td><%=user.getId()%></td>
							<td><%=user.getUsername()%></td>
							<td><%=user.getPassword()%></td>
							<td><%=user.getEmail()%></td>
							<td><%=user.getPhoneNum()%></td>
							<td><%=user.getAddress()%></td>
							<td><a href="delUser?id=<%=user.getId()%>"> <span
									class='bi bi-trash bi-lg' style='color: #f48585'></span>
							</a>| <a href="editUser?id=<%=user.getId()%>"> <span
									class="glyphicon glyphicon-edit" aria-hidden="true"></span>
							</a></td>

						</tr>

						<%
						}
						%>

					</tbody>
				</table>

			</div>

			<!--  -->

		</div>
	</div>

</body>
</html>