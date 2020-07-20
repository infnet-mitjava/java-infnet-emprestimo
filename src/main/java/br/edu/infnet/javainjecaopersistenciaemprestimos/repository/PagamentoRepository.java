package br.edu.infnet.javainjecaopersistenciaemprestimos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.infnet.javainjecaopersistenciaemprestimos.model.Emprestimo;
import br.edu.infnet.javainjecaopersistenciaemprestimos.model.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
	
	List<Pagamento> findByEmprestimo(Emprestimo emprestimo);
	
}
