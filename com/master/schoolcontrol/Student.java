package com.master.schoolcontrol;

public class Student extends Persona {
  // Mode: 1 - Online; 2 - In site;
  private int mode;
  
  public Student(int registrationNumber, String name, String dni) {
    super(registrationNumber, name, dni);
  }
  
  public Student(int registrationNumber, String name, int mode) {
    super(registrationNumber, name, "");
    this.setMode(mode);
    System.out.println("Registrered: #" + registrationNumber + "; Name: " + name + "; Mode: #" + mode);
  }

  public int getMode() {
    return mode;
  }

  public void setMode(int mode) {
    this.mode = mode;
  }
}