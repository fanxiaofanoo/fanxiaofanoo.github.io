package com.ClassMIS.dao;

import java.util.List;

import com.ClassMIS.table.Course;
import com.ClassMIS.table.Grade;
import com.ClassMIS.table.GradeId;

public interface GradeDAO
{
	public boolean SaveOrUpdate(Grade grade);
	public List<Grade> findAll();
	public List<Grade> findByCourse(Course course);
	//根据班级查询成绩表信息
	public List<Grade> findByClass(com.ClassMIS.table.Class classno);
	//根据课程和班级查询成绩表信息
	public List<Grade> findByCourseClass(Course course,com.ClassMIS.table.Class classno);
	public boolean findById(GradeId id);
	public boolean updateGrade(Grade grade);
}
