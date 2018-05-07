package br.edu.up.Admin.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="acao")
public class Acao {
	
	
	@Id
	@GeneratedValue
	private Integer idAcao;
	
	@Column
	private Integer CdAcao;
	
	@Column
	private String DsAcao;
	
	public Acao( Integer CdAcao, String DsAcao) {
		this.CdAcao = CdAcao;
		this.DsAcao = DsAcao;
	}
	
	public Acao() {
		
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
	
	@Override
	public String toString() {
		return "Acao{"+"idAcao=" + idAcao + ", " + "CdAcao=" + CdAcao 
				+ ", DsAcao=" + DsAcao +"}\n";
	}
	
}
