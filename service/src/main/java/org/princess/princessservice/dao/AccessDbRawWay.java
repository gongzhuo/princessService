package org.princess.princessservice.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.princess.princessservice.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccessDbRawWay {

  SqlExecutor executor = new SqlExecutor();

  private static final Logger LOGGER = LoggerFactory.getLogger(AccessDbRawWay.class);

  public List<Student> getAll() throws SQLException {
    List<Student> students = new ArrayList<Student>();
    String sql = "select * from student ";// 预编译语句，“？”代表参数
    executor.initialization();
    ResultSet result = executor.exeQuery(sql);


    while (result.next()) {
      // 当结果集不为空时
      LOGGER.info("id:" + result.getString("id") + "name:" + result.getString("name") + "weight："
          + result.getString("weight") + "height" + result.getString("height") + "gender"
          + result.getString("gender"));
      Student student = new Student();
      student.setGender(result.getString("gender"));
      student.setHeight(result.getString("height"));
      student.setId(result.getString("id"));
      student.setName(result.getString("name"));
      student.setWeight(result.getString("weight"));
      students.add(student);
    }
    executor.destroy();
    return students;

  }

  public List<Student> getStudentByName(String name) throws SQLException {
    List<Student> students = new ArrayList<Student>();
    String sql = "select * from student where name='" + name + "'";// 预编译语句，“？”代表参数
    executor.initialization();
    ResultSet result = executor.exeQuery(sql);


    while (result.next()) {
      // 当结果集不为空时
      LOGGER.info("id:" + result.getString("id") + "name:" + result.getString("name") + "weight："
          + result.getString("weight") + "height" + result.getString("height") + "gender"
          + result.getString("gender"));
      Student student = new Student();
      student.setGender(result.getString("gender"));
      student.setHeight(result.getString("height"));
      student.setId(result.getString("id"));
      student.setName(result.getString("name"));
      student.setWeight(result.getString("weight"));
      students.add(student);
    }
    executor.destroy();
    return students;
  }

  public Student getStudentById(String id) throws SQLException {
    String sql = "select * from student where id='" + id + "'";// 预编译语句，“？”代表参数
    executor.initialization();
    ResultSet result = executor.exeQuery(sql);
    Student student = new Student();

    while (result.next()) {
      // 当结果集不为空时
      LOGGER.info("id:" + result.getString("id") + "name:" + result.getString("name") + "weight："
          + result.getString("weight") + "height" + result.getString("height") + "gender"
          + result.getString("gender"));
      student.setGender(result.getString("gender"));
      student.setHeight(result.getString("height"));
      student.setId(result.getString("id"));
      student.setName(result.getString("name"));
      student.setWeight(result.getString("weight"));
    }
    executor.destroy();
    return student;
  }

  public Student createStudent(Student student) throws SQLException {
    student.setId(UuidUtil.allocateUuid());
    insertStudent(student);
    return student;
  }

  private void insertStudent(Student student) throws SQLException {
    student.setId(UuidUtil.allocateUuid());
    String sql = "insert into student(id,name,weight,height,gender) value('" + student.getId()
        + "','" + student.getName() + "','" + student.getWeight() + "','" + student.getHeight()
        + "','" + student.getGender() + "')";// 预编译语句，“？”代表参数
    System.out.println(sql);
    executor.initialization();
    executor.exeUpdate(sql);
    executor.destroy();

  }

  public Student deleteStudentById(String studentid) throws SQLException {
    Student result = getStudentById(studentid);
    String sql = "delete from student where id='" + studentid + "'";// 预编译语句，“？”代表参数
    LOGGER.info("delete student:" + sql);
    System.out.println(sql);
    executor.initialization();
    executor.exeUpdate(sql);
    executor.destroy();
    return result;
  }

  public Student updateStudentById(Student student) throws SQLException {
    Student result = getStudentById(student.getId());
    String sql = "update student set name = '" + student.getName() + "', height = "
        + student.getHeight() + ", weight = " + student.getWeight() + ", gender = '"
        + student.getGender() + "' where id = " + student.getId();
    LOGGER.info("update student:" + sql);
    System.out.println(sql);
    executor.initialization();
    executor.exeUpdate(sql);
    executor.destroy();
    return student;
  }

}
