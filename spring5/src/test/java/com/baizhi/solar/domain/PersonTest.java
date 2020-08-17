package com.baizhi.solar.domain;
import java.applet.AppletContext;

import org.springframework.context.ApplicationContext;

import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonTest extends TestCase {

	@Test
	public void testPerson() {
//		1.获得spring的工厂
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
//		2.通过工厂类获得对象
		Person person = (Person) ctx.getBean("person");
		System.out.println(person.toString());
	}

	@Test
	public void test2() {
		//		1.获得spring的工厂
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
		/*Person person = ctx.getBean("person", Person.class);
		System.out.println(person.toString());
		* */
		/*Person person = ctx.getBean( Person.class);
		System.out.println(person.toString());
		* */
		//获取的是 spring工厂配置文件中所有bean标签的id的值
		String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println(beanDefinitionName);
		}

		//根据类型来获得spring配置文件中所有id值
		String[] beanNamesForType = ctx.getBeanNamesForType(Person.class);
		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println(beanDefinitionName);
		}

		//用于判断是否存在指定的id的bean,不能判断name值
		if (ctx.containsBeanDefinition("person")) {
			System.out.println("true=" + true);
		} else {
			System.out.println("false = " + false);
		}

		//用于判断是否存在指定的id的bean，也可以判断name值
		if (ctx.containsBean("person")) {
			System.out.println("true=" + true);
		} else {
			System.out.println("false = " + false);
		}

	}
}