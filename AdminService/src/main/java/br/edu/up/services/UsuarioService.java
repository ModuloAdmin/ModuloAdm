package br.edu.up.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import br.edu.up.dominio.Usuario;
import br.edu.up.repository.UsuarioRepository;

@Service
@RestController
@RequestMapping("/wsu")
public class UsuarioService {

	@Autowired
	UsuarioRepository ur;

	@GetMapping 
	@RequestMapping("/listar")
	public @ResponseBody Iterable<Usuario> listaUsuario() 
	{
		Iterable<Usuario> listaUsuario = ur.findAll();
		return listaUsuario;				
	}
		
	@PostMapping
	@RequestMapping("/cadastrar")
	public void cadastraUsuario(@RequestBody Usuario usuario) 
	{
		ur.save(usuario);
		System.out.println("Usuario cadastrado com sucesso!");
	}
	
	@DeleteMapping
	@RequestMapping("/deletar/{id}")
	@RestResource(exported=false)
	public Usuario deletaUsuario(@RequestBody Usuario idUsuario) 
	{
		ur.delete(idUsuario);
		System.out.println("Usuário deletado com sucesso!");
		return idUsuario;
	}
	
}
