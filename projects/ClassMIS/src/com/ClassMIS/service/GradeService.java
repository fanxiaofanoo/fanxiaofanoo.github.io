package com.ClassMIS.service;

import java.util.List;

import com.ClassMIS.table.Course;
import com.ClassMIS.table.Grade;
import com.ClassMIS.table.GradeId;

public interface GradeService
{
	//将学生信息，课程信息保存到成绩表
	public boolean SaveOrUpdate(Grade grade);
	//查询成绩表的所有信息
	public List<Grade> findAll();
	//根据课程查询成绩表信息
	public List<Grade> findByCourse(Course course);
	//根据班级查询成绩表信息
	public List<Grade> findByClass(com.ClassMIS.table.Class classno);
	//根据课程和班级查询成绩表信息
	public List<Grade> findByCourseClass(Course course,com.ClassMIS.table.Class classno);
	//查询课程表中是否存在ID
	public boolean findById(GradeId id);
	//更新课程表信息
	public boolean updateGrade(Grade grade);
}
