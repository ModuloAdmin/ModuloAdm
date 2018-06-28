package br.edu.up.jpa;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.edu.up.dominio.Acao;
import br.edu.up.dominio.Modulo;
import br.edu.up.dominio.Usuario;
import br.edu.up.repository.UsuarioRepository;



@RunWith(SpringRunner.class)
@SpringBootTest
public class CrudUsuarioRepository {


    @Autowired
    UsuarioRepository usuarioRepository;

    /**
     * Métodos Crud.
     */
    @Test
    public void exemploDeCrud() {
    	
    	List<Acao> acao = new ArrayList<>();
    	List<Modulo> modulo = new ArrayList<>();
    	
    	usuarioRepository.save(new Usuario(1, "Giovane", acao, modulo ));
    	usuarioRepository.save(new Usuario(2, "Gabriel", acao, modulo ));

		// alterar nome do usuário
/*		Usuario usuario = new Usuario();

		usuario = usuarioRepository.findOne(3);
		usuario.setNome("Gigi");
		usuarioRepository.save(usuario);
		
		usuario = usuarioRepository.findOne(4);
		usuario.setNome("Gabriel B.");
		usuarioRepository.save(usuario);
*/
		// busca usuarios
		System.out.println("\n*************Usuarios*************");
		usuarioRepository.findAll().forEach(System.out::println);

		// deleta usuarios
/*		usuario = usuarioRepository.findOne(3);
		usuarioRepository.delete(usuario);
		
		usuario = usuarioRepository.findOne(4);
		usuarioRepository.delete(usuario);*/
		
		
//		usuarioRepository.deleteAll();
		

    }


}
