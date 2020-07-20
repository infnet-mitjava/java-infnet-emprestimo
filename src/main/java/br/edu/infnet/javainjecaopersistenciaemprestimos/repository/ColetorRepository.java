package br.edu.infnet.javainjecaopersistenciaemprestimos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.infnet.javainjecaopersistenciaemprestimos.model.Coletor;

public interface ColetorRepository extends JpaRepository<Coletor, Integer> {

}
