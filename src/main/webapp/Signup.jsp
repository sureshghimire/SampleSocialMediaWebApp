<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Signup</title>
</head>

<body>
	<div class="container">
	
	<header>
		<h1>Sign Up</h1>	
	</header>
	
	<div style="width:60%">
	<hr/>

		<form action="signup" method="post">
		
		
		  <div class="mb-3 mt-3">
		    <label for="username" class="form-label">Username:</label>
		    <input type="text" class="form-control" id="email" placeholder="Enter username" name="username">
		  </div>
		  
		  <div class="mb-3">
		    <label for="pwd" class="form-label">Password:</label>
		    <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password">
		  </div>
		
		 <div class="mb-3">
		    <label for="pwd" class="form-label">Email:</label>
		    <input type="email" class="form-control" id="pwd" placeholder="Enter email" name="email">
		  </div>
	
		 <div class="mb-3">
		    <label for="pwd" class="form-label">Phone Number:</label>
		    <input type="number" class="form-control" id="pwd" placeholder="Enter phone number" name="phoneNumber">
		  </div>
	
		  <div class="mb-3 mt-3">
	      <label for="comment">Address:</label>
	      <textarea class="form-control" rows="5" id="comment" name="address" placeholder="Enter address"></textarea>
   		 </div>
   		 
		 <button type="submit" class="btn btn-outline-primary">Sign Up</button>
		<button type="reset" class="btn btn-outline-secondary">Reset</button>
		<a href="userList">
			<button type="button" class="btn btn-outline-success">
			Load Data</button>
		</a>
		</form>
	</div>
		
		

	
	
	</div>
</body>
</html>