package alom.client;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import alom.server.payload.*;


public class ResourceClient {

	public static void main(String[] args) {
		// Create Jersey client
		com.sun.jersey.api.client.config.ClientConfig clientConfig = new com.sun.jersey.api.client.config.DefaultClientConfig();
		clientConfig.getFeatures().put(com.sun.jersey.api.json.JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);

		String target = "http://localhost:8080/jersey-helloworld-server/rest/resource";

		// add a new student
		addNewStudent(client, String.format("%s/add-student", target));

		// get a student
		getStudent(client, String.format("%s/get-student", target));

		// update a student
		updateStudent(client, String.format("%s/update-student", target));
		
		// delete a student
		deleteStudent(client, String.format("%s/delete-student", target));

		// add a new subject
		addNewSubject(client, String.format("%s/add-subject", target));

		// get a subject
		getSubject(client, String.format("%s/get-subject", target));

		// update a subject
		updateSubject(client, String.format("%s/update-subject", target));
		
		// delete a subject
		deleteSubject(client, String.format("%s/delete-subject", target));

		// add a new group
		addNewGroup(client, String.format("%s/add-group", target));

		// get a group
		getGroup(client, String.format("%s/get-group", target));

		// update a group
		updateGroup(client, String.format("%s/update-group", target));
		
		// delete a group
		deleteGroup(client, String.format("%s/delete-group", target));

		// add a student to a group
		addStudentToTheGroup(client, String.format("%s/add-student-group", target));

		// remove a student to a group
		removeStudentFromTheGroup(client, String.format("%s/remove-student-group", target));

		// joint a group with subjects
		jointGroupWithSubjects(client, String.format("%s/add-group-subjects", target));

		// remove join between a group and subject
		disjointGroupFromSubjects(client, String.format("%s/remove-group-subjects", target));

		// Give note
		giveNoteInASubjectToAStudent(client, String.format("%s/add-student-subject-note", target));

		// Update note
		modifyNoteInASubjectToAStudent(client, String.format("%s/update-student-subject-note", target));

		// Delete note
		deleteNoteInASubjectOfAStudent(client, String.format("%s/delete-student-subject-note", target));

		// Show results
		showResults(client, String.format("%s/show-results", target));
	}

	/**
	 * Add new student
	 * @param Client
	 */
	static void addNewStudent(Client client, String path) {
		System.out.println("addNewStudent");
		WebResource webResource = client.resource(path);
		Student input = new Student(1, "Adam", "Smith");
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, input);
		Student output = response.getEntity(Student.class);
		System.out.println("Output from Server .... \n");
		Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
		System.out.println(gson.toJson(output));
	}

	/**
	 * Get a student
	 * @param client
	 */
	static void getStudent(Client client, String path) {
		System.out.println("getStudent");
		int id = 1;
		WebResource webResource = client.resource(path).queryParam("id", String.valueOf(id));
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		Student output = response.getEntity(Student.class);
		System.out.println("Output from Server .... \n");
		Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
		System.out.println(gson.toJson(output));
	}
	
	/**
	 * Update a student
	 * @param client
	 */
	static void updateStudent(Client client, String path) {
		System.out.println("updateStudent");
		WebResource webResource = client.resource(path);
		Student input = new Student(1, "Adam", "Levine");
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).put(ClientResponse.class, input);
		Student output = response.getEntity(Student.class);
		System.out.println("Output from Server .... \n");
		Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
		System.out.println(gson.toJson(output));
	}
		
	/**
	 * Delete a student
	 * @param client
	 */
	static void deleteStudent(Client client, String path) {
		System.out.println("deleteStudent");
		WebResource webResource = client.resource(path);
		Student input = new Student(1, "Adam", "Levine");
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).delete(ClientResponse.class, input);
		Student output = response.getEntity(Student.class);
		System.out.println("Output from Server .... \n");
		Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
		System.out.println(gson.toJson(output));
	}

	/**
	 * Add new subject
	 * @param Client
	 */
	static void addNewSubject(Client client, String path) {
		System.out.println("addNewSubject");
		WebResource webResource = client.resource(path);
		Subject input = new Subject(1, "History");
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, input);
		Subject output = response.getEntity(Subject.class);
		System.out.println("Output from Server .... \n");
		Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
		System.out.println(gson.toJson(output));
	}

	/**
	 * Get a subject
	 * @param client
	 */
	static void getSubject(Client client, String path) {
		System.out.println("getSubject");
		int id = 1;
		WebResource webResource = client.resource(path).queryParam("id", String.valueOf(id));
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		Subject output = response.getEntity(Subject.class);
		System.out.println("Output from Server .... \n");
		Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
		System.out.println(gson.toJson(output));
	}
	
	/**
	 * Update a subject
	 * @param client
	 */
	static void updateSubject(Client client, String path) {
		System.out.println("updateSubject");
		WebResource webResource = client.resource(path);
		Subject input = new Subject(1, "Math");
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).put(ClientResponse.class, input);
		Subject output = response.getEntity(Subject.class);
		System.out.println("Output from Server .... \n");
		Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
		System.out.println(gson.toJson(output));
	}

		
	/**
	 * Delete a subject
	 * @param client
	 */
	static void deleteSubject(Client client, String path) {
		System.out.println("deleteSubject");
		WebResource webResource = client.resource(path);
		Subject input = new Subject(1, "Math");
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).delete(ClientResponse.class, input);
		Subject output = response.getEntity(Subject.class);
		System.out.println("Output from Server .... \n");
		Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
		System.out.println(gson.toJson(output));
	}

	/**
	 * Add new group
	 * @param Client
	 */
	static void addNewGroup(Client client, String path) {
		System.out.println("addNewGroup");
		WebResource webResource = client.resource(path);
		Group input = new Group(1, "Group-1");
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, input);
		Group output = response.getEntity(Group.class);
		System.out.println("Output from Server .... \n");
		Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
		System.out.println(gson.toJson(output));
	}

	/**
	 * Get a group
	 * @param client
	 */
	static void getGroup(Client client, String path) {
		System.out.println("getGroup");
		int id = 1;
		WebResource webResource = client.resource(path).queryParam("id", String.valueOf(id));
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		Group output = response.getEntity(Group.class);
		System.out.println("Output from Server .... \n");
		Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
		System.out.println(gson.toJson(output));
	}
	
	/**
	 * Update a group
	 * @param client
	 */
	static void updateGroup(Client client, String path) {
		System.out.println("updateGroup");
		WebResource webResource = client.resource(path);
		Group input = new Group(1, "Group-11");
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).put(ClientResponse.class, input);
		Group output = response.getEntity(Group.class);
		System.out.println("Output from Server .... \n");
		Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
		System.out.println(gson.toJson(output));
	}
		
	/**
	 * Delete a group
	 * @param client
	 */
	static void deleteGroup(Client client, String path) {
		System.out.println("deleteGroup");
		WebResource webResource = client.resource(path);
		Group input = new Group(1, "Group-11");
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).delete(ClientResponse.class, input);
		Group output = response.getEntity(Group.class);
		System.out.println("Output from Server .... \n");
		Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
		System.out.println(gson.toJson(output));
	}

	/**
	 * Adds a student to the group
	 * @param Client
	 */
	static void addStudentToTheGroup(Client client, String path) {
		System.out.println("addStudentToTheGroup");
		WebResource webResource = client.resource(path);
		Student student = new Student(1, "Adam", "Smith");
		Group group = new Group(1, "Group-1");
		StudentAndGroup studentAndGroup = new StudentAndGroup(student, group);
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, studentAndGroup);
		String output = response.getEntity(String.class);
		System.out.println("Output from Server .... \n");
		System.out.println(output);
	}

	/**
	 * Removes a student from the group
	 * @param Client
	 */
	static void removeStudentFromTheGroup(Client client, String path) {
		System.out.println("removeStudentFromTheGroup");
		WebResource webResource = client.resource(path);
		Student student = new Student(1, "Adam", "Smith");
		Group group = new Group(1, "Group-1");
		StudentAndGroup studentAndGroup = new StudentAndGroup(student, group);
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, studentAndGroup);
		String output = response.getEntity(String.class);
		System.out.println("Output from Server .... \n");
		System.out.println(output);
	}

	/**
	 * Joint a group with subjects
	 * @param Client
	 */
	static void jointGroupWithSubjects(Client client, String path) {
		System.out.println("jointGroupWithSubjects");
		WebResource webResource = client.resource(path);
		Group group = new Group(1, "Group-1");
		Subject subject = new Subject(1, "History");
		Set<Subject> subjects = new HashSet<>();
		subjects.add(subject);
		GroupAndSubjects groupAndSubjects = new GroupAndSubjects(group, subjects);
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, groupAndSubjects);
		String output = response.getEntity(String.class);
		System.out.println("Output from Server .... \n");
		System.out.println(output);
	}

	/**
	 * Remove link between a group and subject
	 * @param Client
	 */
	static void disjointGroupFromSubjects(Client client, String path) {
		System.out.println("disjointGroupFromSubjects");
		WebResource webResource = client.resource(path);
		Group group = new Group(1, "Group-1");
		Subject subject = new Subject(1, "History");
		Set<Subject> subjects = new HashSet<>();
		subjects.add(subject);
		GroupAndSubjects groupAndSubjects = new GroupAndSubjects(group, subjects);
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).delete(ClientResponse.class, groupAndSubjects);
		String output = response.getEntity(String.class);
		System.out.println("Output from Server .... \n");
		System.out.println(output);
	}

	/**
	 * Give note
	 * @param Client
	 */
	static void giveNoteInASubjectToAStudent(Client client, String path) {
		System.out.println("giveNoteInASubjectToAStudent");
		WebResource webResource = client.resource(path);
		Student student = new Student(1, "Adam", "Smith");
		int mark = 100;
		Subject subject = new Subject(1, "History");
		SubjectAndNote subjectAndNote = new SubjectAndNote(subject, mark);
		Note note = new Note(student, subjectAndNote);
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, note);
		String output = response.getEntity(String.class);
		System.out.println("Output from Server .... \n");
		System.out.println(output);
	}

	/**
	 * Update note
	 * @param Client
	 */
	static void modifyNoteInASubjectToAStudent(Client client, String path) {
		System.out.println("modifyNoteInASubjectToAStudent");
		WebResource webResource = client.resource(path);
		Student student = new Student(1, "Adam", "Smith");
		int mark = 90;
		Subject subject = new Subject(1, "History");
		SubjectAndNote subjectAndNote = new SubjectAndNote(subject, mark);
		Note note = new Note(student, subjectAndNote);
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).put(ClientResponse.class, note);
		String output = response.getEntity(String.class);
		System.out.println("Output from Server .... \n");
		System.out.println(output);
	}

	/**
	 * Delete note
	 * @param Client
	 */
	static void deleteNoteInASubjectOfAStudent(Client client, String path) {
		System.out.println("deleteNoteInASubjectOfAStudent");
		WebResource webResource = client.resource(path);
		Student student = new Student(1, "Adam", "Smith");
		int mark = 90;
		Subject subject = new Subject(1, "History");
		SubjectAndNote subjectAndNote = new SubjectAndNote(subject, mark);
		Note note = new Note(student, subjectAndNote);
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).delete(ClientResponse.class, note);
		String output = response.getEntity(String.class);
		System.out.println("Output from Server .... \n");
		System.out.println(output);
	}

	
	/**
	 * Show results
	 * @param client
	 */
	static void showResults(Client client, String path) {
		System.out.println("showResults");
		WebResource webResource = client.resource(path);
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		Results output = response.getEntity(Results.class);
		System.out.println("Output from Server .... \n");
		Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
		System.out.println(gson.toJson(output));
	}
}