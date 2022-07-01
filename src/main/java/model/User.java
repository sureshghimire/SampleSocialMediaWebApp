package model;

public class User {
	
	private int id;
	private String username;
	private String password;
	private String email;
	private int phoneNum;
	private String address;
	private enum gender{MALE,FEMALE};
	
	public User() {
		super();
	}
	
	

	public User(String username, String password, String email, int phoneNum, String address) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.phoneNum = phoneNum;
		this.address = address;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(int phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", phoneNum=" + phoneNum + ", address=" + address + "]";
	}

	

}
