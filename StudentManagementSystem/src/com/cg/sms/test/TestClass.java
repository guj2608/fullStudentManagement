package com.cg.sms.test;

import junit.framework.Assert;

import org.junit.Test;

import com.cg.sms.exception.StudentException;
import com.cg.sms.service.StudentService;
import com.cg.sms.service.StudentServiceImpl;



	public class TestClass {

		@Test(expected=StudentException.class)
		public void test_ValidateName_null() throws StudentException{
			StudentService service=new StudentServiceImpl();
			service.validateName(null);
		}
		
		@Test
		public void test_validateName_v1() throws StudentException{
		
			String name="Aete121";
			StudentService service=new StudentServiceImpl();
			boolean result= service.validateName(name);
			Assert.assertEquals(false,result);
		}
		@Test
		public void test_validateName_v2() throws StudentException{
		
			String name="Amita";
			StudentService service=new StudentServiceImpl();
			boolean result= service.validateName(name);
			Assert.assertEquals(true,result);
		}
		@Test
		public void test_validateName_v3() throws StudentException{
		
			String name="amita";
			StudentService service=new StudentServiceImpl();
			boolean result= service.validateName(name);
			Assert.assertEquals(false,result);
		}
		
		@Test
		public void test_validateCourse_v1() throws StudentException{
			String cname="JEE";
			StudentService service=new StudentServiceImpl();
			boolean result=service.validateCourse(cname);
			Assert.assertEquals(false,result);
		}
	}


