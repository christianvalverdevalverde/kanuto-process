package ec.nubesoft.kiosko.servicio;

import ec.nubesoft.kiosko.util.Configuracion;
import java.io.IOException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;
import java.util.logging.Logger;
import java.util.Map;

/**
 * Movimiento service class
 * @author carper
 * 2017-08-28, 31
 */
public class ConsumerService{
	
	public int doMovimientoPost(MovimientoBean payload){
		int valor = 0;

		try{
			Client client       = ClientBuilder.newClient();
			WebTarget webTarget = client.target( Configuracion.obtenerUrlStandard(Configuracion.getPathpostMovimientos()) );
			Response response   = webTarget.request(MediaType.APPLICATION_JSON).post(Entity.entity(payload,MediaType.APPLICATION_JSON));
			valor               = response.getStatus();

			if ( response.getStatus()>=200 && response.getStatus()<300 )
				Logger.getLogger(ConsumerService.class.getCanonicalName()).info("Enviado correctamente");
			else
				Logger.getLogger(ConsumerService.class.getCanonicalName()).warning("Enviado correctamente");
			
			response.close();
			client.close();						

		} catch (Exception e) {
			e.printStackTrace();
		}

		return valor;	
	}

}


