package com.java.ws.rest.service;

import javax.swing.JOptionPane;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import com.java.ws.rest.vo.VOTwoStrings;

public class RestClientTwoStrings {

	public static void main(String[] args) {
		
		VOTwoStrings obj = new VOTwoStrings();
		obj.setStr1(JOptionPane.showInputDialog("Please Insert a string"));
		obj.setStr2(JOptionPane.showInputDialog("Please Insert another string"));
				
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource("http://localhost:8080/TwoStringsWebProject/services/ServiceTwoStrings/twoStrings");
		ClientResponse response = webResource.type("application/json").post(ClientResponse.class, obj);
		VOTwoStrings respuesta = response.getEntity(VOTwoStrings.class);
		
		JOptionPane.showMessageDialog(null,"letrasEnComun: "+respuesta.getLetrasEnComun());
	}

}
