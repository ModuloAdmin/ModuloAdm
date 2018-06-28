package br.edu.up.dominio;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CdAcao == null) ? 0 : CdAcao.hashCode());
		result = prime * result + ((DsAcao == null) ? 0 : DsAcao.hashCode());
		result = prime * result + ((idAcao == null) ? 0 : idAcao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Acao other = (Acao) obj;
		if (CdAcao == null) {
			if (other.CdAcao != null)
				return false;
		} else if (!CdAcao.equals(other.CdAcao))
			return false;
		if (DsAcao == null) {
			if (other.DsAcao != null)
				return false;
		} else if (!DsAcao.equals(other.DsAcao))
			return false;
		if (idAcao == null) {
			if (other.idAcao != null)
				return false;
		} else if (!idAcao.equals(other.idAcao))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Acao [idAcao=" + idAcao + ", CdAcao=" + CdAcao + ", DsAcao=" + DsAcao + "]";
	}
	
	

}
