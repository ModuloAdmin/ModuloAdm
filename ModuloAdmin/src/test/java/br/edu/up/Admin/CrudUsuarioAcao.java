package br.edu.up.Admin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.edu.up.Admin.dominio.Grupo_Acao;
import br.edu.up.Admin.dominio.Menu;
import br.edu.up.Admin.dominio.Modulo;
import br.edu.up.Admin.dominio.Usuario;
import br.edu.up.Admin.dominio.Usuario_Acao;
import br.edu.up.Admin.repository.MenuRepository;
import br.edu.up.Admin.repository.UsuarioAcaoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrudUsuarioAcao {
	
	@Autowired
	 UsuarioAcaoRepository usuarioAcaoRepository;
	 
	 @Test
	    public void CrudUsuarioAcao() {

		 //usuarioAcaoRepository.save(new Usuario_Acao(new Menu(), new Modulo(), new Grupo_Acao())); 

	        
	        usuarioAcaoRepository.findAll().forEach(System.out::println);
	        
		 	/*usuarioAcaoRepository.deleteAll();
	        System.out.println("\n*************excluído*************");
	        usuarioAcaoRepository.findAll().forEach(System.out::println);*/

	        
	}	 
}
