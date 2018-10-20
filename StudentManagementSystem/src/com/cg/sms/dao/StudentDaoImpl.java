package com.cg.sms.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import com.cg.sms.dto.Student;

public class StudentDaoImpl implements StudentDao {
	Map<Integer,Student> studentMap ;
	public StudentDaoImpl(){
		studentMap = DataStore.createCollection();
	}

	@Override
	public int addStudent(Student student) {
		// TODO Auto-generated method stub
         int rollno=(int)(1000*Math.random());
         student.setRollno(rollno);
         studentMap.put(rollno, student);
		return rollno;
	}

	@Override
	public Student getStudent (int rn) {
		// TODO Auto-generated method stub
		Student stud = studentMap.get(rn);
		return stud;
		
		
		
	}

	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		studentMap.put(student.getRollno(),student);
		return student;
	}

	@Override
	public ArrayList<Student> getStudentList(String coursename) {
		// TODO Auto-generated method stub
		Collection<Student> studlist=studentMap.values();
		ArrayList<Student> students=new ArrayList<>();
		
		for(Student s: studlist){
					if(s.getCoursename().equals(coursename)){
			students.add(s);
		}
		}
			return students;
	}
	

}
