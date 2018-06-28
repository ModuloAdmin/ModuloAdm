package br.edu.up.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.edu.up.dominio.Menu;
import br.edu.up.repository.MenuRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrudMenu {

	@Autowired
	MenuRepository menuRepository;

	@Test
	public void CrudMenuTeste() {
		
		
		// salvar menu
		menuRepository.save(new Menu("visualizar", null ));
		menuRepository.save(new Menu("deletar", null));

		// alterar descrição do menu
		
/*		Menu menu = new Menu();
		
		menu = menuRepository.findOne(2);
		menu.setDsMenu("visualizar modulos");
		menuRepository.save(menu);
		
		menu = menuRepository.findOne(3);
		menu.setDsMenu("deletar modulos");
		menuRepository.save(menu);
		*/
		
		// buscar menu
		System.out.println("\n*************menu*************");
		menuRepository.findAll().forEach(System.out::println);

		// deletar menu
		
/*		menu = menuRepository.findOne(2);
		menuRepository.delete(menu);
		
		menu = menuRepository.findOne(3);
		menuRepository.delete(menu);*/
		
//		menuRepository.deleteAll();
		

	}
}
