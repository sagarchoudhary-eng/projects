package tester;

import org.hibernate.*;

import dao.CourseDaoImpl;
import dao.StudentDaoImpl;

import static java.time.LocalDate.parse;

import pojos.Address;
import pojos.Course;
import pojos.Student;

import static utils.HibernateUtils.getSf;

import java.time.LocalDate;
import java.util.Scanner;

public class AssignStudentAddress {

	public static void main(String[] args) {
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
			// student dao instance
			StudentDaoImpl dao = new StudentDaoImpl();
			System.out.println("Enter studen email");
			String email = sc.next();
			System.out.println("Enter adr details : city st co phone");
			System.out
					.println(dao.assignStudentAddress(email,
							new Address(sc.next(), sc.next(), sc.next(), sc.next())));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
