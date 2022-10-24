package alom.client;

import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import alom.server.payload.*;


public class HelloWorldClient {

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

		// ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

	}

	/**
	 * Add new student
	 * @param Client
	 */
	static void addNewStudent(Client client, String path) {
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
		WebResource webResource = client.resource(path);
		Student input = new Student(1, "Adam", "Levine");
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, input);
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
	static void deleteStudent(Client client, String path) {
		WebResource webResource = client.resource(path);
		Student input = new Student(1, "Adam", "Levine");
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, input);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}

		Student output = response.getEntity(Student.class);
		System.out.println("Output from Server .... \n");
		Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
		System.out.println(gson.toJson(output));
	}

}