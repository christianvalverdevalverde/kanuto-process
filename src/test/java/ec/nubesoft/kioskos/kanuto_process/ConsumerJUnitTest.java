package ec.nubesoft.kioskos.kanuto_process;

import ec.nubesoft.kiosko.servicio.ConsumerService;

import org.junit.Rule;
import org.junit.Test;

/**
 * JUnit Test class para consumo de servicios
 * @author carper
 * 2017-08-28, 31
 */ 
public class ConsumerJUnitTest{

	// mvn test -Dtest=ec.nubesoft.kioskos.kanuto_process.ConsumerJUnitTest
	@Test
	public void testPOST(){
		//System.out.println("Hello World");
		String output = new ConsumerService().doPost();

		System.out.println(output);

	}
}
