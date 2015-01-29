/**
 * @包名称 com.coky.calc.action
 * @文件名 ArithmeticAction.java
 * @版本 1.0
 * @创建者 chenyang
 * @创建时间 2015-1-22 上午10:16:28
 * @版权所有 ©2015 CTFO
 * @修改者 chenyang
 * @修改时间 2015-1-22 上午10:16:28
 * @修改描述 
 */

package com.coky.calc.action;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.coky.calc.pojo.Calculator;
import com.opensymphony.xwork2.ActionSupport;

/** 
 * 功能描述 : 四则运算action，通过DMI实现 
 * Dynamic Method Invocation ( actionName ! methodName.action)
 * 此action 采用模型驱动方式，将表单数据属性封装如Calculator对象中
 * 
 * @类型名称 ArithmeticAction
 * @版本 1.0
 * @创建者 chenyang
 * @创建时间 2015-1-22 上午10:16:28
 * @版权所有 ©2015 CTFO
 * @修改者 chenyang
 * @修改时间 2015-1-22 上午10:16:28
 * @修改描述 
 */
public class ArithmeticAction extends ActionSupport{

	private Calculator calc;
	
	public String add() {
		calc.setResult(calc.getOperand1() + calc.getOperand2());
		return SUCCESS;
	}
	
	public String sub() {
		calc.setResult(calc.getOperand1() - calc.getOperand2());
		return SUCCESS;
	}
	
	public String mul() {
		calc.setResult(calc.getOperand1() * calc.getOperand2());
		return SUCCESS;
	}
	
	public String div() {
		double result = new BigDecimal(calc.getOperand1()).divide(new BigDecimal(calc.getOperand2()), 2, RoundingMode.HALF_UP).doubleValue();
		calc.setResult(result);
		return SUCCESS;
	}

	public Calculator getCalc() {
		return calc;
	}

	public void setCalc(Calculator calc) {
		this.calc = calc;
	}

}
