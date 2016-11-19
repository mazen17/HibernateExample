package com.journaldev.hibernate.main;

import com.journaldev.hibernate.model.Employee1;
import com.journaldev.hibernate.model.TimeCard;
import com.journaldev.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateJavaConfigMain {

  public static void main(String[] args) {
    Employee1 emp = new Employee1();
    emp.setName("Lisa");
    emp.setRole("Manager");

    TimeCard tc = new TimeCard();
    tc.setName("test");

    emp.getTimeCards().add(tc);

    //Get Session
    SessionFactory sessionFactory = HibernateUtil.getSessionJavaConfigFactory();
    Session session = sessionFactory.getCurrentSession();
    //start transaction
    session.beginTransaction();
    //Save the Model object
    session.save(emp);
    //Commit transaction
    session.getTransaction().commit();
    System.out.println("Employee ID=" + emp.getId());

    //terminate session factory, otherwise program won't end
    sessionFactory.close();
  }

}
