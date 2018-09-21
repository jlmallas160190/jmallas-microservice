package com.jmallas.common.controller;

import com.jmallas.common.sevice.PersonService;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@RequestScoped
@Slf4j
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/persons")
public class PersonController {

    @Inject
    private PersonService personService;

    @GET
    public Response findAll() {
        return Response.ok(personService.findAll()).build();
    }

}
