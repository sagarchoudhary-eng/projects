package tester;
import org.hibernate.*;
import static utils.HibernateUtils.getSf;

public class TestHibernate {

	public static void main(String[] args) {
		try(SessionFactory sf=getSf())
		{
			System.out.println("Hibernate booted......");
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
