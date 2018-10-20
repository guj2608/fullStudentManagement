package com.cg.sms.service;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.sms.dao.StudentDao;
import com.cg.sms.dao.StudentDaoImpl;
import com.cg.sms.dto.Student;
import com.cg.sms.exception.StudentException;

public class StudentServiceImpl implements StudentService {
	StudentDao  dao;
	public StudentServiceImpl(){
	 dao= new StudentDaoImpl();	
	}

	@Override
	public int addStudent(Student student) {
		// TODO Auto-generated method stub
		int rn=dao.addStudent(student);
		return rn;
	}

	@Override
	public Student getStudent(int rn) {
		// TODO Auto-generated method stub
		return dao.getStudent(rn);
	}

	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		return dao.updateStudent(student);
	}

	@Override
	public ArrayList<Student> getStudentList(String coursename) {
		// TODO Auto-generated method stub
		return dao.getStudentList(coursename);
	}

	@Override
	public Student validateDetails(Student student) throws StudentException {
		// TODO Auto-generated method stub
		
				

				if(validateName(student.getName()) && validatePhoneNo(student.getMobileNo()) && validateCourse(student.getCoursename()) ){
				//return student;
					}
				return student;
			
	}

	@Override
	public boolean validateName(String name) throws StudentException {
		// TODO Auto-generated method stub
		if(name==null)
			throw new StudentException("name can not be null");
		Pattern pat = Pattern.compile("[A-Z][a-z]{3,12}");
		Matcher mat= pat.matcher(name);
		return mat.matches();
		}

	@Override
	public boolean validatePhoneNo(String mob) throws StudentException {
		// TODO Auto-generated method stub
		Pattern pat = Pattern.compile("[0-9]{10}");
		Matcher mat= pat.matcher(mob);
		return mat.matches();
	}

	@Override
	public boolean validateCourse(String coursename) throws StudentException {
		// TODO Auto-generated method stub
		if(coursename==null)
			throw new StudentException("name can not be null");
		Pattern pat = Pattern.compile("[JSP][JAVA][AI]");
		Matcher mat= pat.matcher(coursename);
		return mat.matches();
		}


	

}
