package br.edu.up.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.up.jpa.dominio.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
	
}
