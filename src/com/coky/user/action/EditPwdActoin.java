/**
 * @包名称 com.coky.user.action
 * @文件名 EditActoin.java
 * @版本 1.0
 * @创建者 chenyang
 * @创建时间 2015-1-21 下午3:31:34
 * @版权所有 ©2015 CTFO
 * @修改者 chenyang
 * @修改时间 2015-1-21 下午3:31:34
 * @修改描述 
 */

package com.coky.user.action;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.coky.user.dao.AdminDao;
import com.coky.user.pojo.Admin;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/** 
 * 功能描述 
 * @类型名称 EditActoin
 * @版本 1.0
 * @创建者 chenyang
 * @创建时间 2015-1-21 下午3:31:34
 * @版权所有 ©2015 CTFO
 * @修改者 chenyang
 * @修改时间 2015-1-21 下午3:31:34
 * @修改描述 
 */
public class EditPwdActoin extends ActionSupport{

	// 用户id
	private String id;

	private String name;
	// 原始密码
	private String pwdOriginal;
	// 新设密码
	private String pwdNew;
	// 密码确认
	private String pwdNew1;

	private String errorMsg;
	
	@Override
	public String execute() throws Exception {
		AdminDao dao = new AdminDao();
		Admin user = dao.getUserById(id);
		
		ActionContext ac = ActionContext.getContext();
		Map<String, Object> request = (Map<String, Object>) ac.get("request");
		
		if(StringUtils.isEmpty(pwdOriginal) || StringUtils.isEmpty(pwdNew) || StringUtils.isEmpty(pwdNew1)){
			errorMsg = "请输入原始密码,新设密码,密码确认不能为空";
			request.put("errorMsg", errorMsg);
			return ERROR;
		}
		
		if(!dao.checkLogin(name, pwdOriginal)){
			errorMsg = "原始密码不正确";
			request.put("errorMsg", errorMsg);
			return ERROR;
		}
		
		if(!pwdNew.equals(pwdNew1)){
			errorMsg = "两次输入的密码不一致，请重新输入";
			request.put("errorMsg", errorMsg);
			return ERROR;
		}
	
		if(pwdNew.equals(pwdOriginal)){
			errorMsg = "新设密码不能和原始密码相同";
			request.put("errorMsg", errorMsg);
			return ERROR;
		}
		
		boolean updated = dao.updatePassword(id, pwdNew);
		if(updated){
			return SUCCESS;
		}
	
		errorMsg = "密码更新失败";
		request.put("errorMsg", errorMsg);
		return ERROR;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwdOriginal() {
		return pwdOriginal;
	}

	public void setPwdOriginal(String pwdOriginal) {
		this.pwdOriginal = pwdOriginal;
	}

	public String getPwdNew() {
		return pwdNew;
	}

	public void setPwdNew(String pwdNew) {
		this.pwdNew = pwdNew;
	}

	public String getPwdNew1() {
		return pwdNew1;
	}

	public void setPwdNew1(String pwdNew1) {
		this.pwdNew1 = pwdNew1;
	}
	
}
