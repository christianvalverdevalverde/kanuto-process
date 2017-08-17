package ec.nubesoft.touch.procesos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;

@Entity

public class KioskoInfoManager implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8822250878378268061L;
	@Id
	private String mac;
	private String sucursal;
	private String nombre;
	private String cajeroLider;
	private String supervisor;
	private String patronTiempo;
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public String getSucursal() {
		return sucursal;
	}
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCajeroLider() {
		return cajeroLider;
	}
	public void setCajeroLider(String cajeroLider) {
		this.cajeroLider = cajeroLider;
	}
	public String getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}
	public String getPatronTiempo() {
		return patronTiempo;
	}
	public void setPatronTiempo(String patronTiempo) {
		this.patronTiempo = patronTiempo;
	}
	@PrePersist
	public void antesPersistir() {
		if(cajeroLider==null) {
			cajeroLider="cajerolider@nubesoft.ec";			
		}
		if(supervisor==null) {
			supervisor="supervisor@nubesoft.ec";
		}
		if(nombre==null) {
			nombre="kiosko1";
		}
		if(sucursal==null) {
			sucursal="alborada";
		}
		if(mac==null) {
			mac="aa-bb-cc-dd-ee-ff";
		}
		if(patronTiempo==null) {
			patronTiempo="R/PT5M";
		}
	}

}
