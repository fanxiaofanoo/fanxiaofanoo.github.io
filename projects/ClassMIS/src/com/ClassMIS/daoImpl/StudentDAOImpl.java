package com.ClassMIS.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import com.ClassMIS.dao.StudentDAO;
import com.ClassMIS.table.Student;


/**
 * A data access object (DAO) providing persistence and search support for
 * Student entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.ClassMIS.table.Student
 * @author MyEclipse Persistence Tools
 */
public class StudentDAOImpl implements StudentDAO
{	
	private SessionFactory sessionFactory;
	private Session session;
	
	public static StudentDAOImpl getFromApplicationContext(ApplicationContext ctx)
	{
		return (StudentDAOImpl) ctx.getBean("StudentDAO");
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
	public boolean loginCheck(String username,String password)
	{
		try
		{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Student.class);
			criteria.add(Restrictions.eq("no",username));
			criteria.add(Restrictions.eq("password",password));
			
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
	public boolean addStudent(Student student)
	{
		try
		{
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(student);
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
	public boolean checkStudentno(String no)
	{
		try
		{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Student.class);
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
	public List<Student> findAll()
	{
		List<Student> student = null;
		try
		{			
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Student.class);
			student = criteria.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		return student;
	}
	
	public List<Student> findByClass(com.ClassMIS.table.Class classno)
	{
		List<Student> student = null;
		try
		{			
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Student.class);
			criteria.add(Restrictions.eq("classno",classno));
			student = criteria.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		return student;
	}
	@Override
	public boolean deleteByno(String no)
	{
		try
		{			
			session = sessionFactory.openSession();
			session.beginTransaction();
			Student student = (Student) session.load(Student.class,no);
			session.delete(student);
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
	public Student findByno(String no)
	{
		Student student = null;
		try
		{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Student.class);
			criteria.add(Restrictions.eq("no",no));
			student = (Student) criteria.list().get(0);
			return student;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public boolean editStudent(Student student)
	{
		try
		{
			session = sessionFactory.openSession();
			session.beginTransaction();	
			
			Student oldStudent=(Student) session.load(Student.class,student.getNo());
						
			oldStudent.setName(student.getName());
			oldStudent.setSex(student.getSex());
			oldStudent.setPhone(student.getPhone());
			oldStudent.setBrithday(student.getBrithday());
			oldStudent.setAdress(student.getAdress());
			oldStudent.setClassno(student.getClassno());
			
			session.update(oldStudent);
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