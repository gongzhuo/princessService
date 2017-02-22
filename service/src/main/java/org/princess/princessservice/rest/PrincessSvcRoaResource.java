/*
 * Copyright 2016 Huawei Technologies Co., Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package org.princess.princessservice.rest;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.princess.princessservice.dao.AccessDbRawWay;
import org.princess.princessservice.model.Student;
import org.princess.princessservice.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Path("/school/v1/student")
public class PrincessSvcRoaResource {

  private static final Logger LOGGER = LoggerFactory.getLogger(PrincessSvcRoaResource.class);

  @GET
  @Path("/batchQuery")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public String queryAll(@Context HttpServletRequest req, @Context HttpServletResponse resp,
      @PathParam("studentid") String studentid) throws SQLException {
    List<Student> result = new AccessDbRawWay().getAll();
    return JsonUtil.toJson(result);
  }

  @GET
  @Path("/{studentid}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public String query(@Context HttpServletRequest req, @Context HttpServletResponse resp,
      @PathParam("studentid") String name) throws SQLException {
    LOGGER.info("query student, name = " + name);
    List<Student> result = new AccessDbRawWay().getStudentByName(name);
    return JsonUtil.toJson(result);

  }

  @DELETE
  @Path("/{studentid}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public String delete(@Context HttpServletRequest req, @Context HttpServletResponse resp,
      @PathParam("studentid") String studentid) throws SQLException {
    LOGGER.info("delete student, id = " + studentid);
    Student result = new AccessDbRawWay().deleteStudentById(studentid);
    return JsonUtil.toJson(result);

  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public String create(Student student) throws SQLException {
    LOGGER.info("create students: " + JsonUtil.toJson(student));
    Student result = new AccessDbRawWay().createStudent(student);
    return JsonUtil.toJson(result);
  }

  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public String update(Student student) throws SQLException {
    LOGGER.info("update students: " + JsonUtil.toJson(student));
    Student result = new AccessDbRawWay().updateStudentById(student);
    return JsonUtil.toJson(result);
  }
}
