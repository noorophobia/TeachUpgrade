package Classroom;
 

import java.util.*;

import login.Student;
 
public class ClassroomClass {

	//int classID;
	int classID;
	String className;
	public ClassroomClass(){
	//	classID=0;
		className=" ";
		classID=0;
	}
	 
	public ClassroomClass(int classID,String className) {
	//	this.classID=classID;
		this.className=className;	
		this.classID=classID;
	}
	void createClass(String className){
	this.className=className;
	
	}
	void deleteClass(String className) {
		
	}
	void enrollInClass(String classID) {}
	void leaveClass() { }
	void addStudentInClass(Student student) {}
	void removeStudent(Student student) {}
}