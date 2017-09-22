package com.ClassMIS.action;

import com.ClassMIS.service.StudentService;
import com.ClassMIS.table.Student;
import com.opensymphony.xwork2.ActionSupport;

public class Edit_student extends ActionSupport
{
	// 变量 *********************************************************************
	private String no = "";
	private String name = "";
	private String sex;
	private String birthday;
	private String phone;
	private String adress;
	private String classno;
	private String result;
	private StudentService studentService;
	private Student student;
	
	// 函数 *********************************************************************
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
	public String getSex()
	{
		return sex;
	}
	public void setSex(String sex)
	{
		this.sex = sex;
	}
	public String getBirthday()
	{
		return birthday;
	}
	public void setBirthday(String birthday)
	{
		this.birthday = birthday;
	}
	public String getPhone()
	{
		return phone;
	}
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	public String getAdress()
	{
		return adress;
	}
	public void setAdress(String adress)
	{
		this.adress = adress;
	}
	public String getClassno()
	{
		return classno;
	}
	public void setClassno(String classno)
	{
		this.classno = classno;
	}
	public String getResult()
	{
		return result;
	}
	public void setResult(String result)
	{
		this.result = result;
	}
	public StudentService getStudentService()
	{
		return studentService;
	}
	public void setStudentService(StudentService studentService)
	{
		this.studentService = studentService;
	}
	public Student getStudent()
	{
		return student;
	}
	public void setStudent(Student student)
	{
		this.student = student;
	}
	
	@Override
	public String execute() throws Exception
	{
		System.out.println("执行Edit_student的execute！");
		System.out.println(getNo()+getName());
		
		try
		{
			student=studentService.findByno(getNo());
			
			setNo(student.getNo());
			setName(student.getName());
			setSex(student.getSex());
			setBirthday(student.getBrithday());
			setPhone(student.getPhone());
			setAdress(student.getAdress());
			setClassno(student.getClassno().getNo());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return SUCCESS;
	}		
}
