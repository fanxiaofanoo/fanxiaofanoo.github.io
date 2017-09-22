package com.ClassMIS.action;

import java.util.List;

import com.ClassMIS.service.CourseService;
import com.ClassMIS.table.Course;
import com.opensymphony.xwork2.ActionSupport;

public class Manager_course extends ActionSupport
{
	// 变量 *********************************************************************
	private CourseService courseService;
	private List<Course> course;
	
	// 函数 *********************************************************************
	public CourseService getCourseService()
	{
		return courseService;
	}
	public void setCourseService(CourseService courseService)
	{
		this.courseService = courseService;
	}
	public List<Course> getCourse()
	{
		return course;
	}
	public void setCourse(List<Course> course)
	{
		this.course = course;
	}
	@Override
	public String execute() throws Exception
	{
		try
		{
			course=courseService.findAll();
		}
		catch(Exception e)
		{
			
		}
		return SUCCESS;
	}
}
