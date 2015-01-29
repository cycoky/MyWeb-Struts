/**
 * @包名称 com.coky.user.action
 * @文件名 DeleteAction.java
 * @版本 1.0
 * @创建者 chenyang
 * @创建时间 2015-1-21 下午1:27:20
 * @版权所有 ©2015 CTFO
 * @修改者 chenyang
 * @修改时间 2015-1-21 下午1:27:20
 * @修改描述 
 */

package com.coky.user.action;

import java.util.Map;

import com.coky.user.dao.AdminDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/** 
 * 功能描述 
 * @类型名称 DeleteAction
 * @版本 1.0
 * @创建者 chenyang
 * @创建时间 2015-1-21 下午1:27:20
 * @版权所有 ©2015 CTFO
 * @修改者 chenyang
 * @修改时间 2015-1-21 下午1:27:20
 * @修改描述 
 */
public class DeleteAction extends ActionSupport{

	

	@Override
	public String execute() throws Exception {
		ActionContext ac = ActionContext.getContext();
		Map<String, Object> request = (Map<String, Object>) ac.get("request");
		String userId = (String) request.get("id");
		Map<String, Object> parameters = ac.getParameters();
		String[] id = (String[])parameters.get("id");
		if(id.length > 0){
			AdminDao dao = new AdminDao();
			if(dao.deleteById(id[0])) {
				return SUCCESS;
			}
		}
		
		return ERROR;
	}
}
