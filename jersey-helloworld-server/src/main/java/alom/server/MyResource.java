package alom.server;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import alom.server.payload.Student;
import alom.server.repository.Repository;

/** Example resource class hosted at the URI path "/resource"
 */
@Path("/resource")
public class MyResource {
    
    /**
     * Get a student
     * @param Student
     * @return
     */
    @GET 
    @Path("/student/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Student getStudent(@PathParam(value = "id") int id) {
        return Repository.getStudent(id);
    }
    
    /**
     * Add a new student
     * @param Student
     * @return
     */
    @POST 
    @Path("/student/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addStudent(Student student) {
        Student added = Repository.addStudent(student);
        return Response.status(201).entity(added).build();
    }
}
