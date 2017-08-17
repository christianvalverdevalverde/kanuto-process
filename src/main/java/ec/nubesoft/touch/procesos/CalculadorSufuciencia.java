package ec.nubesoft.touch.procesos;

import java.util.UUID;
import java.util.logging.Logger;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

public class CalculadorSufuciencia implements JavaDelegate {

	Logger loger=Logger.getLogger(CalculadorSufuciencia.class.getCanonicalName());
	@Override
	public void execute(DelegateExecution arg0) {				
		String mac = (String) arg0.getVariable("mac");
		Integer umbral_m01=(Integer) arg0.getVariable("um01");
		Integer m_01=(Integer)arg0.getVariable("m01");
		Integer umbral_m05=(Integer) arg0.getVariable("um05");
		Integer m_05=(Integer)arg0.getVariable("m05");
		Integer umbral_m10=(Integer) arg0.getVariable("um10");
		Integer m_10=(Integer)arg0.getVariable("m10");
		Integer umbral_m25=(Integer) arg0.getVariable("um25");
		Integer m_25=(Integer)arg0.getVariable("m25");
		Integer umbral_m50=(Integer) arg0.getVariable("um50");
		Integer m_50=(Integer)arg0.getVariable("m50");
		Integer umbral_m100=(Integer) arg0.getVariable("um100");
		Integer m_100=(Integer)arg0.getVariable("m100");
		
		Integer umbral_b01=(Integer) arg0.getVariable("ub01");
		Integer b_01=(Integer)arg0.getVariable("b01");
		Integer umbral_b02=(Integer) arg0.getVariable("ub02");
		Integer b_02=(Integer)arg0.getVariable("b02");
		Integer umbral_b05=(Integer) arg0.getVariable("ub05");
		Integer b_05=(Integer)arg0.getVariable("b05");
		
		Integer umbral_b10=(Integer) arg0.getVariable("ub10");
		Integer b_10=(Integer)arg0.getVariable("b10");
		
		Integer umbral_b20=(Integer) arg0.getVariable("ub20");
		Integer b_20=(Integer)arg0.getVariable("b20");
		
		Integer umbral_b50=(Integer) arg0.getVariable("ub50");
		Integer b_50=(Integer)arg0.getVariable("b50");
		
		Integer umbral_b100=(Integer) arg0.getVariable("ub100");
		Integer b_100=(Integer)arg0.getVariable("b100");
		boolean instatisfecho=false;
		if(umbral_m01>0) {
			if(umbral_m01>=m_01) {
				instatisfecho=true;
			}					
		}
		if(umbral_m05>0) {
			if(umbral_m05>=m_05) {
				instatisfecho=true;
			}
		}
		if(umbral_m10>0) {
			if(umbral_m10>=m_10) {
				instatisfecho=true;
			}
		}
		if(umbral_m25>0) {
			if(umbral_m25>=m_25) {
				instatisfecho=true;
			}
		}
		if(umbral_m50>0) {
			if(umbral_m50>=m_50) {
				instatisfecho=true;
			}
		}
		if(umbral_m100>0) {
			if(umbral_m100>=m_100) {
				instatisfecho=true;
			}
		}
		if(umbral_b01>0) {
			if(umbral_b01>=b_01) {
				instatisfecho=true;
			}
		}
		if(umbral_b02>0) {
			if(umbral_b02>=b_02) {
				instatisfecho=true;
			}
		}
		if(umbral_b05>0) {
			if(umbral_b05>=b_05) {
				instatisfecho=true;
			}
		}
		
		if(umbral_b05>0) {
			if(umbral_b05>=b_05) {
				instatisfecho=true;
			}
		}
		
		if(umbral_b10>0) {
			if(umbral_b10>=b_10) {
				instatisfecho=true;
			}
		}
		
		if(umbral_b20>0) {
			if(umbral_b20>=b_20) {
				instatisfecho=true;
			}
		}
		if(umbral_b50>0) {
			if(umbral_b50>=b_02) {
				instatisfecho=true;
			}
		}
		if(umbral_b100>0) {
			if(umbral_b100>=b_100) {
				instatisfecho=true;
			}
		}		
		arg0.setVariable("insatisfecho", instatisfecho);
		loger.info("se ha puesto la variable instatisfecho con valor "+instatisfecho);
	}

}
