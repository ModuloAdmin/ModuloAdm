package br.edu.up.jpa.dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="usuario_modulo")
public class Usuario_Modulo {
	
	@Embedded
	private Usuario usuario;
	
	@Embedded
	private Modulo modulo;
	
	@OneToMany
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	@OneToMany
	private List<Modulo> modulos = new ArrayList<Modulo>();
	
	
	public Usuario_Modulo(Usuario usuario, Modulo modulo) {
		this.usuario = usuario;
		this.modulo = modulo;
		usuarios = new ArrayList<Usuario>();
		modulos = new ArrayList<Modulo>();
	}
	
	protected Usuario_Modulo() {
		
	}	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	public List<Usuario> getUsuarios() {
	        return usuarios;
	}
	
	public List<Modulo> getModulos() {
	        return modulos;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public void setModulos(List<Modulo> modulos) {
		this.modulos = modulos;
	}
	
	@Override
	public String toString() {
		return "Usuario_Modulo{"+"usuario=" + usuario.getIdUsuario() + ", " 
				+ "modulo=" + modulo.getIdModulo() +"}\n";
	}
	
}
