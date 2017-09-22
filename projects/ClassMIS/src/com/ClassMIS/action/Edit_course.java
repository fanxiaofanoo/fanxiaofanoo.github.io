package com.ClassMIS.action;

import com.ClassMIS.service.CourseService;
import com.ClassMIS.table.Course;
import com.opensymphony.xwork2.ActionSupport;

public class Edit_course extends ActionSupport
{
	// 变量 *********************************************************************
	private String no = "";
	private String name = "";
	private String nature = "";
	private String credit = "";
	private String result="";
	private CourseService courseService;
	private Course course;
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
	public String getNature()
	{
		return nature;
	}
	public void setNature(String nature)
	{
		this.nature = nature;
	}
	public String getCredit()
	{
		return credit;
	}
	public void setCredit(String credit)
	{
		this.credit = credit;
	}
	public String getResult()
	{
		return result;
	}
	public void setResult(String result)
	{
		this.result = result;
	}
	public CourseService getCourseService()
	{
		return courseService;
	}
	public void setCourseService(CourseService courseService)
	{
		this.courseService = courseService;
	}
	public Course getCourse()
	{
		return course;
	}
	public void setCourse(Course course)
	{
		this.course = course;
	}
	@Override
	public String execute() throws Exception
	{
		System.out.println("执行Edit_course的execute！");
		try
		{
			course=courseService.findByno(getNo());
			
			setNo(course.getNo());
			setName(course.getName());
			setNature(course.getNature());
			setCredit(course.getCredit());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return SUCCESS;
	}
}
