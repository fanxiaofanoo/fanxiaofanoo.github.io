package com.ClassMIS.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import com.ClassMIS.dao.CourseDAO;
import com.ClassMIS.table.Class;
import com.ClassMIS.table.Course;

/**
 * A data access object (DAO) providing persistence and search support for
 * Course entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.ClassMIS.table.Course
 * @author MyEclipse Persistence Tools
 */
public class CourseDAOImpl implements CourseDAO
{
	private SessionFactory sessionFactory;
	private Session session;
	
	public static CourseDAOImpl getFromApplicationContext(ApplicationContext ctx)
	{
		return (CourseDAOImpl) ctx.getBean("CourseDAO");
	}

	public SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	@Override
	public boolean checkCourseno(String no)
	{
		try
		{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Course.class);
			criteria.add(Restrictions.eq("no",no));
			
			if(criteria.list().size() == 0)
			{
				session.close();
				return false;
			}
			else
			{
				session.close();
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addCourse(Course course)
	{
		try
		{
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(course);
			session.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Override
	public List<Course> findAll()
	{
		List<Course> course = null;
		try
		{			
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Course.class);
			course = criteria.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		return course;
	}
	@Override
	public boolean deleteByno(String no)
	{
		try
		{			
			session = sessionFactory.openSession();
			session.beginTransaction();
			Course course = (Course) session.load(Course.class,no);
			session.delete(course);
			session.getTransaction().commit();			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Override
	public Course findByno(String no)
	{
		Course course = null;
		try
		{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Course.class);
			criteria.add(Restrictions.eq("no",no));
			course = (Course) criteria.list().get(0);			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		return course;
	}
	@Override
	public Course findByname(String name)
	{
		Course course = null;
		try
		{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Course.class);
			criteria.add(Restrictions.eq("name",name));
			course = (Course) criteria.list().get(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		return course;
	}
	@Override
	public boolean editCourse(Course course)
	{
		try
		{
			session = sessionFactory.openSession();
			session.beginTransaction();
			Course oldCourse = (Course) session.load(Course.class,course.getNo());		
			oldCourse.setName(course.getName());	
			oldCourse.setNature(course.getNature());
			oldCourse.setCredit(course.getCredit());
			session.update(oldCourse);
			session.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
}