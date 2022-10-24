package alom.client;

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

		String target = "http://localhost:8080/jersey-helloworld-server/rest/resource/";

		// add a new student
		addNewStudent(client, String.format("%sstudent/add", target));

		// get a student
		getStudent(client, String.format("%sstudent/get", target));

		// update a student
		updateStudent(client, String.format("%sstudent/update", target));
		
		// delete a student
		deleteStudent(client, String.format("%sstudent/delete", target));

		// add a new subject
		addNewSubject(client, String.format("%ssubject/add", target));

		// get a subject
		getSubject(client, String.format("%ssubject/get", target));

		// update a subject
		updateSubject(client, String.format("%ssubject/update", target));
		
		// delete a subject
		deleteSubject(client, String.format("%ssubject/delete", target));

		// add a new subject
		addNewSubject(client, String.format("%ssubject/add", target));

		// get a subject
		getSubject(client, String.format("%ssubject/get", target));

		// update a subject
		updateSubject(client, String.format("%ssubject/update", target));
		
		// delete a subject
		deleteSubject(client, String.format("%ssubject/delete", target));

		// add a new group
		addNewGroup(client, String.format("%sgroup/add", target));

		// get a group
		getGroup(client, String.format("%sgroup/get", target));

		// update a group
		updateGroup(client, String.format("%sgroup/update", target));
		
		// delete a group
		deleteGroup(client, String.format("%sgroup/delete", target));

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
		if (response.getStatus() != 201) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}

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
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}

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
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}

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
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}

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
		if (response.getStatus() != 201) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}

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
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}

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
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}

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
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}

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
		if (response.getStatus() != 201) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}

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
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}

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
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}

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
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}

		Group output = response.getEntity(Group.class);
		System.out.println("Output from Server .... \n");
		Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
		System.out.println(gson.toJson(output));
	}
}