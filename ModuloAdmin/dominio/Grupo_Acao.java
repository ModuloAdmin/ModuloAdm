package br.edu.up.jpa.dominio;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="grupo_acao")
public class Grupo_Acao {

	@Id
    @GeneratedValue
	private Integer idGrupo_Acao;
	
	@Embedded
	private Grupo grupo;
	
	@Embedded
	private Acao acao;
	
	public Grupo_Acao(Grupo grupo, Acao acao) {
		
		this.grupo = grupo;
		this.acao = acao;
		
	}
	
	protected Grupo_Acao() {
		
	}

	public Integer getIdGrupo_Acao() {
		return idGrupo_Acao;
	}

	public void setIdGrupo_Acao(Integer idGrupo_Acao) {
		this.idGrupo_Acao = idGrupo_Acao;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Acao getAcao() {
		return acao;
	}

	public void setAcao(Acao acao) {
		this.acao = acao;
	}
	
	@Override
	public String toString() {
		return "Grupo_Acao{"+"grupo=" + grupo.getIdGrupo() + ", " 
				+ "acao=" + acao.getIdAcao() + ", " + "grupo=" + grupo.getUsuario() + "}\n";
	}
}
