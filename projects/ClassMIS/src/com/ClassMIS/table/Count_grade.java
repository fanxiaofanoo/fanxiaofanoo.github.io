package com.ClassMIS.table;

import java.util.List;

public class Count_grade
{
	private String no;
	private String name;
	private Class classno;
	
	private List<Count_course> count_course;
	
	private String count;

	public String getNo()
	{
		return no;
	}

	public void setNo(String no)
	{
		this.no = no;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Class getClassno()
	{
		return classno;
	}

	public void setClassno(Class classno)
	{
		this.classno = classno;
	}

	public List<Count_course> getCount_course()
	{
		return count_course;
	}

	public void setCount_course(List<Count_course> count_course)
	{
		this.count_course = count_course;
	}

	public String getCount()
	{
		return count;
	}

	public void setCount(String count)
	{
		this.count = count;
	}
	
}
