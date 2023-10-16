package pack;

import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.Scanner;

public class CourseDAO {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		try(Scanner sc=new Scanner(System.in))
		{
		System.out.println("Enter Course ID: ");
		int id=sc.nextInt();
		
		System.out.println("Enter Course Title: ");
		String title=sc.next();
		
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		Course c=new Course();
		
		c.setId(id);
		c.setTitle(title);
		
		
		session.save(c);
		tx.commit();
		System.out.println("Record Inserted with table Creation");
		sf.close();
		session.close();
		}
		catch (HibernateException e) {
			e.printStackTrace();
		}
	}

}
