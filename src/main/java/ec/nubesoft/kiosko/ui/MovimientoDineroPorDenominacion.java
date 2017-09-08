package ec.nubesoft.kiosko.ui;

import ec.nubesoft.kiosko.servicio.ConsumerService;
import ec.nubesoft.kiosko.servicio.MovimientoBean;

import java.math.BigDecimal;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

/**
 * Clase MovimientoDineroPorDenominacion para registrar ingresos y egresos de dinero
 * @author carper
 * 2017-09-04, 07
 */ 
public class MovimientoDineroPorDenominacion extends GenericForwardComposer {

	private Window win;
	private Label lblParametro;
	private String tipo;

	//Etiquetas de las monedas
	private Label lbl1 ;
	private Label lbl5 ;
	private Label lbl10 ;
	private Label lbl25 ;
	private Label lbl50 ;
	private Label lbl100 ;

	//Etiquetas de los billetes
	private Label lbl0100 ;
	private Label lbl200 ;
	private Label lbl500 ;
	private Label lbl1000 ;
	private Label lbl2000 ;
	private Label lbl5000 ;
	private Label lbl10000 ;

	public void doAfterCompose(Component comp) throws Exception {

		super.doAfterCompose(comp);

		/*
		try{
			tipo = lblParametro.getValue();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			tipo = "I";
		}
		*/
		
		tipo = lblParametro.getValue();
		//System.out.println(tipo);
		win.setTitle( (tipo.equals("I") ? "Ingreso": "Egreso") + " " + win.getTitle() );  
	}

	public void onClick$btnProcesar(){
		MovimientoBean m = new MovimientoBean();

		m.setMoneda_01 	 (new BigDecimal( (tipo.equals("E") ? "-": "") + lbl1.  	getValue() ));
		m.setMoneda_05 	 (new BigDecimal( (tipo.equals("E") ? "-": "") + lbl5.  	getValue() ));
		m.setMoneda_10 	 (new BigDecimal( (tipo.equals("E") ? "-": "") + lbl10. 	getValue() ));
		m.setMoneda_25 	 (new BigDecimal( (tipo.equals("E") ? "-": "") + lbl25. 	getValue() ));
		m.setMoneda_50 	 (new BigDecimal( (tipo.equals("E") ? "-": "") + lbl50. 	getValue() ));
		m.setMoneda_100	 (new BigDecimal( (tipo.equals("E") ? "-": "") + lbl100.	getValue() ));

		m.setBillete_01  (new BigDecimal( (tipo.equals("E") ? "-": "") + lbl0100.	getValue() ));
		m.setBillete_02  (new BigDecimal( (tipo.equals("E") ? "-": "") + lbl200.  	getValue() ));
		m.setBillete_05  (new BigDecimal( (tipo.equals("E") ? "-": "") + lbl500. 	getValue() ));
		m.setBillete_10  (new BigDecimal( (tipo.equals("E") ? "-": "") + lbl1000. 	getValue() ));
		m.setBillete_20  (new BigDecimal( (tipo.equals("E") ? "-": "") + lbl2000.	getValue() ));
		m.setBillete_50  (new BigDecimal( (tipo.equals("E") ? "-": "") + lbl5000.	getValue() ));
		m.setBillete_100 (new BigDecimal( (tipo.equals("E") ? "-": "") + lbl10000.	getValue() ));

		//(tipo.equals("E") ? "-": "")

		m.setMac("AA-BB-CC-DD-EE");
		m.setNumeroOrden(0);  //usa cero para movimientos manuales.

		String output = "" + new ConsumerService().doMovimientoPost(m);
		System.out.println(output);
		Messagebox.show("Mensaje de respuesta: " +output);
	}

}
