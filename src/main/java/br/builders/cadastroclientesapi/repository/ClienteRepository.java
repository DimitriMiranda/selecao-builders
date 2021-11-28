package br.builders.cadastroclientesapi.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.builders.cadastroclientesapi.domain.model.Cliente;
import org.springframework.stereotype.Repository;



@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	Cliente findByNome(String nome);

}