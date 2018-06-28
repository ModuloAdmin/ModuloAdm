package br.edu.up.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import br.edu.up.dominio.Usuario;

//@RepositoryRestResource(path = "usuarios", excerptProjection = Usuario.class)
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
	
	//Usuario findByIdUsuario(@Param("idUsuario") int idUsuario);
}
