package com.cosorio.prueba.rest;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;

/**
 * REST Web Service
 *
 * @author cosorio
 */

@Stateless
@Path("/greeting")
public class HelloWorldResource {

    @EJB
    private NameStorageBean nameStorage;
    /**
     * Retrieves representation of an instance of helloworld.HelloWorldResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getGreeting() {
    	return "{'mensaje': "+nameStorage.getName()+"}";
//        return "<html><body><h1>Hello "+nameStorage.getName()+"!</h1></body></html>";
    }

    /**
     * PUT method for updating an instance of HelloWorldResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/plain")
    public void setName(String content) {
        nameStorage.setName(content);
    }
    
    @POST
    @Consumes("text/plain")
    public void insertaNombre(String content) {
        nameStorage.setName(content+"desde post");
    }
    
    
}
