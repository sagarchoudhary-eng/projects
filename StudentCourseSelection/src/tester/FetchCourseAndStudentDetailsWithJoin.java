package tester;

import org.hibernate.*;

import dao.CourseDaoImpl;

import static java.time.LocalDate.parse;

import pojos.Course;
import pojos.Student;

import static utils.HibernateUtils.getSf;

import java.time.LocalDate;
import java.util.Scanner;

public class FetchCourseAndStudentDetailsWithJoin {

	public static void main(String[] args) {
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
			// dao instance
			CourseDaoImpl dao = new CourseDaoImpl();
			System.out.println("Enter course title");
			Course c=dao.getCourseAndStudentDetailsJoinFetch(sc.next());
			System.out.println("Course Details");
			System.out.println(c);//ONLY course details 
			System.out.println("Associated student details");
			//display student details
			for(Student s : c.getStudents())
				System.out.println(s);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
