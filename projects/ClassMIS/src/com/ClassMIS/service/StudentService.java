package com.ClassMIS.service;

import java.util.List;

import com.ClassMIS.table.Student;

public interface StudentService
{
	//检查用户名和密码是否正确
	public boolean loginCheck(String userName,String password);
	//添加学生信息
	public boolean addStudent(Student student);
	//检查学号是否存在
	public boolean checkStudentno(String no);
	//查询所有的学生信息
	public List<Student> findAll();
	//删除学生信息
	public boolean deleteByno(String no);
	//根据no查询学生信息
	public Student findByno(String no);
	//修改学生信息
	public boolean editStudent(Student student);
}
