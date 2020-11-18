package tester;

import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.StudentDaoImpl;

public class CancelStudentAdmission {

	public static void main(String[] args) {
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
			// student dao instance
			StudentDaoImpl dao = new StudentDaoImpl();
			System.out.println("Enter studen id n course id");
			System.out.println(dao.cancelAdmission(sc.nextInt(), sc.nextInt()));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
