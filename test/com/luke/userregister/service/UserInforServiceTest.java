package com.luke.userregister.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.luke.userregister.model.UserInfor;
import com.luke.userregister.service.impl.UserInforServiceImpl;

/*
 * 一般测试的时候主要针对Service层和DAO层，由于Spring的引入，一般测试的都是Service层。
 * 对于Struts的Action层测试，一般不在这里写测试用例，而是直接部署到Server上进行页面测试。
 */
public class UserInforServiceTest {

	@Test
	public void addUser() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		UserInforService uis = (UserInforService) ac.getBean("userInforService");
		UserInfor u = new UserInfor();
		
		u.setUsername("Mark");
		u.setUserpws("1234");
		
		uis.add(u);
	}
	
	@Test
	public void ExistUser(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		UserInforService uis = (UserInforService) ac.getBean("userInforService");
		UserInfor u = new UserInfor();
		
		u.setUsername("luke");
		boolean userexist  = uis.existUser(u);
		if(userexist) System.out.println("user exit! "+ u.getUsername());
		
		UserInfor u2 = new UserInfor();
		
		u2.setUsername("zhangsan");
		boolean userexist2 = uis.existUser(u2);
		if(userexist2){
			System.out.println("user exit! "+ u2.getUsername());
		}else{
			System.out.println("user NOT exit! "+ u2.getUsername());
		}
	}

	@Test
	public void getUserById(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		UserInforService uis = (UserInforService) ac.getBean("userInforService");
		int new_id = 1;
		
		UserInfor u = uis.getUserById(new_id);
		System.out.println("user name is! "+ u.getUsername());
	}
	
	@Test
	public void listAllUser(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		UserInforService uis = (UserInforService) ac.getBean("userInforService");
		
		List<UserInfor> users = uis.listAllUser();
		for(int i=0;    i<users.size();    i++)    {
			UserInfor u = users.get(i);
			System.out.println("User List: "+u.getUsername());
		}
	}
}
