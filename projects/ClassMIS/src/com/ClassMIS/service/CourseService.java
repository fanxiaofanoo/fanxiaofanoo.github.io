package com.ClassMIS.service;

import java.util.List;

import com.ClassMIS.table.Course;
import com.ClassMIS.table.Student;

public interface CourseService
{
	//校验no的课程是否存在
	public boolean checkClassno(String no);
	//增加课程信息
	public boolean addCourse(Course course);
	//查询所有课程信息
	public List<Course> findAll();
	//删除课程信息
	public boolean deleteByno(String no);
	//根据no查询课程信息
	public Course findByno(String no);
	//修改课程信息
	public boolean editCourse(Course course);
	//根据name查询课程信息
	public Course findByname(String name);
}
