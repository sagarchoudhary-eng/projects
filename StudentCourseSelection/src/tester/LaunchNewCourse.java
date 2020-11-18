package tester;

import org.hibernate.*;

import dao.CourseDaoImpl;

import static java.time.LocalDate.parse;

import pojos.Course;
import pojos.Student;

import static utils.HibernateUtils.getSf;

import java.time.LocalDate;
import java.util.Scanner;

public class LaunchNewCourse {

	public static void main(String[] args) {
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
			//dao instance
			CourseDaoImpl dao=new CourseDaoImpl();
			System.out.println("Enter course Details :  title, beginDate(yr-mon-day),  endDate,  capacity,  fees");
			Course c1 = new Course(sc.next(), parse(sc.next()), parse(sc.next()), sc.nextInt(), sc.nextDouble());
		
			//accepting student admits
			for(int i=0;i<3;i++)
			{
				System.out.println("Enter Student details name n email");
				Student s=new Student(sc.next(), sc.next());
				c1.addStudent(s);
				
				/*
				 * //add this student in the list of students //esatblished a link from course
				 * ----> student c1.getStudents().add(s);//added student ref in course
				 * System.out.println(s.getSelectedCourse());//null //establish a link from
				 * student ---> course s.setSelectedCourse(c1);
				 * System.out.println(s.getSelectedCourse());//not null
				 */		
			}
			//invoke dao's method
			System.out.println(dao.launchNewCourse(c1));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
