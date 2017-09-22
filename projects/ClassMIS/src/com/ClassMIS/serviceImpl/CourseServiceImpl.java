package com.ClassMIS.serviceImpl;

import java.util.List;

import com.ClassMIS.dao.CourseDAO;
import com.ClassMIS.service.CourseService;
import com.ClassMIS.table.Course;

public class CourseServiceImpl implements CourseService
{
	private CourseDAO courseDAO;
	
	public CourseDAO getCourseDAO()
	{
		return courseDAO;
	}
	public void setCourseDAO(CourseDAO courseDAO)
	{
		this.courseDAO = courseDAO;
	}
	
	@Override
	public boolean checkClassno(String no)
	{
		if(courseDAO.checkCourseno(no))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	@Override
	public boolean addCourse(Course course)
	{
		if(courseDAO.addCourse(course))
		{
			return true;			
		}
		else
		{
			return false;
		}
	}
	@Override
	public List<Course> findAll()
	{
		return courseDAO.findAll();
	}
	@Override
	public boolean deleteByno(String no)
	{
		if(courseDAO.deleteByno(no))
		{
			return true;			
		}
		else
		{
			return false;
		}
	}
	@Override
	public Course findByno(String no)
	{
		return courseDAO.findByno(no);
	}
	@Override
	public Course findByname(String name)
	{
		return courseDAO.findByname(name);
	}
	@Override
	public boolean editCourse(Course course)
	{
		if(courseDAO.editCourse(course))
		{
			return true;			
		}
		else
		{
			return false;
		}
	}
}
