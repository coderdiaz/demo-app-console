package com.master.schoolcontrol;

public class Subject {
  private int code;
  private String name;
  private int numberOfUnits;
  private int numberOfPractices;

  public Subject(int code, String name, int numberOfUnits, int numberOfPractices) {
    this.setCode(code);
    this.setName(name);
    this.setNumberOfUnits(numberOfUnits);
    this.setNumberOfPractices(numberOfPractices);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public int getNumberOfUnits() {
    return numberOfUnits;
  }

  public void setNumberOfUnits(int numberOfUnits) {
    this.numberOfUnits = numberOfUnits;
  }

  public int getNumberOfPractices() {
    return numberOfPractices;
  }

  public void setNumberOfPractices(int numberOfPractices) {
    this.numberOfPractices = numberOfPractices;
  }
}