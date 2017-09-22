package com.ClassMIS.action;

import com.ClassMIS.service.ClassService;
import com.ClassMIS.table.Class;
import com.opensymphony.xwork2.ActionSupport;

public class Edit_class extends ActionSupport
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
	public Class getClassno()
	{
		return classno;
	}
	public void setClassno(Class classno)
	{
		this.classno = classno;
	}	
	@Override
	public String execute() throws Exception
	{
		System.out.println("执行Edit_class的execute！");
		System.out.println(getNo()+getName());
		
		try
		{
			classno=classService.findByno(getNo());
			
			setNo(classno.getNo());
			setName(classno.getName());
			
			System.out.println(getNo()+"|"+getName());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return SUCCESS;
	}	
}
