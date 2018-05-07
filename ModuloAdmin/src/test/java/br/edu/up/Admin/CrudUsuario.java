package br.edu.up.Admin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.edu.up.Admin.repository.UsuarioRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrudUsuario {

    @Autowired
    UsuarioRepository usuarioRepository;

    /**
     * Métodos Crud.
     */
    @Test
    public void CrudUsuario() {
//        usuarioRepository.save(new Usuario(1, "eu"));
//        usuarioRepository.save(new Usuario(2, "eu"));
//        usuarioRepository.save(new Usuario(3, "eu"));
//        usuarioRepository.save(new Usuario(4, "eu"));

//        System.out.println("\n*************Todos os usuarios*************");
//        usuarioRepository.findAll().forEach(System.out::println);
//
//        //alterar a idade dos usuarios
//        usuarioRepository.findAll().forEach(usuario -> {
//            usuario.setNome("giovane carvalho");
//            usuarioRepository.save(usuario);
//        });
//
//        System.out.println("\n*************Usuarios com nova idade*************");
//        usuarioRepository.findAll().forEach(System.out::println);

        usuarioRepository.deleteAll();
        System.out.println("\n*************Usuarios excluídos*************");
        usuarioRepository.findAll().forEach(System.out::println);

    }
}
