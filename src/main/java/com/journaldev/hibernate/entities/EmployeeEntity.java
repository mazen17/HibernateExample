package com.journaldev.hibernate.entities;

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
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Employee", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID" }) })
@Inheritance(strategy = InheritanceType.JOINED)
public class EmployeeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", nullable = false, unique = true, length = 5)
  private Integer id;

  @Column(name = "NAME", nullable = false)
  private String name;

  @Column(name = "ADDRESS", nullable = false)
  private String address;

  @Column(name = "TYPE", nullable = false)
  private String type;

  @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  Set<TimeCardEntity> timecards;

  public void setTimecards(Set<TimeCardEntity> timecards) {
    this.timecards = timecards;
  }

  public Set<TimeCardEntity> getTimecards() {
    return timecards;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((address == null) ? 0 : address.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((type == null) ? 0 : type.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    EmployeeEntity other = (EmployeeEntity) obj;
    if (address == null) {
      if (other.address != null) return false;
    }
    else if (!address.equals(other.address)) return false;
    if (id == null) {
      if (other.id != null) return false;
    }
    else if (!id.equals(other.id)) return false;
    if (name == null) {
      if (other.name != null) return false;
    }
    else if (!name.equals(other.name)) return false;
    if (type == null) {
      if (other.type != null) return false;
    }
    else if (!type.equals(other.type)) return false;
    return true;
  }

}
