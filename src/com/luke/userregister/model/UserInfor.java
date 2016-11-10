package com.luke.userregister.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserInfor {
	private int id;
	private String username;
	private String userpws;
	
	@Id
	@GeneratedValue
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
	public String getUserpws() {
		return userpws;
	}
	public void setUserpws(String userpws) {
		this.userpws = userpws;
	}
	
	
}
