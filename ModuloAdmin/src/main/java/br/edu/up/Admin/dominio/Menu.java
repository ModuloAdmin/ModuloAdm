package br.edu.up.Admin.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="menu")
public class Menu {
	
	@Id
	@GeneratedValue
	private Integer idMenu;
	
	@OneToMany
	@JoinColumn
	private Modulo modulo;
	
	@Column
	private String DsMenu;
	
	public Menu (String DsMenu, Modulo modulo ) {
		this.DsMenu = DsMenu;
		this.modulo = modulo;
		
	}
	public Menu() {
		
	}
	public Integer getIdMenu() {
		return idMenu;
	}
	public void setIdMenu(Integer idMenu) {
		this.idMenu = idMenu;
	}
	public Modulo getModulo() {
		return modulo;
	}
	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}
	public String getDsMenu() {
		return DsMenu;
	}
	public void setDsMenu(String dsMenu) {
		DsMenu = dsMenu;
	}
	
	@Override
	public String toString() {
		return "Menu{"+"idMenu=" + idMenu + ", " + "DsMenu=" + DsMenu 
				+ ", modulo=" + modulo.getIdModulo() +"}\n";
	}
	
}
