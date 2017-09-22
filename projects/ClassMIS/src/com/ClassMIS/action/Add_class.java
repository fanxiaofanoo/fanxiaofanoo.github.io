package com.ClassMIS.action;

import com.ClassMIS.service.ClassService;
import com.opensymphony.xwork2.ActionSupport;
import com.ClassMIS.table.Class;

public class Add_class extends ActionSupport
{
	// 变量 *********************************************************************
	private String no = "";
	private String name = "";
	private String result="";
	private ClassService classService;

	private Class classno;
	// 函数 *********************************************************************
	public String getNo()
	{
		return no;
	}
	public void setNo(String no)
	{
		this.no = no;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}	
	public String getResult()
	{
		return result;
	}
	public void setResult(String result)
	{
		this.result = result;
	}
	public ClassService getClassService()
	{
		return classService;
	}
	public void setClassService(ClassService classService)
	{
		this.classService = classService;
	}
	
	@Override
	public String execute() throws Exception
	{
		System.out.println("执行Add_class的execute！");
		System.out.println(getNo()+getName());
		
		if(classService.checkClassno(getNo()))
		{
			result="班级编号重复！";
		}
		else
		{
			classno=new Class();
			classno.setNo(no);
			classno.setName(name);
			if(classService.addClass(classno))
			{result="成功";}
			else
			{result="失败";}		
		}
		return SUCCESS;
	}	
}
