package br.edu.up.jpa.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "acao")
public class Acao {

	@Id
	@GeneratedValue
	private Integer idAcao;

	@Column
	private Integer CdAcao;

	@Column
	private String DsAcao;

	public Acao() {

	}

	public Acao(Integer cdAcao, String dsAcao) {

		this.CdAcao = cdAcao;
		this.DsAcao = dsAcao;

	}

	public Integer getIdAcao() {
		return idAcao;
	}

	public void setIdAcao(Integer idAcao) {
		this.idAcao = idAcao;
	}

	public Integer getCdAcao() {
		return CdAcao;
	}

	public void setCdAcao(Integer cdAcao) {
		CdAcao = cdAcao;
	}

	public String getDsAcao() {
		return DsAcao;
	}

	public void setDsAcao(String dsAcao) {
		DsAcao = dsAcao;
	}

}
