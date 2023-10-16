package pack;

import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.Scanner;

public class StudentDAO {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		try(Scanner sc=new Scanner(System.in))
		{
			System.out.println("Enter Student ID : ");
			int stud_id=sc.nextInt();
			System.out.println("Enter Student First Name");
			String firstname=sc.next();
			System.out.println("Enter Student Last Name");
			String lastname=sc.next();
			System.out.println("Enter City");
			String city=sc.next();
			System.out.println("Enter Student Age");
			int age=sc.nextInt();
			
			SessionFactory sf=cfg.buildSessionFactory();
			Session session=sf.openSession();
			Transaction tx=session.beginTransaction();
			Student s=new Student();
			s.setStud_id(stud_id);
			s.setFirstname(firstname);
			s.setLastname(lastname);
			s.setCity(city);
			s.setAge(age);
			
			session.save(s);
			tx.commit();
			System.out.println("Record Inserted with table Creation");
			sf.close();
			session.close();
		}
		catch(HibernateException e){
			e.printStackTrace();
	}

	}}
