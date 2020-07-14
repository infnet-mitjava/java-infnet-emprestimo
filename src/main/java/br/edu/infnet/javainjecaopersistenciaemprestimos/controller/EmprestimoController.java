package br.edu.infnet.javainjecaopersistenciaemprestimos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.edu.infnet.javainjecaopersistenciaemprestimos.model.Emprestimo;
import br.edu.infnet.javainjecaopersistenciaemprestimos.service.ClienteService;
import br.edu.infnet.javainjecaopersistenciaemprestimos.service.ColetorService;
import br.edu.infnet.javainjecaopersistenciaemprestimos.service.EmprestimoService;

@Controller
public class EmprestimoController {
	
	@Autowired 
	private ClienteService clienteService;
	
	@Autowired
	private ColetorService coletorService;
	
	@Autowired
	private EmprestimoService emprestimoService;
	
	static int i = 0;
	
	@GetMapping(value = "/")
    public ModelAndView getMainPage() {
		
		ModelAndView modelAndView = new ModelAndView("principal");
		
		modelAndView.addObject("clientes", clienteService.getClientes());
		modelAndView.addObject("coletores", coletorService.getColetores());
		modelAndView.addObject("emprestimos", emprestimoService.getEmprestimos());
		
		
		return modelAndView;
    }
	
	
	@PostMapping(value = "/")
	public ModelAndView add(@ModelAttribute Emprestimo emprestimo, @RequestParam String clienteId, @RequestParam String coletorId, @RequestParam String strData) {
		
		System.out.println(clienteId);
		System.out.println(coletorId);
		System.out.println(strData);
		
		emprestimo.setCliente(clienteService.getCliente(Integer.parseInt(clienteId)));
		
		emprestimo.setColetor(coletorService.getColetor(Integer.parseInt(coletorId)));
		
		emprestimo.setIdTransacao(i++);

		ModelAndView modelAndView = new ModelAndView("principal");

		emprestimoService.save(emprestimo, strData);
		
		modelAndView.addObject("clientes", clienteService.getClientes());
		modelAndView.addObject("coletores", coletorService.getColetores());
		modelAndView.addObject("emprestimos", emprestimoService.getEmprestimos());

		return modelAndView;
	}

}
