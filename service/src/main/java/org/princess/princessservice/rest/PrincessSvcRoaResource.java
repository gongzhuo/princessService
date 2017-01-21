/*
 * Copyright 2016 Huawei Technologies Co., Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.princess.princessservice.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Path("/query")
public class PrincessSvcRoaResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(PrincessSvcRoaResource.class);

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void create(@Context HttpServletRequest req, @Context HttpServletResponse resp) {

		long infterEnterTime = System.currentTimeMillis();

	}

	@GET
	@Path("/{studentid}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String query(@Context HttpServletRequest req, @Context HttpServletResponse resp,
			@PathParam("studentid") String studentid) {
		LOGGER.info("query student, id = " + studentid);
		if (studentid.contentEquals("1234")) {
			return "gongzhuo shi ge da ben dan.";
		} else {
			LOGGER.info("query student not found, id = " + studentid);
			return "no such person";
		}
	}

}
