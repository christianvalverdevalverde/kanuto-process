package ec.nubesoft.kiosko.ui;

import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zk.ui.Component;

/**
 * Clase MovimientoDineroPorDenominacion para registrar ingresos y egresos de dinero
 * @author carper
 * 2017-09-04
 */ 
public class MovimientoDineroPorDenominacion{

	public void doAfterCompose(Component comp) throws Exception {
	}

	public void calcular(Intbox campo, int valorCentavos, Label etiqueta){
		int denominacion = campo.intValue();
		int total = denominacion * valorCentavos;
		etiqueta.setValue(""+total);
	}
		
}
