package com.luke.userregister.dao;

import java.util.List;

import com.luke.userregister.model.UserInfor;

public interface UserInforDao {
	public void save(UserInfor u);
	public UserInfor loadById(int id);
	public List<UserInfor> loadAllUser();
	
}
