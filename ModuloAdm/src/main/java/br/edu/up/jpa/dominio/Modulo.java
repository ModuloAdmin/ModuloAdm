package br.edu.up.jpa.dominio;

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


}
