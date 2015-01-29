/**
 * @包名称 com.coky.user
 * @文件名 AdminAction.java
 * @版本 1.0
 * @创建者 chenyang
 * @创建时间 2015-1-20 下午5:48:15
 * @版权所有 ©2015 CTFO
 * @修改者 chenyang
 * @修改时间 2015-1-20 下午5:48:15
 * @修改描述 
 */

package com.coky.user.action;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;

import com.coky.user.dao.AdminDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/** 
 * 功能描述 ：属性驱动方式，表单数据在此action中
 * @类型名称 AdminAction
 * @版本 1.0
 * @创建者 chenyang
 * @创建时间 2015-1-20 下午5:48:15
 * @版权所有 ©2015 CTFO
 * @修改者 chenyang
 * @修改时间 2015-1-20 下午5:48:15
 * @修改描述 
 */
@Action
public class AdminAction extends ActionSupport{
	
	private static final long serialVersionUID = 338531053137353684L;

	private String id;
	
	private String name;
	
	private String pwd;

	public String getId() {
		return id;
	}
	
	@Override
	public String execute() throws Exception {
		AdminDao dao = new AdminDao();
		if(dao.checkLogin(name, pwd)){
//			ActionContext ac = ActionContext.getContext();
//			Map<String, Object> session = ac.getSession();
//			session.put("loginName", name);
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("loginName", name);
			return SUCCESS;
		}
		
		ActionContext ac = ActionContext.getContext();
		Map<String, Object> request = (Map<String, Object>) ac.get("request");
		request.put("errorMsg", "用户名或密码错误，请重试");
		return ERROR;
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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
