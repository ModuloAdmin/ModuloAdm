package br.edu.up.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.up.dominio.Acao;
import br.edu.up.repository.AcaoRepository;

@Service
@RestController
@RequestMapping("/wsa")
public class AcaoService {

	//injetar dependencia
	@Autowired
	AcaoRepository ar;
	
	@GetMapping 
	@RequestMapping("/listar")
	public @ResponseBody Iterable<Acao> listaAcoes() 
	{
		Iterable<Acao> listaAcoes = ar.findAll();
		return listaAcoes;				
	}
	
	@PostMapping
	@RequestMapping("/cadastrar")
	public void cadastraAcao(@RequestBody Acao acao) 
	{
		ar.save(acao);
		System.out.println("Ação cadastrada com sucesso!");
	}
	
	@DeleteMapping
	@RequestMapping("/deletar/{id}")
	@RestResource(exported=false)
	public Acao deletaAcao(@RequestBody Acao idAcao) 
	{
		ar.delete(idAcao);
		System.out.println("Ação deletada com sucesso!");
		return idAcao;
	}
	
}
