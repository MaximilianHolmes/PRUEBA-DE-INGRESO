package com.java.ws.rest.service;

import com.java.ws.rest.vo.VOMinimumSwaps;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class RestClientMinimumSwaps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		VOMinimumSwaps objSwaps = new VOMinimumSwaps();
		int[] arrayEnteros = {7,2,3,4,5,6,1};
		objSwaps.setArrayEnteros(arrayEnteros);
		
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource("http://localhost:8080/MinimumSwapsWebProject/services/ServiceMinimumSwaps/minimumSwaps");
		ClientResponse response = webResource.type("application/json").post(ClientResponse.class, objSwaps);
		VOMinimumSwaps respuesta = response.getEntity(VOMinimumSwaps.class);
		
		System.out.println("numero de intercambios: "+respuesta.getNumeroIntercambios());
		
	}

}
