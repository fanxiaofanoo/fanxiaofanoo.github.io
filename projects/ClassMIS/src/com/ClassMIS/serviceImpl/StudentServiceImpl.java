package com.ClassMIS.serviceImpl;

import java.util.List;

import com.ClassMIS.dao.StudentDAO;
import com.ClassMIS.daoImpl.StudentDAOImpl;
import com.ClassMIS.service.StudentService;
import com.ClassMIS.table.Student;

public class StudentServiceImpl implements StudentService
{
	private StudentDAO studentDAO;
	
	public StudentDAO getStudentDAO()
	{
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO)
	{
		this.studentDAO = studentDAO;
	}

	//检查用户名是否存在
	@Override
	public boolean loginCheck(String userName, String password)
	{			
		if(studentDAO.loginCheck(userName, password))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	@Override
	public boolean addStudent(Student student)
	{
		if(studentDAO.addStudent(student))
		{
			return true;			
		}
		else
		{
			return false;
		}
	}
	@Override
	public boolean checkStudentno(String no)
	{
		if(studentDAO.checkStudentno(no))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	@Override
	public List<Student> findAll()
	{
		return studentDAO.findAll();
	}
	@Override
	public boolean deleteByno(String no)
	{
		if(studentDAO.deleteByno(no))
		{
			return true;			
		}
		else
		{
			return false;
		}
	}
	@Override
	public Student findByno(String no)
	{
		return studentDAO.findByno(no);
	}
	@Override
	public boolean editStudent(Student student)
	{
		if(studentDAO.editStudent(student))
		{
			return true;			
		}
		else
		{
			return false;
		}
	}
}
