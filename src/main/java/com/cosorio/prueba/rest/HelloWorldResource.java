package com.cosorio.prueba.rest;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.cosorio.prueba.servlets.Message;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
     * @throws JsonProcessingException 
     */
    @GET
    @Produces("application/json")
    public String getGreeting() throws JsonProcessingException {
    	ObjectMapper mapper = new ObjectMapper();
    	Message me=new Message(nameStorage.getName());
		
    	
    	String jsonInString = mapper.writeValueAsString(me);
		System.out.println(jsonInString);
    	
		return jsonInString;
    	//return "{\"mensaje\": "+nameStorage.getName().toString()+"}";
    	
    	//return "{\"mensaje\": \"hola\"}";
    	
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
