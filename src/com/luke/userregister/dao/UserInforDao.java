package com.luke.userregister.dao;

import java.util.List;

import com.luke.userregister.model.UserInfor;

public interface UserInforDao {
	public void save(UserInfor u);
	public UserInfor loadById(int id);
	public UserInfor loadByName(String name);
	public List<UserInfor> loadAllUser();
	public int countUsers();
	public boolean checkUserExist(UserInfor u);
}
