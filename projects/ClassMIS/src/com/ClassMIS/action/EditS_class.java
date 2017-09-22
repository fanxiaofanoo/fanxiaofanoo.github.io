package com.ClassMIS.action;

import java.io.PrintWriter;

import org.apache.struts2.ServletActionContext;

import com.ClassMIS.service.ClassService;
import com.ClassMIS.table.Class;
import com.opensymphony.xwork2.ActionSupport;

public class EditS_class extends ActionSupport
{
	// 变量 *********************************************************************
	private String no = "";
	private String name = "";
	
	private ClassService classService;
	private Class classno;
	private String result;
	private String contentType = "text/html;charset=utf-8";
	
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
	public String getResult()
	{
		return result;
	}
	public void setResult(String result)
	{
		this.result = result;
	}	
	@Override
	public String execute() throws Exception
	{
		System.out.println("执行EditS_class的execute！");
		System.out.println(getNo()+getName());
		
		ServletActionContext.getResponse().setContentType(contentType);   
	    PrintWriter out = ServletActionContext.getResponse().getWriter();
	    
		try
		{
			classno=new Class();
			classno.setName(getName());
			classno.setNo(getNo());
			if(classService.editClass(classno))
			{
				result="修改成功";
			}
			else
			{
				result="修改失败";
			}
		}
		catch(Exception e)
		{
			result="修改失败";
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
}
