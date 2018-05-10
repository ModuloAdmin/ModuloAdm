package br.edu.up.jpa.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "menu")
public class Menu {

	@Id
	@GeneratedValue
	private Integer idMenu;

	@Column
	private String DsMenu;

	@ManyToOne
	@JoinColumn
	private Modulo modulo;

	public Menu(String dsMenu, Modulo modulo) {

		this.DsMenu = dsMenu;
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

	public String getDsMenu() {
		return DsMenu;
	}

	public void setDsMenu(String dsMenu) {
		DsMenu = dsMenu;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

}
