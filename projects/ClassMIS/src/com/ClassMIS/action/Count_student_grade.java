package com.ClassMIS.action;

import java.util.ArrayList;
import java.util.List;

import com.ClassMIS.service.ClassService;
import com.ClassMIS.service.CourseService;
import com.ClassMIS.service.GradeService;
import com.ClassMIS.service.StudentService;
import com.ClassMIS.table.Count_course;
import com.ClassMIS.table.Count_grade;
import com.ClassMIS.table.Course;
import com.ClassMIS.table.Grade;
import com.ClassMIS.table.Student;
import com.opensymphony.xwork2.ActionSupport;

public class Count_student_grade extends ActionSupport
{
	private List<Count_grade> count_grade;
	private List<Count_course> count_course;
	
	private StudentService studentService;
	private List<Student> student;
	
	private GradeService gradeService;	
	private List<Grade> grade;
	
	private CourseService courseService;
	private List<Course> course;
	
	private ClassService classService;	
	private List<com.ClassMIS.table.Class> classno;
	
	@Override
	public String execute() throws Exception
	{
		try
		{
			count_grade=new ArrayList<Count_grade>();
			count_course=new ArrayList<Count_course>();
			
			student=studentService.findAll();
			grade=gradeService.findAll();
			course=courseService.findAll();
				
			for(Course item2:course)
			{
				Count_course countcourse=new Count_course();
				
				countcourse.setNo(item2.getNo());	
				countcourse.setName(item2.getName());					
				countcourse.setNature(item2.getNature());		
				countcourse.setCredit(item2.getCredit());		
				count_course.add(countcourse);
				
				System.out.println("成绩列表长度："+count_course.size());
			}
			
			for(Student item1:student)
			{
				Count_grade countgrade=new Count_grade();
				
				countgrade.setNo(item1.getNo());
				countgrade.setName(item1.getName());		
				countgrade.setClassno(item1.getClassno());
				
				List<Count_course> count_course_list=new ArrayList<Count_course>();
				double count=0;
				
				for(Course item2:course)
				{
					Count_course countcourse=new Count_course();
					
					countcourse.setNo(item2.getNo());		
					countcourse.setName(item2.getName());		
					countcourse.setNature(item2.getNature());		
					countcourse.setCredit(item2.getCredit());
					
					for(Grade item3:grade)
					{
						if(item3.getId().getStudent().getNo().equals(item1.getNo())&&item3.getId().getCourse().getNo().equals(item2.getNo()))
						{
							if(item3.getGrade()!=null)
							{
								countcourse.setGrade(item3.getGrade().toString());
								if(item3.getGrade()>=60)
								{
									System.out.println("成绩："+countcourse.getGrade());
									count=count+Double.parseDouble(item2.getCredit());
								}		
							}
							break;
						}
					}
					count_course_list.add(countcourse);							
				}
				
				countgrade.setCount_course(count_course_list);
				countgrade.setCount(String.valueOf(count));
				
				count_grade.add(countgrade);		
			}
			System.out.println("总列表长度："+count_grade.size());
		}
		catch(Exception e)
		{
			
		}
		return SUCCESS;
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


	public List<Count_grade> getCount_grade()
	{
		return count_grade;
	}


	public void setCount_grade(List<Count_grade> count_grade)
	{
		this.count_grade = count_grade;
	}
	public List<Count_course> getCount_course()
	{
		return count_course;
	}


	public void setCount_course(List<Count_course> count_course)
	{
		this.count_course = count_course;
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
}
