package org.princess.princessservice.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlExecutor {
  // 创建一个数据库连接
  private Connection con = null;
  // 创建预编译语句对象，一般都是用这个而不用Statement
  private PreparedStatement pre = null;

  public void initialization() {
    try {
      Class.forName("com.mysql.jdbc.Driver");// 加载Mysql驱动程序
      System.out.println("开始尝试连接数据库！");
      String url = "jdbc:mysql://localhost:3306/schoole?serverTimezone=UTC";// localhost:3306是本机地址，schoole数据库名serverTimezone=UTC统一标准时域
      String user = "root";// 用户名,系统默认的账户名
      String password = "Test_12345";// 你安装时选设置的密码
      con = DriverManager.getConnection(url, user, password);// 获取连接
      System.out.println("连接成功！");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void destroy() {
    try {
      // 逐一将上面的几个对象关闭，因为不关闭的话会影响性能、并且占用资源
      // 注意关闭的顺序，最后使用的最先关闭
      if (pre != null)
        pre.close();
      if (con != null)
        con.close();
      System.out.println("数据库连接已关闭！");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public ResultSet exeQuery(String sql) throws SQLException {
    pre = con.prepareStatement(sql);// 实例化预编译语句
    ResultSet result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
    return result;
  }

  public int exeUpdate(String sql) throws SQLException {
    pre = con.prepareStatement(sql);// 实例化预编译语句
    int result = pre.executeUpdate();// 执行查询，注意括号中不需要再加参数
    return result;
  }

}
