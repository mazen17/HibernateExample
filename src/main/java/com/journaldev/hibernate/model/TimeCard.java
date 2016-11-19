package com.journaldev.hibernate.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Timecard1", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID" }) })
public class TimeCard {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", nullable = false, unique = true, length = 5)
  private int id;

  @Column(name = "name", length = 20, nullable = true)
  private String name;

  // @ManyToOne(fetch = FetchType.LAZY)
  //@JoinColumn(name = "ID", nullable = false)
  @OneToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "ID")
  private Employee2 employee;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Employee2 getEmployee() {
    return employee;
  }

  public void setEmployee(Employee2 employee) {
    this.employee = employee;
  }

}
