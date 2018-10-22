package com.master.schoolcontrol;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
  Scanner scanner;
  private ArrayList<Professor> professors = new ArrayList<Professor>();
  private ArrayList<Student> students = new ArrayList<Student>();
  private ArrayList<Subject> subjects = new ArrayList<Subject>();
  private ArrayList<Group> groups = new ArrayList<Group>();

  public static void main(String[] args) {
    new Main().showMenu();
  }

  public void showMenu() {
    System.out.println("================ School Control ================");
    System.out.println("== 1. Add new professor                       ==");
    System.out.println("== 2. Add new student                         ==");
    System.out.println("== 5. Add new subject                         ==");
    System.out.println("== 3. Show students registered                ==");
    System.out.println("== 4. Show professors registered              ==");
    System.out.println("== 6. Show subjects registered                ==");
    System.out.println("== 7. Add group                               ==");
    System.out.println("== 8. Show groups                             ==");
    System.out.println("== 9. Assign students to groups               ==");
    System.out.println("== 10. Getting started with initial data      ==");
    System.out.println("================================================");
    System.out.print("Select a option: ");
    scanner = new Scanner(System.in);
    int option = scanner.nextInt();
    selectOption(option);
  }

  public void selectOption(int option) {
    switch(option) {
      case 1:
        addProfessor();
        break;
      case 2:
        addStudent();
        break;
      case 3:
        showStudents();
        break;
      case 4:
        showProffessors();
        break;
      case 5:
        addSubject();
        break;
      case 6:
        showSubjects();
        break;
      case 7:
        addGroup();
        break;
      case 8:
        showGroups();
        break;
      case 9:
        assignStudentsToGroups();
        break;
      case 10:
        loadInitialData();
      default:
        showMenu();
        break;
    }
  }

  public void addProfessor() {
    System.out.println("Add new professor: ");
    System.out.print("Name: ");
    scanner = new Scanner(System.in);
    String name = scanner.nextLine();
    System.out.print("Registry number: ");
    scanner = new Scanner(System.in);
    int registerNumber = scanner.nextInt();
    System.out.print("DNI: ");
    scanner = new Scanner(System.in);
    String dni = scanner.nextLine();;
    professors.add(new Professor(registerNumber, name, dni));
    System.out.println(professors);
    showMenu();
  }

  public void addStudent() {
    System.out.println("Add new student: ");
    System.out.print("Name: ");
    scanner = new Scanner(System.in);
    String name = scanner.nextLine();
    System.out.print("Registry number: ");
    scanner = new Scanner(System.in);
    int registerNumber = scanner.nextInt();
    System.out.print("Mode (1: Online; 2: In site): ");
    scanner = new Scanner(System.in);
    int mode = scanner.nextInt();
    students.add(new Student(registerNumber, name, mode));
    System.out.println(students);
    showMenu();
  }

  public void addSubject() {
    System.out.println("Add new subject: ");
    System.out.print("Name: ");
    scanner = new Scanner(System.in);
    String name = scanner.nextLine();
    System.out.print("Code: ");
    scanner = new Scanner(System.in);
    int code = scanner.nextInt();
    System.out.print("Number of units: ");
    scanner = new Scanner(System.in);
    int numberOfUnits = scanner.nextInt();
    System.out.print("Number of practices by unit: ");
    scanner = new Scanner(System.in);
    int numberOfPractices = scanner.nextInt();
    subjects.add(new Subject(code, name, numberOfUnits, numberOfPractices));
    showMenu();
  }

  public void showProffessors() {
    int professorsSize = professors.size();
    System.out.println(professors);
    if (professorsSize == 0) {
      System.out.println("Not professors available");
    }
    for (int i = 0; i < professorsSize; i++) {
      System.out.println(professors.get(i).getName());
    }
    showMenu();
  }

  public void showStudents() {
    int studentsSize = students.size();
    System.out.println(students);
    if (studentsSize == 0) {
      System.out.println("Not students available");
    }
    for (int i = 0; i < studentsSize; i++) {
      System.out.println(students.get(i).getName());
    }
    showMenu();
  }

  public void showSubjects() {
    int subjectsSize = subjects.size();
    System.out.println(subjects);
    if (subjectsSize == 0) {
      System.out.println("Not subjects available");
    }
    for (int i = 0; i < subjectsSize; i++) {
      System.out.println(subjects.get(i).getName());
    }
    showMenu();
  }

  public void addGroup() {
    System.out.println("Code: ");
    scanner = new Scanner(System.in);
    int code = scanner.nextInt();
    System.out.println("Professors Availables: ");
    for (int i = 0; i < professors.size(); i++) {
      System.out.println((i+1) + ". " + professors.get(i).getName());
    }
    System.out.println("Select a professor: ");
    scanner = new Scanner(System.in);
    int selectedProfesor = scanner.nextInt();
    // TODO: Validate if type zero
    Professor professor = professors.get(selectedProfesor - 1);
    System.out.println("Subject Availables: ");
    for (int i = 0; i < subjects.size(); i++) {
      System.out.println((i+1) + ". " + subjects.get(i).getName());
    }
    System.out.println("Select a subject: ");
    scanner = new Scanner(System.in);
    int selectedSubject = scanner.nextInt();
    // TODO: Validate if type zero
    Subject subject = subjects.get(selectedSubject - 1);
    groups.add(new Group(code, professor, subject));
    showMenu();
  }

  public void showGroups() {
    for (int i = 0; i < groups.size(); i++) {
      System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
      System.out.println("Code: " + groups.get(i).getCode());
      System.out.println("Professor: " + groups.get(i).getProfessor().getName());
      System.out.println("Subject: " + groups.get(i).getSubject().getName());
      System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
      ArrayList<Group.Enrollment> enrolled = groups.get(i).getEnrolled();
      for (int j = 0; j < enrolled.size(); j++) {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Name: " + enrolled.get(j).student.getName());
        enrolled.get(j).showScores();
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
      }
      System.out.println("");
    }
    showMenu();
  }

  public void assignStudentsToGroups() {
    int numberOfGroups = 3 + (int) (Math.random() * 5);
    int numberOfStudents = students.size();
    int numberOfSubjects = subjects.size();
    int numberOfProfessors = professors.size();

    for (int i = 0; i < numberOfGroups; i++) {
      Professor professor = professors.get((int) (Math.random() * numberOfProfessors));
      Subject subject = subjects.get(i);
      Group group = new Group(i+1, professor, subject);
      groups.add(group);
      for (int j = 0; j <= 5; j++) {
        Student student = students.get((int) (Math.random() * numberOfStudents));
        Group.Enrollment enrollment = group.enroll(student);
        for (int unit = 0; unit < enrollment.scores.getNumberOfUnits(); unit++) {
          enrollment.scores.setScore('T', unit, 50 + (float)(Math.random() * 50));
        }
        for (int practice = 0; practice < enrollment.scores.getNumberOfPractices(); practice++) {
          enrollment.scores.setScore('P', practice, 50 + (float)(Math.random() * 50));
        }
      }
    }

    showGroups();
  }

  public void loadInitialData() {
    int initialProfessor = 0;
    professors.add(new Professor(initialProfessor++, "Paloma Corona", ""));
    professors.add(new Professor(initialProfessor++, "Emile Kihn", ""));
    professors.add(new Professor(initialProfessor++, "Leon Conn", ""));
    professors.add(new Professor(initialProfessor++, "Geraldine Rippin", ""));
    professors.add(new Professor(initialProfessor++, "Judson Durgan", ""));
    professors.add(new Professor(initialProfessor++, "Kaelyn Schmidt", ""));
    int initialSubject = 0;
    subjects.add(new Subject(initialSubject++, "Programación Básica", 5, 3));
    subjects.add(new Subject(initialSubject++, "Arquitectura de computadoras", 4, 10));
    subjects.add(new Subject(initialSubject++, "Programación Avanzada", 5, 5));
    subjects.add(new Subject(initialSubject++, "Autómatas y lenguajes formales", 2, 3));
    subjects.add(new Subject(initialSubject++, "Base de datos II", 5, 3));
    subjects.add(new Subject(initialSubject++, "Ingenieria de Software", 7, 3));
    subjects.add(new Subject(initialSubject++, "Redes I", 5, 3));
    int initialStudent = 0;
    students.add(new Student(initialStudent++, "Brice Lowe", 1));
    students.add(new Student(initialStudent++, "Emile Kihn", 1));
    students.add(new Student(initialStudent++, "Meghan Parisian", 1));
    students.add(new Student(initialStudent++, "Brendon Green", 1));
    students.add(new Student(initialStudent++, "Esther Cormie", 1));
    students.add(new Student(initialStudent++, "Berniece Becker", 1));

  }
}