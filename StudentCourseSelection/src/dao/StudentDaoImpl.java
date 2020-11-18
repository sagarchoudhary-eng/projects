package dao;

import static utils.HibernateUtils.getSf;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Address;
import pojos.Course;
import pojos.Student;

public class StudentDaoImpl implements IStudentDao {

	@Override
	public Student fetchDetails(int studentId) {
		Student s = null;
		// session
		Session session = getSf().getCurrentSession();
		// tx
		Transaction tx = session.beginTransaction();
		try {
			s = session.load(Student.class, studentId);// no select query
			// simply invoke non id getter : within session scope (persistent)
			s.getEmail();// select : both (student --> course : many to one : def fetch type : EAGER)
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return s;
	}

	@Override
	public String assignStudentAddress(String email, Address a) {
		String mesg = "assigning address failed...";
		// session
		String jpql = "select s from Student s where s.email=:em";
		Session session = getSf().getCurrentSession();
		// tx
		Transaction tx = session.beginTransaction();
		try {
			// get ONLY student details
			Student s = session.createQuery(jpql, Student.class).setParameter("em", email).getSingleResult();
			// s => persistent
			s.addAdress(a);
			tx.commit();
			mesg = "linked student with adr details";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public String cancelAdmission(int studentId, int courseId) {
		String mesg="cancelling admission failed";
		// session
		Session session = getSf().getCurrentSession();
		// tx
		Transaction tx = session.beginTransaction();
		try {
			//get student details from sid
			Student s=session.get(Student.class, studentId);
			//get course details from cid
			Course c=session.get(Course.class, courseId);
			if(s != null && c != null)
			{
				c.removeStudent(s);
				mesg="admission cancelled";
			}
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

}
