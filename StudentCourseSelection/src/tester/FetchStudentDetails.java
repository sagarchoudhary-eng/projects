package tester;

import org.hibernate.*;

import dao.CourseDaoImpl;
import dao.StudentDaoImpl;

import static java.time.LocalDate.parse;

import pojos.Course;
import pojos.Student;

import static utils.HibernateUtils.getSf;

import java.time.LocalDate;
import java.util.Scanner;

public class FetchStudentDetails {

	public static void main(String[] args) {
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
			// student dao instance
			StudentDaoImpl dao = new StudentDaoImpl();
			System.out.println("Enter student id");
			Student s = dao.fetchDetails(sc.nextInt());//un fetched data in deatched manner(outside session scope)
			//what does load method return , after invoking non id getter
			//proxy : initialized with data from db
			System.out.println(s);
			System.out.println(s.getClass().getName());
			/*
			 * if (s != null) { System.out.println("Enrolled course details");
			 * System.out.println(s.getSelectedCourse()); }
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
