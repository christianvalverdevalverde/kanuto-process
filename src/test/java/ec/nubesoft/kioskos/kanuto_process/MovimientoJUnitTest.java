package ec.nubesoft.kioskos.kanuto_process;

import ec.nubesoft.kiosko.servicio.MovimientoService;

import org.junit.Rule;
import org.junit.Test;

/**
 * JUnit Test class for movimiento service
 * @author carper
 * 2017-08-28
 */ 
public class MovimientoJUnitTest{

	// mvn test -Dtest=ec.nubesoft.kioskos.kanuto_process.MovimientoJUnitTest
	@Test
	public void testPOST(){
		//System.out.println("Hello World");
		String output = new MovimientoService().doPost();

		System.out.println(output);

	}
}
