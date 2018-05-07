package br.edu.up.jpa.dominio;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario_acao")
public class Usuario_Acao {
	
	@Embedded
	private Menu menu;
	
	@Embedded
	private Modulo modulo;
	
	@Embedded
	private Grupo_Acao grupo_acao;

	public Usuario_Acao(Menu menu, Modulo modulo, Grupo_Acao grupo_acao) {
		
		this.menu = menu;
		this.modulo = modulo;
		this.grupo_acao = grupo_acao;
		
	}
	
	protected Usuario_Acao() {
		
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	public Grupo_Acao getGrupo_acao() {
		return grupo_acao;
	}

	public void setGrupo_acao(Grupo_Acao grupo_acao) {
		this.grupo_acao = grupo_acao;
	}
	
	@Override
	public String toString() {
		return "Usuario_Acao{"+"menu=" + menu.getIdMenu() + ", " 
				+ "modulo=" + modulo.getIdModulo() + ", " + "grupo_acao=" +
				grupo_acao.getIdGrupo_Acao() + ", " + "grupo_acao=" + grupo_acao.getAcao() +
				", " + "grupo_acao="+ grupo_acao.getGrupo() + "}\n";
	}
}

