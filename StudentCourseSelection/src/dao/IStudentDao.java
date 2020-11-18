package dao;

import pojos.Address;
import pojos.Student;

public interface IStudentDao {
	//fetch student details : by PK
	Student fetchDetails(int studentId);
	//assign address to existing student : student email, adr details
	String assignStudentAddress(String email, Address a);
	//Cancel admission 	I/P : student id , course id
	String cancelAdmission(int studentId, int courseId);
	
	

}
