package com.ClassMIS.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ClassMIS.dao.GradeDAO;
import com.ClassMIS.table.Course;
import com.ClassMIS.table.Grade;
import com.ClassMIS.table.GradeId;
import com.ClassMIS.table.Student;

/**
 * A data access object (DAO) providing persistence and search support for Grade
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.ClassMIS.table.Grade
 * @author MyEclipse Persistence Tools
 */
public class GradeDAOImpl implements GradeDAO
{
	private SessionFactory sessionFactory;
	private Session session;
	private Session session2;

	public SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	public static GradeDAOImpl getFromApplicationContext(ApplicationContext ctx)
	{
		return (GradeDAOImpl) ctx.getBean("GradeDAO");
	}

	@Override
	public boolean SaveOrUpdate(Grade grade)
	{
		// TODO Auto-generated method stub
		try
		{
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(grade);
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
	public List<Grade> findAll()
	{
		List<Grade> gradeList = null;
		try
		{			
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Grade.class);
			gradeList = criteria.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		return gradeList;
	}
	public List<Grade> findByCourse(Course course)
	{
		List<Grade> gradeList = null;
	
		try
		{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Grade.class);
			criteria.add(Restrictions.eq("id.course",course));
			gradeList = criteria.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		return gradeList;
	}
	public List<Grade> findByClass(com.ClassMIS.table.Class classno)
	{
		List<Grade> gradeList1 = null;
		List<Grade> gradeList2 = new ArrayList<Grade>();
		List<Student> student=null;
		try
		{ 
			session = sessionFactory.openSession();
			Criteria criteria1 = session.createCriteria(Grade.class);
			gradeList1= criteria1.list();			
			
			session2 = sessionFactory.openSession();
			Criteria criteria2 = session.createCriteria(Student.class);
			criteria2.add(Restrictions.eq("classno",classno));
			student= criteria2.list();	
			
			System.out.println(student.size());
			
			for(Grade item1:gradeList1)
			{
				for(Student item2:student)
				{
					if(item1.getId().getStudent().equals(item2))
					{
						gradeList2.add(item1);
					}
				}				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		return gradeList2;
	}
	public List<Grade> findByCourseClass(Course course,com.ClassMIS.table.Class classno)
	{
		List<Grade> gradeList1 = null;
		List<Grade> gradeList2 = new ArrayList<Grade>();
		List<Student> student=null;
		
		try
		{
			session = sessionFactory.openSession();
			Criteria criteria1 = session.createCriteria(Grade.class);
			criteria1.add(Restrictions.eq("id.course",course));
			gradeList1= criteria1.list();
						
			session2 = sessionFactory.openSession();
			Criteria criteria2 = session.createCriteria(Student.class);
			criteria2.add(Restrictions.eq("classno",classno));
			student= criteria2.list();	
			
			for(Grade item1:gradeList1)
			{
				for(Student item2:student)
				{
					if(item1.getId().getStudent().equals(item2))
					{
						gradeList2.add(item1);
					}
				}				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		return gradeList2;
	}
	@Override
	public boolean findById(GradeId id)
	{
		try
		{			
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Grade.class);
			criteria.add(Restrictions.eq("id",id));
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
	public boolean updateGrade(Grade grade)
	{
		try
		{
			session = sessionFactory.openSession();
			session.beginTransaction();
			Grade oldGrade = (Grade) session.load(Grade.class,grade.getId());				
			oldGrade.setGrade(grade.getGrade());	
			session.update(oldGrade);
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