package br.edu.infnet.javainjecaopersistenciaemprestimos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.javainjecaopersistenciaemprestimos.model.Cliente;
import br.edu.infnet.javainjecaopersistenciaemprestimos.model.Emprestimo;
import br.edu.infnet.javainjecaopersistenciaemprestimos.model.Pagamento;
import br.edu.infnet.javainjecaopersistenciaemprestimos.repository.PagamentoRepository;

@Service
public class PagamentoService {
	
	@Autowired
	private EmprestimoService emprestimoService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;

	public void save(Pagamento pagamento) {
		pagamentoRepository.save(pagamento);
	}

	public Pagamento getPagamento(int pagamentoId) {
		return pagamentoRepository.findById(pagamentoId).get();
	}
	
	public List<Pagamento> getByEmprestimo(Emprestimo emprestimo){
		return pagamentoRepository.findByEmprestimo(emprestimo);
	}

	public void pagar(Pagamento pagamentoAtualizado) {
		
		Pagamento pagamentoAPagar = getPagamento(pagamentoAtualizado.getId());
		pagamentoAPagar.setObservacoes(pagamentoAtualizado.getObservacoes());
		
		Emprestimo emprestimo = emprestimoService.getEmprestimo(pagamentoAPagar.getEmprestimo().getId());
		
		Integer parcelasPagas = emprestimo.getParcelasPagas();
		parcelasPagas++;
		emprestimo.setParcelasPagas(parcelasPagas);
		
		Cliente cliente = emprestimo.getCliente();
		cliente.efetuarPagamento(pagamentoAPagar);
		
		pagamentoAPagar.setPago(true);
		
		boolean quitado = getByEmprestimo(emprestimo).stream().allMatch(p -> p.isPago());
		emprestimo.setQuitado(quitado);
		
		pagamentoRepository.save(pagamentoAPagar);
		emprestimoService.save(emprestimo);
		clienteService.save(cliente);
		
	}

}
