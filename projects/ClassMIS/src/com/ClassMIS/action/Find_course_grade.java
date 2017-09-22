package com.ClassMIS.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ClassMIS.service.ClassService;
import com.ClassMIS.service.CourseService;
import com.ClassMIS.service.GradeService;
import com.ClassMIS.table.Course;
import com.ClassMIS.table.Grade;
import com.opensymphony.xwork2.ActionSupport;

public class Find_course_grade extends ActionSupport
{
	// 变量 *********************************************************************
	private int max1=0,min1=0,avge=0,studentNum=0;

	private String MAX;
	private String MIN;
	private String AVGE;
	
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
	public int getStudentNum()
	{
		return studentNum;
	}

	public void setStudentNum(int studentNum)
	{
		this.studentNum = studentNum;
	}

	public int getMax1()
	{
		return max1;
	}

	public void setMax1(int max1)
	{
		this.max1 = max1;
	}

	public int getMin1()
	{
		return min1;
	}

	public void setMin1(int min1)
	{
		this.min1 = min1;
	}

	public int getAvge()
	{
		return avge;
	}

	public void setAvge(int avge)
	{
		this.avge = avge;
	}

	public com.ClassMIS.table.Class getClasso()
	{
		return classo;
	}

	public void setClasso(com.ClassMIS.table.Class classo)
	{
		this.classo = classo;
	}

	public Course getCourseo()
	{
		return courseo;
	}

	public void setCourseo(Course courseo)
	{
		this.courseo = courseo;
	}
	public String getMAX()
	{
		return MAX;
	}

	public void setMAX(String mAX)
	{
		MAX = mAX;
	}

	public String getMIN()
	{
		return MIN;
	}

	public void setMIN(String mIN)
	{
		MIN = mIN;
	}

	public String getAVGE()
	{
		return AVGE;
	}

	public void setAVGE(String aVGE)
	{
		AVGE = aVGE;
	}
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
			
			max1=0;min1=0;avge=0;studentNum=0;
			
			for(Grade item:grade)
			{
				if(item.getGrade()!=null)
				{
					max1=item.getGrade();
					min1=item.getGrade();
					break;
				}
			}		

			for(Grade item:grade)
			{
				if(item.getGrade()!=null)
				{
					studentNum++;
					if(item.getGrade()>max1)
					{
						max1=item.getGrade();
					}
					if(item.getGrade()<min1)
					{
						min1=item.getGrade();
					}
					avge=avge+item.getGrade();
				}
			}
			MAX=String.valueOf(max1);
			MIN=String.valueOf(min1);
			if(studentNum!=0)
			{
				double a=avge;
				double b=studentNum;
				double av=(double)(a/b);
				AVGE=String.valueOf(av);
			}
			else
			{
				AVGE="0";
			}
			System.out.println(max1+"-"+min1+"-"+avge+"-"+studentNum);
			System.out.println(MAX+"-"+MIN+"-"+AVGE);			
		}
		catch(Exception e)
		{
			System.out.println("出错了");
	
		}
		
		return SUCCESS;
	}
}
