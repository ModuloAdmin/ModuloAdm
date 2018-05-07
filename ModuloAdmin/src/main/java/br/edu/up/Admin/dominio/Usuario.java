package br.edu.up.Admin.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	@GeneratedValue
	private int idUsuario;

	public Usuario(){
		
	}
	 
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Override
    public String toString() {
	        return "Aluno{" + "idUsuario=" + idUsuario +"}\n";
	    }

}

