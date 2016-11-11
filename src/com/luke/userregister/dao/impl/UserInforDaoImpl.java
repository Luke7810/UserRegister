package com.luke.userregister.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.luke.userregister.dao.UserInforDao;
import com.luke.userregister.model.UserInfor;

@Component("userInforDao")
public class UserInforDaoImpl implements UserInforDao {
	//Import the hibernate template
	private HibernateTemplate hibernateTemplate;

	@Override
	/* save user information in DB */
	public void save(UserInfor u) {
		hibernateTemplate.save(u);
		System.out.println("User "+u.getUsername()+" added in DB.");
	}

	@Override
	/* load a user using id from DB. */
	public UserInfor loadById(int id) {
		UserInfor u = (UserInfor)hibernateTemplate.get(UserInfor.class, id);
		return u;
	}

	@Override
	/* get all user list from DB */
	public List<UserInfor> loadAllUser() {
		return (List<UserInfor>)this.hibernateTemplate.find("from UserInfor");
	}
	
	@Override
	/* get all users count form DB */
	public int countUsers() {
		Long count = (Long) hibernateTemplate.find("select COUNT(*) from UserInfor").listIterator().next();;
		return count.intValue();
	}

	
	@Override
	/* get user by name */
	public UserInfor loadByName(String name) {
		UserInfor u = (UserInfor)hibernateTemplate
				.find("select from UserInfor u where u.username = '" + name + "'");
		return u;
	}

	@Override
	public boolean checkUserExist(UserInfor u) {
		List<UserInfor> users = hibernateTemplate
				.find("from UserInfor u where u.username = '" + u.getUsername() + "'");
		if(users != null && users.size()>0){
			return true;
		}
		return false;
	}

	/* all get and set method */
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	//IOC hibernate template
	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
