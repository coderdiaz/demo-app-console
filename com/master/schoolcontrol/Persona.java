package com.master.schoolcontrol;

public class Persona {
  private int registrationNumber;
  private String name;
  private String dni;

  public Persona(int registrationNumber, String name, String dni) {
    this.setRegistrationNumber(registrationNumber);
    this.setName(name);
    this.setDni(dni);
  }

  public int getRegistrationNumber() {
    return registrationNumber;
  }

  public void setRegistrationNumber(int registrationNumber) {
    this.registrationNumber = registrationNumber;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDin() {
    return dni;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }
}