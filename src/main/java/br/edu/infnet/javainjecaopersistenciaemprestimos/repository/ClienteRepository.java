package br.edu.infnet.javainjecaopersistenciaemprestimos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.infnet.javainjecaopersistenciaemprestimos.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
