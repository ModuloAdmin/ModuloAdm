package br.edu.up.dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "modulo")
public class Modulo {

	@Id
	@GeneratedValue
	private Integer idModulo;

	@Column
	private String DsModulo;

	@Column
	private Integer NrModulo;

	@OneToMany(mappedBy = "modulo", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Menu> Menus = new ArrayList<>();

	public Modulo() {
		
		this.Menus = new ArrayList<>();
	}

	public Modulo(String dsModulo, Integer nrModulo, List<Menu> menus) {
		this.Menus = new ArrayList<>();
		this.DsModulo = dsModulo;
		this.NrModulo = nrModulo;
		this.Menus = menus;

	}

	public Integer getIdModulo() {
		return idModulo;
	}

	public void setIdModulo(Integer idModulo) {
		this.idModulo = idModulo;
	}

	public String getDsModulo() {
		return DsModulo;
	}

	public void setDsModulo(String dsModulo) {
		DsModulo = dsModulo;
	}

	public Integer getNrModulo() {
		return NrModulo;
	}

	public void setNrModulo(Integer nrModulo) {
		NrModulo = nrModulo;
	}

	public List<Menu> getMenus() {
		return Menus;
	}

	public void setMenus(List<Menu> menus) {
		Menus = menus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DsModulo == null) ? 0 : DsModulo.hashCode());
		result = prime * result + ((Menus == null) ? 0 : Menus.hashCode());
		result = prime * result + ((NrModulo == null) ? 0 : NrModulo.hashCode());
		result = prime * result + ((idModulo == null) ? 0 : idModulo.hashCode());
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
		Modulo other = (Modulo) obj;
		if (DsModulo == null) {
			if (other.DsModulo != null)
				return false;
		} else if (!DsModulo.equals(other.DsModulo))
			return false;
		if (Menus == null) {
			if (other.Menus != null)
				return false;
		} else if (!Menus.equals(other.Menus))
			return false;
		if (NrModulo == null) {
			if (other.NrModulo != null)
				return false;
		} else if (!NrModulo.equals(other.NrModulo))
			return false;
		if (idModulo == null) {
			if (other.idModulo != null)
				return false;
		} else if (!idModulo.equals(other.idModulo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Modulo [idModulo=" + idModulo + ", DsModulo=" + DsModulo + ", NrModulo=" + NrModulo + ", Menus=" + Menus
				+ "]";
	}

	
}
