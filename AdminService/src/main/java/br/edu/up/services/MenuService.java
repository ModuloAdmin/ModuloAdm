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

import br.edu.up.dominio.Menu;
import br.edu.up.repository.MenuRepository;

@Service
@RestController
@RequestMapping("/wsm")
public class MenuService {
	
	@Autowired
	MenuRepository mr;
	
	@GetMapping 
	@RequestMapping("/listar")
	public @ResponseBody Iterable<Menu> listaMenus() 
	{
		Iterable<Menu> listaMenus = mr.findAll();
		return listaMenus;			
	}
	
	@PostMapping
	@RequestMapping("/cadastrar")
	public void cadastraMenu(@RequestBody Menu menu) 
	{
		mr.save(menu);
		System.out.println("Menu cadastrado com sucesso!");
	}
	
	@DeleteMapping
	@RequestMapping("/deletar/{id}")
	@RestResource(exported=false)
	public Menu deletaMenu(@RequestBody Menu idMenu) 
	{
		mr.delete(idMenu);
		System.out.println("Menu deletado com sucesso!");
		return idMenu;
	}

}
