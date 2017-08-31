package ec.nubesoft.kioskos.kanuto_process;

import ec.nubesoft.kiosko.servicio.ConsumerService;
import ec.nubesoft.kiosko.servicio.MovimientoBean;
import java.math.BigDecimal;

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
	
		MovimientoBean m = new MovimientoBean();
		m.setMoneda_01(BigDecimal.ZERO);
		m.setMoneda_05(new BigDecimal("0.05"));
		m.setMoneda_10(new BigDecimal("0.40"));
		m.setMac("aa-bb-cc-dd-ee");
		m.setNumeroOrden(0);  //usa cero para movimientos manuales.

		String output = "" + new ConsumerService().doMovimientoPost(m);
		System.out.println(output);

	}
}
