package com.ClassMIS.table;

import java.util.HashSet;
import java.util.Set;

/**
 * Class entity. @author MyEclipse Persistence Tools
 */

public class Class implements java.io.Serializable
{

	// Fields

	private String no;
	private String name;
	private Set students = new HashSet(0);

	// Constructors

	/** default constructor */
	public Class()
	{
	}

	/** minimal constructor */
	public Class(String no)
	{
		this.no = no;
	}

	/** full constructor */
	public Class(String no, String name, Set students)
	{
		this.no = no;
		this.name = name;
		this.students = students;
	}

	// Property accessors

	public String getNo()
	{
		return this.no;
	}

	public void setNo(String no)
	{
		this.no = no;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Set getStudents()
	{
		return this.students;
	}

	public void setStudents(Set students)
	{
		this.students = students;
	}

}