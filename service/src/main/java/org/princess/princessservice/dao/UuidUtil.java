package org.princess.princessservice.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UuidUtil {
  public static String allocateUuid() {
    // UUID uuid = UUID.randomUUID();
    // System.out.println(uuid);

    // 得到long类型当前时间
    long l = System.currentTimeMillis();
    // new日期对象
    Date date = new Date(l);
    // 转换提日期输出格式
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    System.out.println(dateFormat.format(date));

    String id = dateFormat.format(date);
    System.out.println(id);
    return id;
  }
}
