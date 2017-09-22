package com.ClassMIS.serviceImpl;

import java.util.List;

import com.ClassMIS.dao.ClassDAO;
import com.ClassMIS.dao.GradeDAO;
import com.ClassMIS.service.GradeService;
import com.ClassMIS.table.Course;
import com.ClassMIS.table.Grade;
import com.ClassMIS.table.GradeId;

public class GradeServiceImpl implements GradeService
{
	private GradeDAO gradeDAO;
	
	public GradeDAO getGradeDAO()
	{
		return gradeDAO;
	}

	public void setGradeDAO(GradeDAO gradeDAO)
	{
		this.gradeDAO = gradeDAO;
	}
	@Override
	public boolean SaveOrUpdate(Grade grade)
	{
		if(gradeDAO.SaveOrUpdate(grade))
		{
			return true;			
		}
		else
		{
			return false;
		}
	}
	@Override
	public List<Grade> findAll()
	{
		return gradeDAO.findAll();
	}
	@Override
	public List<Grade> findByCourse(Course course)
	{
		return gradeDAO.findByCourse(course);
	}
	@Override
	public List<Grade> findByClass(com.ClassMIS.table.Class classno)
	{
		return gradeDAO.findByClass(classno);
	}
	@Override
	public List<Grade> findByCourseClass(Course course,com.ClassMIS.table.Class classno)
	{
		return gradeDAO.findByCourseClass(course,classno);
	}
	
	@Override
	public boolean findById(GradeId id)
	{
		if(gradeDAO.findById(id))
		{
			return true;			
		}
		else
		{
			return false;
		}
	}
	@Override
	public boolean updateGrade(Grade grade)
	{
		if(gradeDAO.updateGrade(grade))
		{
			return true;			
		}
		else
		{
			return false;
		}
	}
}
