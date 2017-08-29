package ec.nubesoft.kiosko.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Clase Utileria siguiendo el patrón Singleton
 * @author carper
 * 2017-08-28
 */ 
public class Utileria {
    // Crear un objeto de Utileria
    public static Utileria instancia = new Utileria();

    // Hacer el construcor privado para que esta clase no pueda ser instanciada
    private Utileria(){}

    // Obtener el único objeto disponible
    public static Utileria getInstancia(){
        return instancia;
    }

	public Map getConfigMap(){
        
		Map valor = new HashMap();

		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		try(InputStream resourceStream = loader.getResourceAsStream("config.properties")) {
        	Properties props = new Properties();
			props.load(resourceStream);
 
			valor.put("MOVIMIENTOS_URL", props.getProperty("MOVIMIENTOS_URL"));
 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return valor;
	}

}
