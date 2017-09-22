package com.ClassMIS.table;

import java.util.HashSet;
import java.util.Set;

/**
 * Course entity. @author MyEclipse Persistence Tools
 */

public class Course implements java.io.Serializable
{

	// Fields

	private String no;
	private String name;
	private String nature;
	private String credit;
	private Set grades = new HashSet(0);

	// Constructors

	/** default constructor */
	public Course()
	{
	}

	/** minimal constructor */
	public Course(String no)
	{
		this.no = no;
	}

	/** full constructor */
	public Course(String no, String name, String nature, String credit,
			Set grades)
	{
		this.no = no;
		this.name = name;
		this.nature = nature;
		this.credit = credit;
		this.grades = grades;
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

	public String getNature()
	{
		return this.nature;
	}

	public void setNature(String nature)
	{
		this.nature = nature;
	}

	public String getCredit()
	{
		return this.credit;
	}

	public void setCredit(String credit)
	{
		this.credit = credit;
	}

	public Set getGrades()
	{
		return this.grades;
	}

	public void setGrades(Set grades)
	{
		this.grades = grades;
	}

}