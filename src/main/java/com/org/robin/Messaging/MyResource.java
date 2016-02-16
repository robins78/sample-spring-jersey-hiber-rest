package com.org.robin.Messaging;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.org.robin.dto.Address;
import com.org.robin.interfaces.MyInterfaces;

/**
 * Root resource (exposed at "myresource" path)
 */
@Component
@Path("/myresource")
public class MyResource
{
	
   @Autowired
   private MyInterfaces addr ;
	
	/**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIt() {
    	Response response = Response.ok().entity(addr.getData()).status(200).build(); 
    	 return  response;
    }
    
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postStrMsg( String msg) {
    	Gson gson = new Gson();
    	Address obj = gson.fromJson(msg , Address.class);
    	String outPut = addr.addAddress(obj);
        return Response.status(200).entity(outPut).build();
    }
    
    @POST
    @Path("/persist")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response persistAddress(String inputData)
    {
    	Gson gson = new Gson();
    	Address obj = gson.fromJson(inputData , Address.class);
    	String outPut = addr.saveData(obj);
        return Response.status(200).entity(outPut).build();
    }
}
