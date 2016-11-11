package com.luke.userregister.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.luke.userregister.model.UserInfor;
import com.luke.userregister.service.UserInforService;
import com.luke.userregister.web.vo.UserInforPage;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Component("userInforAction")
@Scope("prototype")
public class UserInforAction extends ActionSupport implements ModelDriven{
	
	private UserInforPage uip = new UserInforPage();
	private UserInforService userInforService;
	private UserInfor userInfor;
	private List<UserInfor> users;
	private int countuser;
	
	//construction method, action beginning
	public UserInforAction(){
		System.out.println("useraction created!");
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println(uip.getUsername()+" : in execute method !");
		UserInfor u = new UserInfor();
		u.setUsername(uip.getUsername());
		u.setUserpws(uip.getUserpws());
		if(userInforService.existUser(u)){
			return "fail";
		}
		userInforService.add(u);
		return "success";
	}
	
	public String regist() {
		countuser = userInforService.countUser();
		return "regist";
	}
	
	public String load(){
		this.userInfor = this.userInforService.getUserById(uip.getId());
		return "load";
	}
	
	public String list() {
		this.users = this.userInforService.listAllUser();
		return "list";
	}
	
	
	/*
	 *  All set and get method
	 * */
	@Override
	public Object getModel() {
		return uip;
	}


	public UserInforPage getUip() {
		return uip;
	}


	public void setUip(UserInforPage uip) {
		this.uip = uip;
	}


	public UserInforService getUserInforService() {
		return userInforService;
	}

	@Resource(name="userInforService")
	public void setUserInforService(UserInforService userInforService) {
		this.userInforService = userInforService;
	}


	public UserInfor getUserInfor() {
		return userInfor;
	}


	public void setUserInfor(UserInfor userInfor) {
		this.userInfor = userInfor;
	}

	public List<UserInfor> getUsers() {
		return users;
	}

	public void setUsers(List<UserInfor> users) {
		this.users = users;
	}

	public int getCountuser() {
		return countuser;
	}

	public void setCountuser(int countuser) {
		this.countuser = countuser;
	}
	
}
