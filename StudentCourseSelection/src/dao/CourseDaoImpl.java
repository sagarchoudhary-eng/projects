package dao;

import static utils.HibernateUtils.getSf;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Course;

public class CourseDaoImpl implements ICourseDao {

	@Override
	public String launchNewCourse(Course c) {
		String mesg="Course launching failed...";
		// get session
		//c : transient
		Session hs = getSf().getCurrentSession();
		// tx
		Transaction tx = hs.beginTransaction();
		try {
			//save / persist / saveOrUpdate / merge
			hs.persist(c);//c : persistent
			tx.commit(); //insert query
			mesg="New Course launched with ID "+c.getCourseId();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public Course getCourseDetails(String title1) {
		Course c=null;
		String jpql="select c from Course c where c.title=:ti";
		//session
		Session session=getSf().getCurrentSession();
		//tx
		Transaction tx=session.beginTransaction();
		try {
			c=session.createQuery(jpql, Course.class).setParameter("ti", title1).getSingleResult();
			//c => persistent
			tx.commit();
		}catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return c;
	}

	@Override
	public Course getCourseAndStudentDetails(String title1) {
		Course c=null;
		String jpql="select c from Course c where c.title=:ti";
		//session
		Session session=getSf().getCurrentSession();
		//tx
		Transaction tx=session.beginTransaction();
		try {
			c=session.createQuery(jpql, Course.class).setParameter("ti", title1).getSingleResult();//select query on courses table
			//c => persistent
			//access simply the size of collection(list) within the hib session scope
			c.getStudents().size();//select query : students table
			tx.commit();
		}catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return c;//c : DETACHED (containing complete details : course + students)
	}

	@Override
	public Course getCourseAndStudentDetailsJoinFetch(String title) {
		Course c=null;
		String jpql="select c from Course c left outer join fetch c.students where c.title=:ti";
		//session
				Session session=getSf().getCurrentSession();
				//tx
				Transaction tx=session.beginTransaction();
				try {
					c=session.createQuery(jpql, Course.class).setParameter("ti", title).getSingleResult();
					tx.commit();
				}catch (RuntimeException e) {
					if (tx != null)
						tx.rollback();
					throw e;
				}
				return c;
				
	}
	
	

}
