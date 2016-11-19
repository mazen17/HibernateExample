package com.journaldev.hibernate.main;

import com.journaldev.hibernate.model.Employee1;
import com.journaldev.hibernate.model.Employee3;
import com.journaldev.hibernate.model.TimeCard;
import com.journaldev.hibernate.model.TimeCard3;
import com.journaldev.hibernate.util.HibernateUtil;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateAnnotationMain {

  public static void main(String[] args) {

    Employee1 emp1 = new Employee1();
    emp1.setName("David2");
    emp1.setRole("Developer2");
    emp1.setInsterTime(new Date());
    TimeCard tc = new TimeCard();
    Set<TimeCard> timecards = new HashSet<TimeCard>();
    //tc.setName("test1");
    //tc.setEmployee(emp1);
    timecards.add(tc);
    emp1.setTimeCards(timecards);

    //Get Session
    SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
    Session session = sessionFactory.getCurrentSession();

    Employee3 emp = new Employee3();
    //start transaction

    session.beginTransaction();

    emp.setName("reta");
    emp.setRole("sex");
    TimeCard3 tc3 = new TimeCard3();
    tc3.setName("fuck");
    tc3.setEmployee(emp);
    TimeCard3 tc4 = new TimeCard3();
    tc4.setName("fuck2");
    tc4.setEmployee(emp);

    Set<TimeCard3> tcs = new HashSet<TimeCard3>();
    tcs.add(tc3);
    tcs.add(tc4);
    emp.setTimecard3(tcs);

    // tc3.setEmployee(emp);
    //tc2.setEmployee(emp);
    session.save(emp);
    //List<Employee1> list = session.createCriteria(Employee1.class).list();
    //Query query = session.createQuery("from Employee1");
    //List list2 = query.list();
    //Employee1 object = (Employee1) list2.get(0);
    //object.setName("bomba");
    //  TimeCard tc2 = new TimeCard();
    // tc2.setName("alala");
    // tc2.setEmployee(object);
    //object.getTimeCards().add(tc2);

    //Save the Model object
    // session.save(emp1);
    //session.save(object);
    // session.save(tc);
    //Commit transaction
    session.getTransaction().commit();
    System.out.println("Employee ID=" + emp1.getId());

    //terminate session factory, otherwise program won't end
    sessionFactory.close();
  }

}
