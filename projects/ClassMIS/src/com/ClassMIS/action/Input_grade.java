package com.ClassMIS.action;

import java.util.List;

import com.ClassMIS.service.ClassService;
import com.ClassMIS.service.CourseService;
import com.ClassMIS.service.GradeService;
import com.ClassMIS.service.StudentService;
import com.ClassMIS.table.Course;
import com.ClassMIS.table.Grade;
import com.ClassMIS.table.GradeId;
import com.ClassMIS.table.Student;
import com.opensymphony.xwork2.ActionSupport;

public class Input_grade extends ActionSupport
{
	// 变量 *********************************************************************
	private String classNum;
	private String courseNum;
	
	private String classStr;
	private String courseStr;
	
	private GradeId gradeId;
	private Grade grades;
	
	private GradeService gradeService;	
	private List<Grade> grade;
	
	private ClassService classService;	
	private List<com.ClassMIS.table.Class> classno;
	
	private CourseService courseService;
	private List<Course> course;
	
	private StudentService studentService;
	private List<Student> student;
	
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
	public GradeId getGradeId()
	{
		return gradeId;
	}
	public void setGradeId(GradeId gradeId)
	{
		this.gradeId = gradeId;
	}
	public Grade getGrades()
	{
		return grades;
	}
	public void setGrades(Grade grades)
	{
		this.grades = grades;
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
	public StudentService getStudentService()
	{
		return studentService;
	}
	public void setStudentService(StudentService studentService)
	{
		this.studentService = studentService;
	}
	public List<Student> getStudent()
	{
		return student;
	}
	public void setStudent(List<Student> student)
	{
		this.student = student;
	}
	@Override
	public String execute() throws Exception
	{
		try
		{
			classNum="全部";
			courseNum="全部";
			classStr="全部";
			courseStr="全部";
			
			gradeId=new GradeId();
			grades=new Grade();
			
			classno=classService.findAll();
			course=courseService.findAll();
			student=studentService.findAll();
			
			for(Student item1:student)
		    {
				for(Course item2:course)
			    {
					gradeId.setStudent(item1);
					gradeId.setCourse(item2);				
					grades.setId(gradeId);
					
					if(!gradeService.findById(gradeId))
					{
						gradeService.SaveOrUpdate(grades);
					}					
			    }         	  	
		    }
			grade=gradeService.findAll();
		}
		catch(Exception e)
		{
			
		}
		return SUCCESS;
	}
}
