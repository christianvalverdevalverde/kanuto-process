package ec.nubesoft.kiosko.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Clase Configuracion siguiendo el patrón Singleton
 * @author carper
 * 2017-08-28, 31
 */ 
public class Configuracion {
	
	private static String servidor;
	private static String puerto;
	private static String contexto;
	private static String subContexto;
	
	private static String pathpostImpresion;
	private static String pathpostInventario;
	private static String pathpostMovimientos;

    // Crear un objeto de Configuracion
    public static Configuracion instancia = new Configuracion();

    // Obtener el único objeto disponible
    public static Configuracion getInstancia(){
        return instancia;
    }

    // Hacer el construcor privado para que esta clase no pueda ser instanciada
    private Configuracion(){
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		try(InputStream resourceStream = loader.getResourceAsStream("config.properties")) {
        	Properties propiedades = new Properties();
			propiedades.load(resourceStream);

			servidor            = propiedades.getProperty("servidor");
			puerto              = propiedades.getProperty("puerto");
			contexto            = propiedades.getProperty("contexto");
			subContexto         = propiedades.getProperty("version");
			pathpostImpresion   = propiedades.getProperty("pathpostimpresion");
			pathpostInventario  = propiedades.getProperty("pathpostinventario");
			pathpostMovimientos = propiedades.getProperty("pathpostmovimientos");
 
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	public static String getPathpostImpresion() {
		return pathpostImpresion;
	}	
	
	public static String getPathpostInventario() {
		return pathpostInventario;
	}
	
	public static String getPathpostMovimientos() {
		return pathpostMovimientos;
	}

	public static String obtenerUrlStandard(String recurso) {
		StringBuilder sb=new StringBuilder();

		sb.append("http://");
		sb.append(servidor);
		sb.append(":");
		sb.append(puerto);
		sb.append("/");
		sb.append(contexto);
		sb.append("/");
		sb.append(subContexto);
		sb.append("/");
		sb.append(recurso);
		
		return sb.toString();
	}
}
