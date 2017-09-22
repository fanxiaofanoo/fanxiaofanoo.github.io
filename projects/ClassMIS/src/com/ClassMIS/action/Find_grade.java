package com.ClassMIS.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.ClassMIS.service.ClassService;
import com.ClassMIS.service.CourseService;
import com.ClassMIS.service.GradeService;
import com.ClassMIS.service.StudentService;
import com.ClassMIS.table.Course;
import com.ClassMIS.table.Grade;
import com.ClassMIS.table.Student;
import com.opensymphony.xwork2.ActionSupport;

public class Find_grade extends ActionSupport
{
	// 变量 *********************************************************************
	private HttpServletRequest request;
	private javax.servlet.http.HttpServletResponse response;  
	
	private String classNum;
	private String courseNum;
	private String classStr;
	private String courseStr;
	
	private GradeService gradeService;	
	private List<Grade> grade;
	
	private ClassService classService;	
	private List<com.ClassMIS.table.Class> classno;
	private com.ClassMIS.table.Class classo;
	
	private CourseService courseService;
	private List<Course> course;
	private Course courseo;
	
	// 函数 *********************************************************************
	public String getClassNum()
	{
		return classNum;
	}

	public void setClassNum(String classNum)
	{
		this.classNum = classNum;
	}

	public String getCourseNum()
	{
		return courseNum;
	}

	public void setCourseNum(String courseNum)
	{
		this.courseNum = courseNum;
	}
	public String getClassStr()
	{
		return classStr;
	}

	public void setClassStr(String classStr)
	{
		this.classStr = classStr;
	}

	public String getCourseStr()
	{
		return courseStr;
	}

	public void setCourseStr(String courseStr) 
	{
		this.courseStr = courseStr;
	}
	public HttpServletRequest getRequest()
	{
		return request;
	}

	public void setRequest(HttpServletRequest request)
	{
		this.request = request;
	}

	public javax.servlet.http.HttpServletResponse getResponse()
	{
		return response;
	}

	public void setResponse(javax.servlet.http.HttpServletResponse response)
	{
		this.response = response;
	}

	public GradeService getGradeService()
	{
		return gradeService;
	}

	public void setGradeService(GradeService gradeService)
	{
		this.gradeService = gradeService;
	}

	public List<Grade> getGrade()
	{
		return grade;
	}

	public void setGrade(List<Grade> grade)
	{
		this.grade = grade;
	}

	public ClassService getClassService()
	{
		return classService;
	}

	public void setClassService(ClassService classService)
	{
		this.classService = classService;
	}

	public List<com.ClassMIS.table.Class> getClassno()
	{
		return classno;
	}

	public void setClassno(List<com.ClassMIS.table.Class> classno)
	{
		this.classno = classno;
	}

	public CourseService getCourseService()
	{
		return courseService;
	}

	public void setCourseService(CourseService courseService)
	{
		this.courseService = courseService;
	}

	public List<Course> getCourse()
	{
		return course;
	}

	public void setCourse(List<Course> course)
	{
		this.course = course;
	}

	@Override
	public String execute() throws Exception
	{
		System.out.println("Find_grade的execute执行");
		System.out.println(getClassStr()+getCourseStr());
			
		try
		{
			classno=classService.findAll();
			course=courseService.findAll();
			
			if(classStr.equals("全部")&&courseStr.equals("全部"))
			{
				grade=gradeService.findAll();
				
				classNum="全部";
				courseNum="全部";
				classStr="全部";
				courseStr="全部";
			}
			else if(classStr.equals("全部"))
			{
				courseo=courseService.findByno(courseStr);			
				grade=gradeService.findByCourse(courseo);
				
				classNum="全部";
				courseNum=courseo.getNo();
				courseStr=courseo.getName();			
			}
			else if(courseStr.equals("全部"))
			{	
				classo=classService.findByno(getClassStr());	
				grade=gradeService.findByClass(classo);
				
				courseNum="全部";
				classNum=classo.getNo();
				classStr=classo.getName();
			}
			else
			{
				courseo=courseService.findByno(courseStr);
				classo=classService.findByno(getClassStr());			
				grade=gradeService.findByCourseClass(courseo,classo);
				
				classNum=classo.getNo();
				classStr=classo.getName();
				courseNum=courseo.getNo();
				courseStr=courseo.getName();
			}
			
		}
		catch(Exception e)
		{
			System.out.println("出错了");
	
		}
		
		return SUCCESS;
	}
}
