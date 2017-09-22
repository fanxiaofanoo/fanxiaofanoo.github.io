package com.ClassMIS.table;

/**
 * Grade entity. @author MyEclipse Persistence Tools
 */

public class Grade implements java.io.Serializable
{

	// Fields

	private GradeId id;
	private Integer grade;

	// Constructors

	/** default constructor */
	public Grade()
	{
	}

	/** minimal constructor */
	public Grade(GradeId id)
	{
		this.id = id;
	}

	/** full constructor */
	public Grade(GradeId id, Integer grade)
	{
		this.id = id;
		this.grade = grade;
	}

	// Property accessors

	public GradeId getId()
	{
		return this.id;
	}

	public void setId(GradeId id)
	{
		this.id = id;
	}

	public Integer getGrade()
	{
		return this.grade;
	}

	public void setGrade(Integer grade)
	{
		this.grade = grade;
	}

}