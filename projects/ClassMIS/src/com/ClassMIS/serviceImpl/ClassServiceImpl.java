package com.ClassMIS.serviceImpl;

import java.util.List;

import com.ClassMIS.dao.ClassDAO;
import com.ClassMIS.service.ClassService;

public class ClassServiceImpl implements ClassService
{
	//变量**********************************************
	private ClassDAO classDAO;
	
	//方法**********************************************
	public ClassDAO getClassDAO()
	{
		return classDAO;
	}
	public void setClassDAO(ClassDAO classDAO)
	{
		this.classDAO = classDAO;
	}
	
	@Override
	public boolean checkClassno(String no)
	{
		if(classDAO.checkClassno(no))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	@Override
	public boolean addClass(com.ClassMIS.table.Class classno)
	{
		if(classDAO.addClass(classno))
		{
			return true;			
		}
		else
		{
			return false;
		}
	}
	@Override
	public boolean deleteByno(String no)
	{
		if(classDAO.deleteByno(no))
		{
			return true;			
		}
		else
		{
			return false;
		}
	}
	@Override
	public List<com.ClassMIS.table.Class> findAll()
	{
		return classDAO.findAll();
	}
	@Override
	public com.ClassMIS.table.Class findByno(String no)
	{
		return classDAO.findByno(no);
	}
	@Override
	public com.ClassMIS.table.Class findByname(String name)
	{
		return classDAO.findByname(name);
	}
	@Override
	public boolean editClass(com.ClassMIS.table.Class classno)
	{
		if(classDAO.editClass(classno))
		{
			return true;			
		}
		else
		{
			return false;
		}
	}
}
