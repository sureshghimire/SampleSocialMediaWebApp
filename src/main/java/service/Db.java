package service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.PostEntry;
import model.User;

public class Db{
	 private String url = "jdbc:mysql://localhost:3306/sample_db";
     private String username = "root";
     private String password = "1234";
     private Connection connection;
	 	
	
    public Db() {
		
    	 try
         {
    		//load driver
	    	 Class.forName("com.mysql.cj.jdbc.Driver");
    		
             connection = DriverManager.getConnection( url, username, password );
             System.out.println("DB Connected Sucessfully");
         }
         catch( SQLException e )
         {
             e.printStackTrace();
         } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    public void close()
    {
        if( connection != null )
        {
            try
            {
                connection.close();
            }
            catch( SQLException e )
            {
                e.printStackTrace();
            }
        }
    }

   public void createPost(PostEntry post) {
	   String insertPost= "insert into posts (post, postedDate, username) values(?, ?, ?)";
	   
	   PreparedStatement psmt;
	   try {
		   psmt= connection.prepareStatement(insertPost);
		   psmt.setString(1, post.getPost());
		   psmt.setDate(2,  post.getPostedDate());
		   psmt.setString(3, post.getUser().getUsername());
		   
		   psmt.executeUpdate();
		   
	   }catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   }

   public User getUser(String username) {
	   User user = new User();
	   
	   PreparedStatement psmt;
	   String getUser = "select *from users where username=?";
	   try {
		psmt = connection.prepareStatement(getUser);
		psmt.setString(1, username);
		ResultSet rs = psmt.executeQuery();
		while(rs.next()) {
			user.setUsername(rs.getString("username"));
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	   
	   
	   return user;
   }
   
   public List<PostEntry> getAllPosts(){
	   List<PostEntry> posts = new ArrayList<>();
	   
	   PreparedStatement psmt;
	   
	   String allPost ="select *from posts";
	   
	   try {
		psmt= connection.prepareStatement(allPost);
		ResultSet rs = psmt.executeQuery();
		
		while(rs.next()) {
			PostEntry entry = new PostEntry();
			entry.setPost(rs.getString("post"));
			entry.setPostedDate(rs.getDate("postedDate"));
			User user = getUser(rs.getString("username"));
			entry.setUser(user);
			posts.add(entry);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	   
	   return posts;
   }
	public void addUser(User user) {
		// TODO Auto-generated method stub
		//Insert Syntax
   	 	String insert = "insert into users(username,email,password,phone,address) values(?,?,?,?,?)";
	   	
	   	 //Insert Statement
	   	 PreparedStatement pst;
		try {
			pst = connection.prepareStatement(insert);
			pst.setString(1, user.getUsername());
		   	 pst.setString(2, user.getEmail());
		   	 pst.setString(3, user.getPassword());
		   	 pst.setInt(4, user.getPhoneNum());
		   	 pst.setString(5, user.getAddress());
		   	 pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   	     	
		
	}

	//Authorization
	public User auth(String username, String password) {
		
		PreparedStatement psmt;
		
		String doesExist = "select *from users where username = ? AND password = ?";
		try {
			psmt = connection.prepareStatement(doesExist);
			
			psmt.setString(1, username);
			psmt.setString(2, password);
			
			ResultSet rs = psmt.executeQuery();
			if(rs.next()) {
				User user = new User(rs.getString("username"), rs.getString("password"), rs.getString("email"), rs.getInt("phone"), rs.getString("address"));
				user.setId(rs.getInt("id"));
			
				return user;
			}
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	public List<User> getAllUsers() {
		List<User>users = new ArrayList<>();
		
   	 //Insert Syntax
   	 String selectAll = "select *from users";
   	 
   	 //Insert Statement
   	PreparedStatement pst;
   	
	try {
		pst = connection.prepareStatement(selectAll);
		 ResultSet rs = pst.executeQuery();
		 
		 while(rs.next()) {
	   		 User user = new User();
	   		 user.setId(rs.getInt("id"));
	   		 user.setUsername(rs.getString("username"));
	   		 user.setPassword(rs.getString("password"));
	   		 user.setEmail(rs.getString("email"));
	   		 user.setPhoneNum(rs.getInt("phone"));
	   		 user.setAddress(rs.getString("address"));
	   		 
	   		 users.add(user);
	   		 
	   	 }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return users;
		
	}

	public void updateUser(User user) {
		
		PreparedStatement psmt;
		
		//Update statemet
		String update ="update users set username = ?, password = ?, email = ?, "
				+ "phone = ?, address = ? where id = ?";
		try {
			psmt=connection.prepareStatement(update);
			psmt.setString(1, user.getUsername());
			psmt.setString(2, user.getPassword());
			psmt.setString(3, user.getEmail());
			psmt.setInt(4, user.getPhoneNum());
			psmt.setString(5, user.getAddress());
			
			//for id get it from user
			System.out.println(user.getId());
			psmt.setInt(6, user.getId());
			
			psmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	

}
