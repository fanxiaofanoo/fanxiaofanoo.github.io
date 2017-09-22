package com.ClassMIS.service;

import java.util.List;

public interface ClassService
{
	public boolean checkClassno(String no);
	public boolean addClass(com.ClassMIS.table.Class classno);
	public com.ClassMIS.table.Class findByname(String name);
	public com.ClassMIS.table.Class findByno(String no);
	public List<com.ClassMIS.table.Class> findAll();
	public boolean deleteByno(String no);
	public boolean editClass(com.ClassMIS.table.Class classsno);
}
