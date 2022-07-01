<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Login</title>
</head>

<body>

	<div class="container mt-3" style="width: 60%">
		<h2>Log in</h2>

		<div class="alert alert-light" role="alert" style="color:red">
			${requestScope.unsucessfulMsg}</div>


		<form action="auth" method="post">
			<div class="mb-3 mt-3">
				<label for="email">Username:</label> <input type="text"
					class="form-control" id="email" placeholder="Enter username"
					name="username">
			</div>
			<div class="mb-3">
				<label for="pwd">Password:</label> <input type="password"
					class="form-control" id="pwd" placeholder="Enter password"
					name="password">
			</div>

			<button type="submit" class="btn btn-outline-primary">Log in</button>

		</form>
	</div>
</body>
</html>