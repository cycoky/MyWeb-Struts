/**
 * @包名称 com.coky.user.action
 * @文件名 AddAction.java
 * @版本 1.0
 * @创建者 chenyang
 * @创建时间 2015-1-21 下午2:26:30
 * @版权所有 ©2015 CTFO
 * @修改者 chenyang
 * @修改时间 2015-1-21 下午2:26:30
 * @修改描述 
 */

package com.coky.user.action;

import org.apache.commons.lang.StringUtils;

import com.coky.user.dao.AdminDao;
import com.opensymphony.xwork2.ActionSupport;

/** 
 * 功能描述 
 * @类型名称 AddAction
 * @版本 1.0
 * @创建者 chenyang
 * @创建时间 2015-1-21 下午2:26:30
 * @版权所有 ©2015 CTFO
 * @修改者 chenyang
 * @修改时间 2015-1-21 下午2:26:30
 * @修改描述 
 */
public class AddAction extends ActionSupport{

	private String name;
	
	private String pwd;

	private String pwd1;
	
	@Override
	public String execute() throws Exception {
		AdminDao dao = new AdminDao();
		if(validateInput() && dao.addAdmin(name, pwd)){
			return SUCCESS;
		}
		
		return ERROR;
	}

	private boolean validateInput(){
		if(StringUtils.isEmpty(name) || StringUtils.isEmpty(pwd) || StringUtils.isEmpty(pwd1)){
			return false;
		}
		return pwd.equals(pwd1);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPwd1() {
		return pwd1;
	}

	public void setPwd1(String pwd1) {
		this.pwd1 = pwd1;
	}

}
