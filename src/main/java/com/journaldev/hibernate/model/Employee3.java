package com.journaldev.hibernate.model;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Employee3")
public class Employee3 {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", nullable = false, unique = true, length = 5)
  private int id;

  @Column(name = "NAME", length = 10, nullable = true)
  private String name;

  @Column(name = "ROLE", length = 10, nullable = false)
  private String role;

  @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  Set<TimeCard3> timecard3;

  public void setTimecard3(Set<TimeCard3> timecard3) {
    this.timecard3 = timecard3;
  }

  public Set<TimeCard3> getTimecard3() {
    return timecard3;
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
