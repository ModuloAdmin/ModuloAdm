package br.edu.up.jpa;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.edu.up.dominio.Menu;
import br.edu.up.dominio.Modulo;
import br.edu.up.repository.ModuloRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CrudModulo {

	@Autowired
	ModuloRepository moduloRepository;

	@Test
	public void CrudModuloTeste() {

		 List<Menu> menu = new ArrayList<>();

		moduloRepository.save(new Modulo("compras", 4, menu));
		moduloRepository.save(new Modulo("vendas", 5, menu));

		// altera descrição do modulo
/*		Modulo modulo = new Modulo();

		modulo = moduloRepository.findOne(1);
		modulo.setDsModulo("financeiro");
		moduloRepository.save(modulo);

		modulo = moduloRepository.findOne(2);
		modulo.setDsModulo("RH");
		moduloRepository.save(modulo);*/

		// busca os modulos
		System.out.println("\n*************Módulos*************");
		moduloRepository.findAll().forEach(System.out::println);

/*		// deleta os modulos
		modulo = moduloRepository.findOne(1);
		moduloRepository.delete(modulo);

		modulo = moduloRepository.findOne(2);
		moduloRepository.delete(modulo);
		*/
//		moduloRepository.deleteAll();

	}
}
