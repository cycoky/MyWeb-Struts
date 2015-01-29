/**
 * @包名称 com.coky.calc
 * @文件名 AddAction.java
 * @版本 1.0
 * @创建者 chenyang
 * @创建时间 2015-1-22 上午9:41:41
 * @版权所有 ©2015 CTFO
 * @修改者 chenyang
 * @修改时间 2015-1-22 上午9:41:41
 * @修改描述 
 */

package com.coky.calc.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/** 
 * 功能描述 
 * @类型名称 AddAction
 * @版本 1.0
 * @创建者 chenyang
 * @创建时间 2015-1-22 上午9:41:41
 * @版权所有 ©2015 CTFO
 * @修改者 chenyang
 * @修改时间 2015-1-22 上午9:41:41
 * @修改描述 
 */
public class AddAction extends ActionSupport{

	private double operand1;
	
	private double operand2;
	
	private double result;
	
	@Override
	public String execute() throws Exception {
		result  = operand1 + operand2;
		ActionContext ac = ActionContext.getContext();
//		Map<String, Object> request = (Map<String, Object>)ac.get("repuest");
//		request.put("result", result);
		
		return SUCCESS;
	}

	public double getOperand1() {
		return operand1;
	}

	public void setOperand1(double operand1) {
		this.operand1 = operand1;
	}

	public double getOperand2() {
		return operand2;
	}

	public void setOperand2(double operand2) {
		this.operand2 = operand2;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

}
