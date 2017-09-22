package com.ClassMIS.table;

import java.util.HashSet;
import java.util.Set;


/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student  implements java.io.Serializable {


    // Fields    

     private String no;
     private Class classno;
     private String name;
     private String sex;
     private String brithday;
     private String password;
     private String phone;
     private String adress;
     private Set grades = new HashSet(0);


    // Constructors

    /** default constructor */
    public Student() {
    }

	/** minimal constructor */
    public Student(String no) {
        this.no = no;
    }
    
    /** full constructor */
    public Student(String no, Class classno, String name, String sex, String brithday, String password, String phone, String adress, Set grades) {
        this.no = no;
        this.setClassno(classno);
        this.name = name;
        this.sex = sex;
        this.brithday = brithday;
        this.password = password;
        this.phone = phone;
        this.adress = adress;
        this.grades = grades;
    }

   
    // Property accessors

    public String getNo() {
        return this.no;
    }
    
    public void setNo(String no) {
        this.no = no;
    }

   

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return this.sex;
    }
    
    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBrithday() {
        return this.brithday;
    }
    
    public void setBrithday(String brithday) {
        this.brithday = brithday;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return this.adress;
    }
    
    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Set getGrades() {
        return this.grades;
    }
    
    public void setGrades(Set grades) {
        this.grades = grades;
    }

	public Class getClassno()
	{
		return classno;
	}

	public void setClassno(Class classno)
	{
		this.classno = classno;
	}
   








}