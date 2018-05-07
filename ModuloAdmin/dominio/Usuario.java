package br.edu.up.jpa.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	@GeneratedValue
	private Integer idUsuario;

	protected Usuario(){
		
	}
	 
	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Override
    public String toString() {
	        return "Aluno{" + "idUsuario=" + idUsuario +"}\n";
	    }

}

