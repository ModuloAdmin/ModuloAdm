package br.edu.up.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "menu")
public class Menu {

	@Id
	@GeneratedValue
	private Integer idMenu;

	@Column
	private String DsMenu;
	
	@JsonIgnore
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DsMenu == null) ? 0 : DsMenu.hashCode());
		result = prime * result + ((idMenu == null) ? 0 : idMenu.hashCode());
		result = prime * result + ((modulo == null) ? 0 : modulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menu other = (Menu) obj;
		if (DsMenu == null) {
			if (other.DsMenu != null)
				return false;
		} else if (!DsMenu.equals(other.DsMenu))
			return false;
		if (idMenu == null) {
			if (other.idMenu != null)
				return false;
		} else if (!idMenu.equals(other.idMenu))
			return false;
		if (modulo == null) {
			if (other.modulo != null)
				return false;
		} else if (!modulo.equals(other.modulo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Menu [idMenu=" + idMenu + ", DsMenu=" + DsMenu + ", modulo=" + modulo + "]";
	}

}
