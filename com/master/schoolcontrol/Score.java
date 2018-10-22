package com.master.schoolcontrol;

public final class Score {
  private float practices[];
  private float tests[];
  private Student student;
  private Subject subject;
  private int numberOfUnits, numberOfPractices;

  public Score(Subject subject, Student student) {
    this.setStudent(student);
    this.setSubject(subject);
    numberOfPractices = subject.getNumberOfPractices();
    numberOfUnits = subject.getNumberOfUnits();
    this.setPractices(numberOfPractices);
    this.setUnits(numberOfUnits);
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  public void setSubject(Subject subject) {
    this.subject = subject;
  }

  public float[] getScore(char type) {
    if (type == 'P') {
      return practices;
    } else {
      return tests;
    }
  }

  public void setScore(char type, int unitNumber, float score) {
    if (type == 'P') {
      practices[unitNumber] = score;
    } else {
      tests[unitNumber] = score;
    }
  }

  public void setPractices(int numberOfPractices) {
    this.practices = new float[numberOfPractices];
  }

  public void setUnits(int numberOfUnits) {
    this.tests = new float[numberOfUnits];
  }

  public int getNumberOfPractices() {
    return numberOfPractices;
  }

  public int getNumberOfUnits() {
    return numberOfUnits;
  }
}