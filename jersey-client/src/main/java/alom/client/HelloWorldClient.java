package alom.client;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import alom.server.payload.*;


public class HelloWorldClient {

	final static String target = "http://localhost:8080/jersey-helloworld-server/rest/resource/";

	public static void main(String[] args) {
		Client client = Client.create();
		// add a new student
		WebResource webResource = client.resource(target + "student/add");
		// ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		Student input = new Student(1, "Adam", "Smith");
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, input);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}

		Student output = response.getEntity(Student.class);
		System.out.println("Output from Server .... \n");
	
		System.out.println(output);

	}

}