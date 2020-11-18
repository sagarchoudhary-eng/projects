package dao;

import pojos.Course;

public interface ICourseDao {
	String launchNewCourse(Course c);
	// get course details : title
	Course getCourseDetails(String title);
	//get course + student details : multiple queries
	Course getCourseAndStudentDetails(String title);
	//get course + student details : single join query
	Course getCourseAndStudentDetailsJoinFetch(String title);
}
