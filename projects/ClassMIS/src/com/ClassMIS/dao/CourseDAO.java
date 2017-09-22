package com.ClassMIS.dao;

import java.util.List;

import com.ClassMIS.table.Class;
import com.ClassMIS.table.Course;

public interface CourseDAO
{
	public boolean checkCourseno(String no);
	public boolean addCourse(Course course);
	public List<Course> findAll();
	public boolean deleteByno(String no);
	public Course findByno(String no);
	public boolean editCourse(Course course);
	public Course findByname(String name);
}
