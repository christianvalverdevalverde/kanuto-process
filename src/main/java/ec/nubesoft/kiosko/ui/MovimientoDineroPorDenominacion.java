package ec.nubesoft.kiosko.ui;

import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Window;
import org.zkoss.zk.ui.Component;

/**
 * Clase MovimientoDineroPorDenominacion para registrar ingresos y egresos de dinero
 * @author carper
 * 2017-09-04, 07
 */ 
public class MovimientoDineroPorDenominacion extends GenericForwardComposer {

	private Window win;
	private Label lblParametro;
	private String tipo;

	public void doAfterCompose(Component comp) throws Exception {

		super.doAfterCompose(comp);

		try{
			tipo = lblParametro.getValue();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			tipo = "I";
		}

		win.setTitle( (tipo.equals("I") ? "Ingreso": "Egreso") + " " + win.getTitle() );  
	}

}
