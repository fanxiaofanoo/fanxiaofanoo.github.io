package com.ClassMIS.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import com.ClassMIS.dao.ClassDAO;
import com.ClassMIS.table.Class;

/**
 * A data access object (DAO) providing persistence and search support for Class
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.ClassMIS.table.Class
 * @author MyEclipse Persistence Tools
 */
public class ClassDAOImpl implements ClassDAO
{
	private SessionFactory sessionFactory;
	private Session session;
	

	public SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	public static ClassDAOImpl getFromApplicationContext(ApplicationContext ctx)
	{
		return (ClassDAOImpl) ctx.getBean("ClassDAO");
	}
	
	@Override
	public boolean checkClassno(String no)
	{
		try
		{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(com.ClassMIS.table.Class.class);
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
			return true;
		}
	}
	@Override
	public boolean addClass(com.ClassMIS.table.Class classno)
	{
		try
		{
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(classno);
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
	public com.ClassMIS.table.Class findByno(String no)
	{
		com.ClassMIS.table.Class classno = null;
		try
		{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(com.ClassMIS.table.Class.class);
			criteria.add(Restrictions.eq("no",no));
			classno = (com.ClassMIS.table.Class) criteria.list().get(0);			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		return classno;
	}
	@Override
	public Class findByname(String name)
	{
		com.ClassMIS.table.Class classno = null;
		try
		{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(com.ClassMIS.table.Class.class);
			criteria.add(Restrictions.eq("name",name));
			classno = (com.ClassMIS.table.Class) criteria.list().get(0);			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		return classno;
	}
	@Override
	public List<com.ClassMIS.table.Class> findAll()
	{
		List<com.ClassMIS.table.Class> classList = null;
		try
		{			
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(com.ClassMIS.table.Class.class);
			classList = criteria.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		return classList;
	}
	@Override
	public boolean deleteByno(String no)
	{
		try
		{			
			session = sessionFactory.openSession();
			session.beginTransaction();
			com.ClassMIS.table.Class classno = (com.ClassMIS.table.Class) session.load(com.ClassMIS.table.Class.class,no);
			session.delete(classno);
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
	public boolean editClass(com.ClassMIS.table.Class classno)
	{
		try
		{
			session = sessionFactory.openSession();
			session.beginTransaction();
			com.ClassMIS.table.Class oldClass = (com.ClassMIS.table.Class) session.load(com.ClassMIS.table.Class.class,classno.getNo());		
			oldClass.setName(classno.getName());	
			session.update(oldClass);
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