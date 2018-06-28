package br.edu.up.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.up.dominio.Acao;


public interface AcaoRepository extends JpaRepository<Acao,Integer> {
}
