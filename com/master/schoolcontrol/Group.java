package com.master.schoolcontrol;
import java.util.ArrayList;
import java.util.Arrays;

public class Group {
  private int code;
  private ArrayList<Enrollment> enrolled = new ArrayList<Enrollment>();
  private Professor professor;
  private Subject subject;

  class Enrollment {
    Student student;
    Score scores;

    public Enrollment (Student student) {
      this.setStudent(student);
      scores = new Score(subject, student);
      this.setScore(scores);
    }

    public void showScores () {
      System.out.println("Units: " + Arrays.toString(scores.getScore('T')));
      System.out.println("Practices: " + Arrays.toString(scores.getScore('P')));
    }

    public void setStudent(Student student) {
      this.student = student;
    }

    public void setScore(Score score) {
      this.scores = scores;
    }
  }

  public Group(int code, Professor professor, Subject subject) {
    this.setCode(code);
    this.setProfessor(professor);
    this.setSubject(subject);
  }

  public int getCode() {
    return code;
  }
  
  public void setCode(int code) {
    this.code = code;
  }

  public Professor getProfessor() {
    return professor;
  }

  public void setProfessor(Professor professor) {
    this.professor = professor;
  }
  
  public Subject getSubject() {
    return subject;
  }

  public void setSubject(Subject subject) {
    this.subject = subject;
  }

  public Enrollment enroll (Student student) {
    Enrollment enroll = new Enrollment(student);
    enrolled.add(enroll);
    return enroll;
  }

  public ArrayList<Enrollment> getEnrolled() {
    return enrolled;
  }
}