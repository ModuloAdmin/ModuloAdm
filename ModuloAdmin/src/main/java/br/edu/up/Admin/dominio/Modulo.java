package br.edu.up.Admin.dominio;

import java.util.ArrayList;
import java.util.List;

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
	
	private List<Usuario> usuarios;
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public void setUsuarios(Usuario usuarios) {
		this.usuarios.add(usuarios);
	}

	@OneToMany
	@JoinColumn
	private Usuario usuario;
	
	public Modulo( String DsModulo, Integer NrModulo, Usuario usuario) {
		this.DsModulo = DsModulo;
		this.NrModulo = NrModulo;
		this.usuario = usuario;
	}
	
	public Modulo() {
		this.usuarios = new ArrayList();
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
