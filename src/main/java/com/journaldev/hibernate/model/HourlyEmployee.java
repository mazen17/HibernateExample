package com.journaldev.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Hourly", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID" }) })
public class HourlyEmployee extends Employee1 {

  @Column(name = "rate", length = 20, nullable = true)
  private String rate;

  public void setRate(String rate) {
    this.rate = rate;
  }

  public String getRate() {
    return rate;
  }
}
