package br.edu.infnet.javainjecaopersistenciaemprestimos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.infnet.javainjecaopersistenciaemprestimos.model.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Integer> {

}
