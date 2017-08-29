package ec.nubesoft.kiosko.servicio;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import ec.nubesoft.kiosko.util.Utileria;

import java.util.Map;

/**
 * Movimiento service class
 * @author carper
 * 2017-08-28
 */
public class Movimiento{
	
	public String doPost(){
		String valor = null;

		Client client = Client.create();

		Map config = Utileria.getInstancia().getConfigMap();
		if (config.size() > 0) {
			String url = (String) config.get("MOVIMIENTOS_URL");

			WebResource webResource = client.resource( url );

			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

			if (response.getStatus() != 200) 
				valor = "Mensaje HTTP de error: " + response.getStatus();
			else
				valor = response.getEntity(String.class);
		}

		return valor;	
	}

}


