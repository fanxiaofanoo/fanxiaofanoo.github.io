package com.ClassMIS.action;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test
{
	@org.junit.Test
	public void tt()
	{
		BeanFactory beanFactory=new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(beanFactory.getBean("studentServiceImpl"));
	}
}
