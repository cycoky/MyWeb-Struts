/**
 * @包名称 com.coky.user.action
 * @文件名 QueryAdminAction.java
 * @版本 1.0
 * @创建者 chenyang
 * @创建时间 2015-1-21 上午11:18:33
 * @版权所有 ©2015 CTFO
 * @修改者 chenyang
 * @修改时间 2015-1-21 上午11:18:33
 * @修改描述 
 */

package com.coky.user.action;

import java.util.List;
import java.util.Map;

import com.coky.user.dao.AdminDao;
import com.coky.user.pojo.Admin;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/** 
 * 功能描述 
 * @类型名称 QueryAdminAction
 * @版本 1.0
 * @创建者 chenyang
 * @创建时间 2015-1-21 上午11:18:33
 * @版权所有 ©2015 CTFO
 * @修改者 chenyang
 * @修改时间 2015-1-21 上午11:18:33
 * @修改描述 
 */
public class QueryAdminAction extends ActionSupport{

	private static final long serialVersionUID = -6271733506711815339L;

	@Override
	public String execute() throws Exception {
		AdminDao dao = new AdminDao();
		List<Admin> adminList = dao.getAdminList();
		ActionContext ac = ActionContext.getContext();
		Map<String, Object> request = (Map<String, Object>) ac.get("request");
		request.put("adminList", adminList);
		
		return SUCCESS;
		
	}
}
