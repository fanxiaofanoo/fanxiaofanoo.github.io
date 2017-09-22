package com.ClassMIS.action;

import com.ClassMIS.service.ClassService;
import com.ClassMIS.service.StudentService;
import com.ClassMIS.table.Class;
import com.ClassMIS.table.Student;
import com.opensymphony.xwork2.ActionSupport;

public class Add_student extends ActionSupport
{
	// 变量 *********************************************************************
	private String no ;
	private String name;
	private String password;
	private String sex;
	private String birthday;
	private String phone;
	private String adress;
	private String classno;
	private String result;
	private StudentService studentService;
	private Student student;
	private ClassService classService;
	
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
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
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
	public ClassService getClassService()
	{
		return classService;
	}
	public void setClassService(ClassService classService)
	{
		this.classService = classService;
	}
	
	@Override
	public String execute() throws Exception
	{
		System.out.println("执行Add_student的execute！");
		System.out.println(getNo()+getName()+getPassword()+getSex()+getBirthday()+getPhone()+getAdress()+getClassno());
		
		try
		{
			Class classEN=(Class)classService.findByno(getClassno());
			
			if(classEN==null&&!getClassno().equals(""))
			{
				result="班级编号不存在！";
			}
			else
			{
				if(studentService.checkStudentno(getNo()))
				{
					result="学号重复！";
				}
				else
				{
					student=new Student();
					student.setNo(getNo());
					student.setName(getName());
					student.setPassword(getPassword());
					student.setSex(getSex());
					student.setBrithday(getBirthday());
					student.setPhone(getPhone());
					student.setAdress(getAdress());
					student.setClassno(classEN);
					
					if(studentService.addStudent(student))
					{result="成功";}
					else
					{result="失败";}
				}			
			}		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
}
