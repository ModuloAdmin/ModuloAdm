package br.edu.up.jpa.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="grupo")
public class Grupo {
	
	@Id
	@GeneratedValue
	private Integer idGrupo;
	
	@Column
	private String grupoDescricao;
	
	@OneToMany
	@JoinColumn
	private Usuario usuario;
	
	public Grupo( String grupoDescricao, Usuario usuario) {
		this.grupoDescricao = grupoDescricao;
		this.usuario = usuario;
	}
	
	protected Grupo() {
		
	}

	public Integer getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(Integer idGrupo) {
		this.idGrupo = idGrupo;
	}

	public String getGrupoDescricao() {
		return grupoDescricao;
	}

	public void setGrupoDescricao(String grupoDescricao) {
		this.grupoDescricao = grupoDescricao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@Override
	public String toString() {
		return "Grupo{"+"idGrupo=" + idGrupo + ", " + "grupoDescricao=" + grupoDescricao 
				+ ", usuario=" + usuario.getIdUsuario() +"}\n";
	}
	
}
