package br.edu.up.jpa.dominio;

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

}
