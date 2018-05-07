package br.edu.up.Admin.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.up.Admin.dominio.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

}
