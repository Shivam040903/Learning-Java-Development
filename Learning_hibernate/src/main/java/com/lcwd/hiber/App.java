package com.lcwd.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.lcwd.hiber.entities.Certificates;
import com.lcwd.hiber.entities.Student;
import com.lcwd.hiber.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        // Create a new student obect
        
        Student student = new Student();
        student.setName("rajan");
        student.setCollege("JSS");
        student.setActive(true);
        student.setAbout("software engineer trainee");
        student.setPhone("2345678900");
//        student.setStudentId();
        student.setFatherName("Santosh");
        
        Certificates certificate = new Certificates();
        certificate.setTitle("java");
        certificate.setAbout("wertyui");
        certificate.setLink("link");
        certificate.setStudent(student);
        
        Certificates certificate1 = new Certificates();
        certificate1.setTitle("phython");
        certificate1.setAbout("wertyui");
        certificate1.setStudent(student);
        certificate1.setLink("link");
        
        student.getCertificates().add(certificate1);
        student.getCertificates().add(certificate);
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        System.out.println(sessionFactory);
        
        Session session = sessionFactory.openSession();
        
        Transaction transaction = null;
        try {
        	
        	transaction = session.beginTransaction();
        	session.persist(student);
        	transaction.commit();
        	System.out.println("Student data saved successfully");
			
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			
			e.printStackTrace();
		} finally {
			session.close();
		}
        }
}
