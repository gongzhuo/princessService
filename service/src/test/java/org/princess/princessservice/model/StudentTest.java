package org.princess.princessservice.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.princess.princessservice.dao.AccessDbRawWay;

public class StudentTest {
  AccessDbRawWay demo = new AccessDbRawWay();

  @Test
  public void test() throws SQLException {
    demo.getStudentByName("shuaiying");
    List<Student> students = new ArrayList<Student>();
    Student student = new Student();
    student.setGender("boy");
    student.setHeight("180");
    student.setName("yuhao");
    student.setWeight("70");
    students.add(student);
    // demo.createStudent(students);
  }

}
