package com.ClassMIS.action;

import com.ClassMIS.service.StudentService;
import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport
{
	// 变量 *********************************************************************
	private String userName = "";
	private String password = "";
	private String result="";
	private StudentService studentService;
	// 函数 *********************************************************************
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getResult()
	{
		return result;
	}
	public void setResult(String result)
	{
		this.result = result;
	}
	public StudentService getStudentService()
	{
		return studentService;
	}
	public void setStudentService(StudentService studentService)
	{
		this.studentService = studentService;
	}
	
	@Override
	public String execute() throws Exception
	{
		System.out.println("执行login的execute！");
		
		if(studentService.loginCheck(getUserName(),getPassword()))
		{
			result="成功";
		}
		else
		{
			result="失败";
		}
		return SUCCESS;
	}		
}
