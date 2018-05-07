package br.edu.up.Admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import br.edu.up.Admin.dominio.Menu;

public interface MenuRepository extends CrudRepository<Menu, String> {


}
