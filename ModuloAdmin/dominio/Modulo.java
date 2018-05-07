package br.edu.up.jpa.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	
	@OneToMany
	@JoinColumn
	private Usuario usuario;
	
	public Modulo( String DsModulo, Integer NrModulo, Usuario usuario) {
		this.DsModulo = DsModulo;
		this.NrModulo = NrModulo;
		this.usuario = usuario;
	}
	
	protected Modulo() {
		
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Modulo{"+"idModulo=" + idModulo + ", " + "DsModulo=" + DsModulo + ", " 
	+ "NrModulo=" + NrModulo + ", usuario=" + usuario.getIdUsuario() +"}\n";
	}
}
