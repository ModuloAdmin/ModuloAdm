package br.edu.up.Admin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.edu.up.Admin.dominio.Menu;
import br.edu.up.Admin.dominio.Modulo;
import br.edu.up.Admin.dominio.Usuario;
import br.edu.up.Admin.repository.MenuRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CrudMenu {

	 @Autowired
	 MenuRepository menuRepository;
	 
	 @Test
	    public void CrudMenu() {

	        menuRepository.save(new Menu("teste", new Modulo()));

	        
	       // System.out.println("\n*************Todos os menus*************");
	        //menuRepository.findAll().forEach(System.out::println);
	        
//	        menuRepository.deleteAll();
//	        System.out.println("\n*************Menus excluídos*************");
//	        menuRepository.findAll().forEach(System.out::println);
	        
	}	 
}
