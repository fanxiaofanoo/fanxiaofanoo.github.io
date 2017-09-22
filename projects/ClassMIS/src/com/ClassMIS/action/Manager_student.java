package com.ClassMIS.action;

import java.util.List;

import com.ClassMIS.service.StudentService;
import com.ClassMIS.table.Student;
import com.opensymphony.xwork2.ActionSupport;

public class Manager_student extends ActionSupport
{
	// 变量 *********************************************************************
	private StudentService studentService;
	private List<Student> student;
	
	// 函数 *********************************************************************
	public StudentService getStudentService()
	{
		return studentService;
	}
	public void setStudentService(StudentService studentService)
	{
		this.studentService = studentService;
	}
	public List<Student> getStudent()
	{
		return student;
	}
	public void setStudent(List<Student> student)
	{
		this.student = student;
	}
	@Override
	public String execute() throws Exception
	{
		try
		{
			student=studentService.findAll();
		}
		catch(Exception e)
		{
			
		}
		return SUCCESS;
	}
}
