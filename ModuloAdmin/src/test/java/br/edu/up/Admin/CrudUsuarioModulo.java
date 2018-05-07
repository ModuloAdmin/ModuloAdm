package br.edu.up.Admin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.edu.up.Admin.dominio.Modulo;
import br.edu.up.Admin.dominio.Usuario;
import br.edu.up.Admin.dominio.Usuario_Modulo;
import br.edu.up.Admin.repository.UsuarioModuloRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrudUsuarioModulo {
	
	 @Autowired
	 UsuarioModuloRepository usuarioModuloRepository;
	@Test
    public void CrudUsuarioModulo() {
		
		usuarioModuloRepository.save(new Usuario_Modulo(new Usuario(), new Modulo()));

//        usuarioModuloRepository.findAll().forEach(System.out::println);
//

		/*usuarioModuloRepository.deleteAll();
        System.out.println("\n*************Usuarios excluídos*************");
        usuarioModuloRepository.findAll().forEach(System.out::println);*/

    }

}
