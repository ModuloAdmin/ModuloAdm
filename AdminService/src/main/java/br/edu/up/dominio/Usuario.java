package br.edu.up.dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue
	private int idUsuario;

	@Column
	private Integer Idexterno;

	@Column
	private String Nome;

	// Relacionamento implementado

	@ManyToMany
	@JoinTable(name = "usuario_acao", joinColumns = { @JoinColumn(name = "idUsuario") }, inverseJoinColumns = {
			@JoinColumn(name = "idAcao") })
	private List<Acao> acoes = new  ArrayList<>();

	// Relacionamento implementado

	@ManyToMany
	@JoinTable(name = "usuario_modulo", joinColumns = { @JoinColumn(name = "idUsuario") }, inverseJoinColumns = {
			@JoinColumn(name = "idModulo") })
	private List<Modulo> modulos = new  ArrayList<>();

	public Usuario() {
		this.modulos = new ArrayList<>();
	}

	public Usuario(Integer idexterno, String nome, List<Acao> acoes, List<Modulo> modulos) {
		this.modulos = new  ArrayList<Modulo>();
		this.Idexterno = idexterno;
		this.Nome = nome;
		this.acoes = acoes;
		this.modulos = modulos;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getIdexterno() {
		return Idexterno;
	}

	public void setIdexterno(Integer idexterno) {
		Idexterno = idexterno;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public List<Acao> getAcoes() {
		return acoes;
	}

	public void setAcoes(List<Acao> acoes) {
		this.acoes = acoes;
	}

	public List<Modulo> getModulos() {
		return modulos;
	}

	public void setModulos(List<Modulo> modulos) {
		this.modulos = modulos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Idexterno == null) ? 0 : Idexterno.hashCode());
		result = prime * result + ((Nome == null) ? 0 : Nome.hashCode());
		result = prime * result + ((acoes == null) ? 0 : acoes.hashCode());
		result = prime * result + idUsuario;
		result = prime * result + ((modulos == null) ? 0 : modulos.hashCode());
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
		Usuario other = (Usuario) obj;
		if (Idexterno == null) {
			if (other.Idexterno != null)
				return false;
		} else if (!Idexterno.equals(other.Idexterno))
			return false;
		if (Nome == null) {
			if (other.Nome != null)
				return false;
		} else if (!Nome.equals(other.Nome))
			return false;
		if (acoes == null) {
			if (other.acoes != null)
				return false;
		} else if (!acoes.equals(other.acoes))
			return false;
		if (idUsuario != other.idUsuario)
			return false;
		if (modulos == null) {
			if (other.modulos != null)
				return false;
		} else if (!modulos.equals(other.modulos))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", Idexterno=" + Idexterno + ", Nome=" + Nome + ", acoes=" + acoes
				+ ", modulos=" + modulos + "]";
	}

}
