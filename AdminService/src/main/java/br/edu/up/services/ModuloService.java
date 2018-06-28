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

import br.edu.up.dominio.Modulo;
import br.edu.up.repository.ModuloRepository;

@Service
@RestController
@RequestMapping("/wsmod")
public class ModuloService {
	
	@Autowired
	ModuloRepository mr;
	
	@GetMapping 
	@RequestMapping("/listar")
	public @ResponseBody Iterable<Modulo> listaModulos() 
	{
		Iterable<Modulo> listaModulos = mr.findAll();
		return listaModulos;				
	}
	
	@PostMapping
	@RequestMapping("/cadastrar")
	public void cadastraModulo(@RequestBody Modulo modulo) 
	{
		 mr.save(modulo);
		 System.out.println("Modulo cadastrado com sucesso!");
	}
	
	@DeleteMapping
	@RequestMapping("/deletar/{id}")
	@RestResource(exported=false)
	public Modulo deletaModulo(@RequestBody Modulo idModulo) 
	{
		mr.delete(idModulo);
		System.out.println("Modulo deletado com sucesso!");
		return idModulo;
	}

}
