package com.luke.userregister.service;

import java.util.List;

import com.luke.userregister.model.UserInfor;

public interface UserInforService {
	public void add(UserInfor u);
	public boolean existUser(UserInfor u);
	public List<UserInfor> listAllUser();
	public UserInfor getUserById(int id);
}
