package com.journaldev.hibernate.model;

import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Employee1", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID" }) })
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee1 {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, unique = true, length = 10)
  private int id;

  @Column(name = "name", length = 20, nullable = true)
  private String name;

  @Column(name = "role", length = 20, nullable = true)
  private String role;

  @Column(name = "INSERT_TIME", length = 20, nullable = true)
  private Date insterTime;

  @Transient
  //@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee_id")
  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "employee")
  //@OneToMany(mappedBy = "employee")
  private Set<TimeCard> timeCards;

  public void setTimeCards(Set<TimeCard> timeCards) {
    this.timeCards = timeCards;
  }

  public Set<TimeCard> getTimeCards() {
    return timeCards;
  }

  public Date getInsterTime() {
    return insterTime;
  }

  public void setInsterTime(Date insterTime) {
    this.insterTime = insterTime;
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
