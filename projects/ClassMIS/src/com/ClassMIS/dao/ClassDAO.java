package com.ClassMIS.dao;

import java.util.List;

import com.ClassMIS.table.Class;

public interface ClassDAO
{
	public boolean checkClassno(String no);
	public boolean addClass(com.ClassMIS.table.Class classno);
	public Class findByname(String name);
	public Class findByno(String no);
	public List<com.ClassMIS.table.Class> findAll();
	public boolean deleteByno(String no);
	public boolean editClass(com.ClassMIS.table.Class classno);
}
