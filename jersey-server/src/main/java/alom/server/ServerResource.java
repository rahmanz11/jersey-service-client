package alom.server;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import alom.server.payload.Group;
import alom.server.payload.Student;
import alom.server.payload.Subject;
import alom.server.repository.Repository;

/** Example resource class hosted at the URI path "/resource"
 */
@Path("/resource")
public class ServerResource {
    
    /**
     * Get a student
     * @param Student
     * @return
     */
    @GET 
    @Path("/student/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudent(@QueryParam(value = "id") String id) {
        Student get = Repository.getStudent(Integer.valueOf(id));
        return Response.status(200).entity(get).build();
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

    /**
     * Updates a student
     * @param student
     * @return
     */
    @PUT
    @Path("/student/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateSudent(Student student) {
        Student updated = Repository.updateStudent(student);
        return Response.status(200).entity(updated).build();
    }
    
    /**
     * Deletes a student
     * @param student
     * @return
     */
    @DELETE
    @Path("/student/delete")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteSudent(Student student) {
        Student deleted = Repository.deleteStudent(student);
        return Response.status(200).entity(deleted).build();
    }
        
    /**
     * Get a subject
     * @param Subject
     * @return
     */
    @GET 
    @Path("/subject/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSubject(@QueryParam(value = "id") String id) {
        Subject get = Repository.getSubject(Integer.valueOf(id));
        return Response.status(200).entity(get).build();
    }
        
    /**
     * Add a new subject
     * @param Subject
     * @return
     */
    @POST 
    @Path("/subject/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addSubject(Subject subject) {
        Subject added = Repository.addSubject(subject);
        return Response.status(201).entity(added).build();
    }
    
    /**
     * Updates a subject
     * @param Subject
     * @return
     */
    @PUT
    @Path("/subject/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateSubject(Subject subject) {
        Subject updated = Repository.updateSubject(subject);
        return Response.status(200).entity(updated).build();
    }

    /**
     * Deletes a subject
     * @param subject
     * @return
     */
    @DELETE
    @Path("/subject/delete")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteSubject(Subject subject) {
        Subject deleted = Repository.deleteSubject(subject);
        return Response.status(200).entity(deleted).build();
    }

    /**
     * Get a group
     * @param Group
     * @return
     */
    @GET 
    @Path("/group/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGroup(@QueryParam(value = "id") String id) {
        Group get = Repository.getGroup(Integer.valueOf(id));
        return Response.status(200).entity(get).build();
    }
    
    /**
     * Add a new group
     * @param Group
     * @return
     */
    @POST 
    @Path("/group/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addGroup(Group group) {
        Group added = Repository.addGroup(group);
        return Response.status(201).entity(added).build();
    }
        
    /**
     * Updates a group
     * @param Group
     * @return
     */
    @PUT
    @Path("/group/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateGroup(Group group) {
        Group updated = Repository.updateGroup(group);
        return Response.status(200).entity(updated).build();
    }

    /**
     * Deletes a group
     * @param Group
     * @return
     */
    @DELETE
    @Path("/group/delete")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteGroup(Group group) {
        Group deleted = Repository.deleteGroup(group);
        return Response.status(200).entity(deleted).build();
    }
}