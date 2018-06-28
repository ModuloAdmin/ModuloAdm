package br.edu.up.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.edu.up.dominio.Acao;
import br.edu.up.repository.AcaoRepository;



@RunWith(SpringRunner.class)
@SpringBootTest
public class CrudAcaoRepository {

	@Autowired
	AcaoRepository acaoRepository;

	/**
	 * Métodos Crud.
	 */
	@Test
	public void AcaoCrud() {
		
		// salvar ação
		acaoRepository.save(new Acao(1, "visualizar"));
		acaoRepository.save(new Acao(2, "buscar"));

//		// alterar descrição da ação
//		Acao acao = new Acao();
//
//		acao = acaoRepository.findOne(11);
//		acao.setDsAcao("visualizar ações");
//		acaoRepository.save(acao);
//		
//		acao = acaoRepository.findOne(12);
//		acao.setDsAcao("buscar ações");
//		acaoRepository.save(acao);
//	
//		acaoRepository.deleteAll();
//		
//		// buscar ação
//		System.out.println("\n*************Acoes*************");
//		acaoRepository.findAll().forEach(System.out::println);
//
//		// deletar ação
//		acao = acaoRepository.findOne(11);
//		acaoRepository.delete(acao);
//		
//		acao = acaoRepository.findOne(12);
//		acaoRepository.delete(acao);

	}

}
