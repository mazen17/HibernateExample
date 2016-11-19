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
@Table(name = "Employee2", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID" }) })
public class Employee2 {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", nullable = false, unique = true, length = 5)
  private int id;

  @Column(name = "NAME", length = 10, nullable = true)
  private String name;

  @Column(name = "ROLE", length = 10, nullable = false)
  private String role;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "ID")
  TimeCard timecard;

  public void setTimecard(TimeCard timecard) {
    this.timecard = timecard;
  }

  public TimeCard getTimecard() {
    return timecard;
  }

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

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

}
