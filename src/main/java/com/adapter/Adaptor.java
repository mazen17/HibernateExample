package com.adapter;

import java.util.HashMap;
import java.util.Map;

public class Adaptor {

  Map<String, Object> map = new HashMap<String, Object>();
  private EE ee;
  private Emp emp;

  public static void main(String[] args) {
    Adaptor ad = new Adaptor();
    ad.map.put("test", "test");
    EE ee = new EE();
    Emp emp = new Emp();
    emp.setName((String) ad.map.get("test"));
    ad.map.put("test", "bal");
    emp.setName("bab");

    ad.setEe(ee);
    ad.setEmp(emp);
    ad.synchEE();
    System.out.println(ee.getName());
    emp.setName("baba");
    System.out.println(ee.getName());

  }

  public void setEe(EE ee) {
    this.ee = ee;
  }

  public void setEmp(Emp emp) {
    this.emp = emp;
  }

  void setName(String name) {
    ee.setName(name);
  }

  void synchEE() {
    ee.setName(emp.getName());
  }

  void synchEmp() {
  }
}
