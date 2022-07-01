<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.User"%>
<%@page import="java.util.List"%>
<%@page import="model.PostEntry"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<title>Posts</title>
</head>
<body>

	<div class="container mt-4 mb-5">

		<div class="d-flex justify-content-center row">
			<div class="col-md-8">
			<div class="feed p-2">
			<div class="page-header">
			<a href="auth">
					<button type="button" class="btn btn-outline-secondary">User
						Login</button>
				</a> <a href="userList">
					<button type="button" class="btn btn-outline-success">Admin</button>
				</a>
			</div>
				
			</div>
			</div>
		</div>

		<div class="d-flex justify-content-center row">
			<div class="col-md-8">
				<div class="feed p-2">
				
				<div class="d-flex flex-row justify-content-between align-items-center p-2 bg-white border">
                    <div class="feed-text px-2">
                    
                    	<h6 class="text-black-50 mt-2">Hi <a href="userProfile">${sessionScope.authUser.username }   </a></h6>

                         </div>
                    <div class="feed-icon px-2"><i class="fa fa-long-arrow-up text-black-50"></i></div>
                </div>
                
				
					<div
						class="d-flex flex-row justify-content-between align-items-center p-2 bg-white border">
						<div class="feed-text px-2">



							<form action="createPost" method="post">
								<div class="form-group">
									<textarea class="form-control" rows="2" cols="100" name="post"
										placeholder="What's on your mind?"></textarea>

								</div>
								<div class="p-2">
									<button type="submit" class="btn btn-outline-info">Post</button>
								</div>
							</form>



						</div>
						<div class="feed-icon px-2">
							<i class="fa fa-long-arrow-up text-black-50"></i>
						</div>
					</div>

			<% List<PostEntry> allPosts = (List)request.getAttribute("allPost"); %>
			
			<% for(PostEntry post: allPosts)
			{%>
				<div class="bg-white border mt-2">
						<div>
							<div
								class="d-flex flex-row justify-content-between align-items-center p-2 border-bottom">
								<div class="d-flex flex-row align-items-center feed-text px-2">
									<img class="rounded-circle"
										src="https://i.imgur.com/aoKusnD.jpg" width="45">
									<div class="d-flex flex-column flex-wrap ml-2">
										<span class="font-weight-bold"><%=post.getUser().getUsername() %></span><span
											class="text-black-50 time"><%=post.getPostedDate() %></span>
									</div>
								</div>
								<div class="feed-icon px-2">
									<i class="fa fa-ellipsis-v text-black-50"></i>
								</div>
							</div>
						</div>
						<div class="p-2 px-3">
							<span><%=post.getPost() %></span>
						</div>
						<div class="d-flex justify-content-end socials p-2 py-3">
							<i class="fa fa-thumbs-up"></i><i class="fa fa-comments-o"></i><i
								class="fa fa-share"></i>
						</div>
					</div>
			
				
			
			<%}
			
			%>
	
	
						
						
						
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>