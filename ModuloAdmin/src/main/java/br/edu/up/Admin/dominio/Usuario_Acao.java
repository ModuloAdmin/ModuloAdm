package br.edu.up.Admin.dominio;

import java.util.ArrayList;
import java.util.List;

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
	private List<Modulo> modulos;
	
	@Embedded
	private Grupo grupo;
	
	private List<Menu> menus;

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(Menu menus) {
		this.menus.add(menus);
	}

	public Usuario_Acao(Menu menu, Modulo modulo, Grupo grupo_acao) {
		
		this.menu = menu;
		this.modulos.add(modulo);
		this.grupo = grupo_acao;
		
	}
	
	public Usuario_Acao() {
		this.menus= new ArrayList();
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public List<Modulo> getModulo() {
		return modulos;
	}

	public void setModulo(Modulo modulo) {
		this.modulos.add(modulo);
	}

	public Grupo getGrupo_acao() {
		return grupo;
	}

	public void setGrupo(Grupo grupo_acao) {
		this.grupo = grupo_acao;
	}
	
	//@Override
	//public String toString() {
	//	return "Usuario_Acao{"+"menu=" + menu.getIdMenu() + ", " 
	//			+ "modulo=" + modulo.getIdModulo() + ", " + "grupo_acao=" +
	//			grupo_acao.getIdGrupo_Acao() + ", " + "grupo_acao=" + grupo_acao.getAcao() +
	//			", " + "grupo_acao="+ grupo_acao.getGrupo() + "}\n";
	//}
}

