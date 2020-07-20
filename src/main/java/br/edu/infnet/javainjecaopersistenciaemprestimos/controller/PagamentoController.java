package br.edu.infnet.javainjecaopersistenciaemprestimos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.edu.infnet.javainjecaopersistenciaemprestimos.model.Emprestimo;
import br.edu.infnet.javainjecaopersistenciaemprestimos.model.Pagamento;
import br.edu.infnet.javainjecaopersistenciaemprestimos.service.EmprestimoService;
import br.edu.infnet.javainjecaopersistenciaemprestimos.service.PagamentoService;

@Controller
public class PagamentoController {

	@Autowired
	private PagamentoService pagamentoService;
	
	@Autowired
	private EmprestimoService emprestimoService;
	
	@GetMapping(value = "/pagamentos")
    public ModelAndView getPagamentos(@RequestParam("emprestimoId") int emprestimoId) {
		
		Emprestimo emprestimo = emprestimoService.getEmprestimo(emprestimoId);
		List<Pagamento> pagamentos = pagamentoService.getByEmprestimo(emprestimo);
		
		ModelAndView modelAndView = new ModelAndView("pagamentos");
		
		modelAndView.addObject("pagamentos", pagamentos);
		modelAndView.addObject("emprestimo", emprestimo);
		
		return modelAndView;
    }
	
	@GetMapping(value = "/pagamento")
    public ModelAndView getPagamento(@RequestParam("pagamentoId") int pagamentoId) {
		
		ModelAndView modelAndView = new ModelAndView("pagamento");
		
		modelAndView.addObject("pagamento", pagamentoService.getPagamento(pagamentoId));
		
		return modelAndView;
    }
	
	@PostMapping(value = "/pagamento")
    public ModelAndView pagar(Pagamento pagamento) {
		
		ModelAndView modelAndView = new ModelAndView("redirect:/");
		
		pagamentoService.pagar(pagamento);
		
		return modelAndView;
    }
}
