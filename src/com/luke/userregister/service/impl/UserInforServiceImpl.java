package com.luke.userregister.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.luke.userregister.dao.UserInforDao;
import com.luke.userregister.model.UserInfor;
import com.luke.userregister.service.UserInforService;

@Component("userInforService")
public class UserInforServiceImpl implements UserInforService {
	
	private UserInforDao userInforDao;
	

	@Override
	public int countUser() {
		return userInforDao.countUsers();
	}

	@Override
	public void add(UserInfor u) {
		userInforDao.save(u);

	}

	@Override
	public boolean existUser(UserInfor u) {
		return userInforDao.checkUserExist(u);
	}

	@Override
	public List<UserInfor> listAllUser() {
		return userInforDao.loadAllUser();
	}

	@Override
	public UserInfor getUserById(int id) {
		return userInforDao.loadById(id);
	}

	/* all get set method */
	public UserInforDao getUserInforDao() {
		return userInforDao;
	}
	
	@Resource(name = "userInforDao")
	public void setUserInforDao(UserInforDao userInforDao) {
		this.userInforDao = userInforDao;
	}

}
