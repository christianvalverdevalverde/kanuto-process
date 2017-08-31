package ec.nubesoft.kiosko.servicio;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import ec.nubesoft.kiosko.util.Configuracion;

import java.util.Map;

/**
 * Movimiento service class
 * @author carper
 * 2017-08-28, 31
 */
public class MovimientoService{
	
	public String doPost(){
		String valor = null;

		Client client = Client.create();
		WebResource webResource = client.resource( Configuracion.obtenerUrlStandard(Configuracion.getPathpostMovimientos()) );

		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

		if (response.getStatus() != 200) 
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		else
			valor = response.getEntity(String.class);

		return valor;	
	}

}


