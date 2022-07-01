package model;

import java.util.Date;

public class PostEntry {
		private int id;
		private String post;
		private java.sql.Date postedDate;
		private User user;
		public PostEntry(String post, User user) {
			super();
			this.post = post;
			this.postedDate = new java.sql.Date(new Date().getTime());
			this.user = user;
		}
		
		
		public PostEntry() {
			
		}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getPost() {
			return post;
		}


		public void setPost(String post) {
			this.post = post;
		}


		public java.sql.Date getPostedDate() {
			return  postedDate;
		}


		public void setPostedDate(java.sql.Date postedDate) {
			this.postedDate = postedDate;
		}


		public User getUser() {
			return user;
		}


		public void setUser(User user) {
			this.user = user;
		}


		@Override
		public String toString() {
			return "PostEntry [id=" + id + ", post=" + post + ", postedDate=" + postedDate + ", user=" + user.getUsername() + "]";
		}
		
		
		
		
		

}
