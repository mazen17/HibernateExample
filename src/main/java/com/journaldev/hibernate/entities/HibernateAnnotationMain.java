package com.journaldev.hibernate.entities;

import com.journaldev.hibernate.util.HibernateUtil;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateAnnotationMain {

  public static void main(String[] args) {

    EmployeeEntity emp = new EmployeeEntity();
    emp.setName("David2");
    emp.setAddress("ae");
    emp.setType("tes");

    TimeCardEntity tc = new TimeCardEntity();
    Set<TimeCardEntity> timecards = new HashSet<TimeCardEntity>();
    tc.setDate(new Date());
    tc.setHours(BigDecimal.ONE);
    tc.setEmployee(emp);
    timecards.add(tc);
    emp.setTimecards(timecards);

    //Get Session
    SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
    Session session = sessionFactory.getCurrentSession();

    session.beginTransaction();

    session.save(emp);
    session.getTransaction().commit();
    System.out.println("Employee ID=" + emp.getId());

    //terminate session factory, otherwise program won't end
    sessionFactory.close();
  }

}
