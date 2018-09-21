package com.jmallas.test.controller;

import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.RequestScoped;
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
@Path("/example")
public class ExampleController {
    @GET
    public Response saludo() {
        return Response.ok("Hello, I am a microservice").build();
    }
}
