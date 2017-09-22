package com.ClassMIS.action;

import java.util.ArrayList;
import java.util.List;

import com.ClassMIS.service.ClassService;
import com.opensymphony.xwork2.ActionSupport;

public class Manager_class extends ActionSupport
{
	// 变量 *********************************************************************
	private String result;
	private ClassService classService;	
	private List<com.ClassMIS.table.Class> classno;
	
	// 函数 *********************************************************************
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
	
	public List<com.ClassMIS.table.Class> getClassno()
	{
		return classno;
	}

	public void setClassno(List<com.ClassMIS.table.Class> classno)
	{
		this.classno = classno;
	}
	
	@Override
	public String execute() throws Exception
	{
		try
		{
			classno=classService.findAll();
		}
		catch(Exception e)
		{
			
		}
		return SUCCESS;
	}
}
