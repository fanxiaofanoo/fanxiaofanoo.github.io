package com.ClassMIS.dao;

import java.util.List;

import com.ClassMIS.table.Student;

public interface StudentDAO
{
	public boolean loginCheck(String username,String password);
	public boolean addStudent(Student student);
	public boolean checkStudentno(String no);
	public List<Student> findAll();
	public boolean deleteByno(String no);
	public Student findByno(String no);
	public boolean editStudent(Student student);
}
