package br.edu.infnet.javainjecaopersistenciaemprestimos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.infnet.javainjecaopersistenciaemprestimos.model.Cliente;
import br.edu.infnet.javainjecaopersistenciaemprestimos.model.Endereco;
import br.edu.infnet.javainjecaopersistenciaemprestimos.service.ClienteService;

@Controller
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping(value = "/clientes")
	public ModelAndView getClientes() {

		ModelAndView modelAndView = new ModelAndView("clientes");

		List<Cliente> clientes = clienteService.getClientes();

		modelAndView.addObject("clientes", clientes);
		
		Cliente cliente = new Cliente();
		cliente.setEndereco(new Endereco());
		
		
		modelAndView.addObject("cliente" , cliente);

		return modelAndView;
	}

	@PostMapping(value = "/clientes")
	public ModelAndView add(@ModelAttribute Cliente cliente) {
		
		System.out.println(cliente);

		ModelAndView modelAndView = new ModelAndView("clientes");

		clienteService.save(cliente);
		
		List<Cliente> clientes = clienteService.getClientes();

		modelAndView.addObject("clientes", clientes);

		return modelAndView;
	}
}
