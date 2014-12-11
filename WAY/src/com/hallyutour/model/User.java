package com.hallyutour.model;

public class User {
    private String userid;
    
	private String username;
	
	private String password;

    private String email;
    
    private String nickname;
    
    private String imgpath;
    
    private boolean loginYN;



	public boolean isLoginYN() {
		return loginYN;
	}

	public void setLoginYN(boolean loginYN) {
		this.loginYN = loginYN;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getImgpath() {
		return imgpath;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}

    

}