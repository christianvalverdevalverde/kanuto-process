package ec.nubesoft.touch.procesos;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ec.nubesoft.kiosko.alarmas.AlarmaInsuficiencia;

@Stateless
@Path("procesos")
public class ProcessHelper implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5205547200796595180L;
	@PersistenceContext 
	private EntityManager em;
	
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response lanzarProceso(AlarmaInsuficiencia alarma) {
		
		//
		String nombreProceso="alarmasMonedasBilletes";		
		KioskoInfoManager kiosko=buscarKiosko(alarma.getMac());
		Map<String,Object>parametros=new HashMap<>();
		parametros.put("nombreKiosko", kiosko.getNombre());
		parametros.put("cajeroLider", kiosko.getCajeroLider());
		parametros.put("supervisor", kiosko.getSupervisor());
		parametros.put("sucursal", kiosko.getSucursal());
		parametros.put("mac", alarma.getMac());
		parametros.put("um01", alarma.getUm01());
		parametros.put("um05", alarma.getUm05());
		parametros.put("um10", alarma.getUm10());
		parametros.put("um25", alarma.getUm25());
		parametros.put("um50", alarma.getUm50());
		parametros.put("um100", alarma.getUm100());
		parametros.put("m01", alarma.getM01());
		parametros.put("m05", alarma.getM05());
		parametros.put("m10", alarma.getM10());
		parametros.put("m25", alarma.getM25());
		parametros.put("m50", alarma.getM50());
		parametros.put("m100", alarma.getM100());
		parametros.put("ub01", alarma.getUb01());
		parametros.put("ub02", alarma.getUb02());
		parametros.put("ub05", alarma.getUb05());
		parametros.put("ub10", alarma.getUb10());
		parametros.put("ub20", alarma.getUb20());
		parametros.put("ub50", alarma.getUb50());
		parametros.put("ub100", alarma.getUb100());
		parametros.put("b01", alarma.getB01());		
		parametros.put("b02", alarma.getB02());
		parametros.put("b05", alarma.getB05());
		parametros.put("b10", alarma.getB10());
		parametros.put("b20", alarma.getB20());
		parametros.put("b50", alarma.getB50());
		parametros.put("b100", alarma.getB100());
		parametros.put("ciclotiempo", kiosko.getPatronTiempo());
		String uuid=UUID.randomUUID().toString();
		parametros.put("uuid", uuid);
		parametros.put("insatisfecho", false);
		return Response.ok().build();
	}
	@GET
	@Path("{mac}")
	public KioskoInfoManager buscarKiosko(@PathParam("mac") String mac) {
		KioskoInfoManager retorno=null;				
		return retorno;
	}
}
