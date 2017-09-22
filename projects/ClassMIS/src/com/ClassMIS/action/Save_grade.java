package com.ClassMIS.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.ClassMIS.service.ClassService;
import com.ClassMIS.service.CourseService;
import com.ClassMIS.service.GradeService;
import com.ClassMIS.service.StudentService;
import com.ClassMIS.table.Course;
import com.ClassMIS.table.Grade;
import com.ClassMIS.table.GradeId;
import com.ClassMIS.table.Student;
import com.opensymphony.xwork2.ActionSupport;

public class Save_grade extends ActionSupport
{
	private String no;
	private String name;
	private int grade;
	private String result;
	private ClassService classService;	
	private CourseService courseService;
	private GradeService gradeService;
	private StudentService studentService;
	private Course course;
	private com.ClassMIS.table.Class classno;
	private Student student;
	
	public StudentService getStudentService()
	{
		return studentService;
	}

	public void setStudentService(StudentService studentService)
	{
		this.studentService = studentService;
	}

	public Course getCourse()
	{
		return course;
	}

	public void setCourse(Course course)
	{
		this.course = course;
	}

	public com.ClassMIS.table.Class getClassno()
	{
		return classno;
	}

	public void setClassno(com.ClassMIS.table.Class classno)
	{
		this.classno = classno;
	}

	public Student getStudent()
	{
		return student;
	}

	public void setStudent(Student student)
	{
		this.student = student;
	}

	public String save() throws Exception
	{
		System.out.println("执行Save_grade的execute的方法");
		System.out.println(getNo()+getName()+getGrade());
		
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("test/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try
		{
			course=(Course)courseService.findByname(getName());
			student=(Student)studentService.findByno(no.toString());
			
			if(course==null||student==null)
			{
				out.print("{\"success\":false,\"msg\":\"保存失败\"}");
			}
			else
			{				
				GradeId id=new GradeId(student,course);
				Grade gra=new Grade(id,grade);
				if(gradeService.updateGrade(gra))
				{
					out.print("{\"success\":true,\"msg\":\"保存成功\"}");
				}
				else
				{
//					out.flush();
//					out.println("<script>");
//					out.println("alert('学号：'"+no+"',=的课程：'"+name+"'成绩保存失败!')");
//					out.println("<script>");
					out.print("{\"success\":false,\"msg\":\"保存失败\"}");

				}
			}
			
		}
		catch(Exception e)
		{
//			out.flush();
//			out.println("<script>");
//			out.println("alert('学号：'"+no+"',=的课程：'"+name+"'成绩保存失败!')");
//			out.println("<script>");
			out.print("{\"success\":false,\"msg\":\"保存失败\"}");
		}
		
	     out.close();
		
		return NONE;
	}

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

	public int getGrade()
	{
		return grade;
	}

	public void setGrade(int grade)
	{
		this.grade = grade;
	}

	public String getResult()
	{
		return result;
	}

	public void setResult(String result)
	{
		this.result = result;
	}
	public ClassService getClassService()
	{
		return classService;
	}

	public void setClassService(ClassService classService)
	{
		this.classService = classService;
	}
	public GradeService getGradeService()
	{
		return gradeService;
	}

	public void setGradeService(GradeService gradeService)
	{
		this.gradeService = gradeService;
	}

	public CourseService getCourseService()
	{
		return courseService;
	}

	public void setCourseService(CourseService courseService)
	{
		this.courseService = courseService;
	}
}
