package com.ClassMIS.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;

import org.apache.struts2.ServletActionContext;

import com.ClassMIS.service.ClassService;
import com.opensymphony.xwork2.ActionSupport;

public class Delete_class extends ActionSupport
{
	// 变量 *********************************************************************
	private String no;
	private ClassService classService;
	private String contentType = "text/html;charset=utf-8";
	
	// 函数 *********************************************************************
	public ClassService getClassService()
	{
		return classService;
	}

	public void setClassService(ClassService classService)
	{
		this.classService = classService;
	}
	
	public String getNo()
	{
		return no;
	}

	public void setNo(String no)
	{
		this.no = no;
	}
	
	public String execute() throws ServletException, IOException
	{
		ServletActionContext.getResponse().setContentType(contentType);   
	    PrintWriter out = ServletActionContext.getResponse().getWriter();
		
	    try
		{		
			if(classService.deleteByno(getNo()))
			{
				 out.flush();
			     out.println("<script>");
			     out.println("alert('删除成功！请刷新页面');");
			     out.println("window.location.href = 'Manager_class.action';");
			     out.println("</script>");
			     out.flush();  
			     out.close();  
			}
			else
			{
				out.flush();
		        out.println("<script>");
		        out.println("alert('删除失败！');");
		        out.println("history.back();");
		        out.println("</script>");
		        out.flush();  
		        out.close(); 
			}
		}
		catch(Exception e)
		{
			out.flush();
	        out.println("<script>");
	        out.println("alert('删除失败！');");
	        out.println("history.back();");
	        out.println("</script>");
	        out.flush();  
	        out.close(); 
			e.printStackTrace();
		}
		return SUCCESS;
	}
}
