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
@Table(name="grupo")
public class Grupo {
	
	@Id
	@GeneratedValue
	private Integer idGrupo;
	
	@Column
	private String grupoDescricao;
	
	private List<Acao> acao;
	
	public List<Acao> getAcao() {
		return acao;
	}

	public void setAcao(Acao acao) {
		this.acao.add(acao);
	}

	@OneToMany
	@JoinColumn
	private Usuario usuario;
	
	private List<Usuario> usuarios;
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuario usuarios) {
		this.usuarios.add(usuarios);
	}

	public Grupo( String grupoDescricao, Usuario usuario, List<Acao> acao) {
		this.grupoDescricao = grupoDescricao;
		this.usuario = usuario;
		this.acao = acao;
	}
	
	public Grupo() {
		this.acao = new ArrayList();
		this.usuarios = new ArrayList();
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
