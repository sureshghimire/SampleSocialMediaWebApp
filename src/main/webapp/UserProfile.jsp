<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.User"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<title>Profile</title>
</head>
<body>


		<section style="background-color: #eee;">
			<div class="container py-5">
				<div class="row">
					<div class="col">
						<nav aria-label="breadcrumb" class="bg-light rounded-3 p-3 mb-4">
							<ol class="breadcrumb mb-0">
								<li class="breadcrumb-item active" aria-current="page">
								<a href="postFeed">Home</a>
								</li>

								<li class="breadcrumb-item"><a href="logout">Log out</a></li>
							</ol>
						</nav>
					</div>
				</div>



				<div class="row">
					<div class="col-lg-4">
						<div class="card mb-4">
							<div class="card-body text-center">
								<img
									src="https://images.unsplash.com/photo-1593085512500-5d55148d6f0d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=580&q=80"
									alt="avatar" class="rounded-circle img-fluid"
									style="width: 150px;">
								<h5 class="my-3">Hi, ${sessionScope.authUser.username }</h5>
								<p class="text-muted mb-1">Full Stack Developer</p>
								<p class="text-muted mb-4">${authUser.address }</p>
							</div>
						</div>

						<div class="col-lg-12">
							<div class="card mb-4">
								<div class="card-body">
									<div class="row">
										<div class="col-sm-3">
											<p class="mb-0">Full Name</p>
										</div>
										<div class="col-sm-9">
											<p class="text-muted mb-0">${authUser.username }</p>
										</div>
									</div>
									<hr>
									<div class="row">
										<div class="col-sm-3">
											<p class="mb-0">Email</p>
										</div>
										<div class="col-sm-9">
											<p class="text-muted mb-0">${authUser.email }</p>
										</div>
									</div>
									<hr>
									<div class="row">
										<div class="col-sm-3">
											<p class="mb-0">Phone</p>
										</div>
										<div class="col-sm-9">
											<p class="text-muted mb-0">${authUser.phoneNum }</p>
										</div>
									</div>
									<hr>
									<div class="row">
										<div class="col-sm-3">
											<p class="mb-0">Address</p>
										</div>
										<div class="col-sm-9">
											<p class="text-muted mb-0">${authUser.address }</p>
										</div>
									</div>
								</div>
							</div>


						</div>
					</div>
				</div>
			</div>
		</section>
	
</body>
</html>