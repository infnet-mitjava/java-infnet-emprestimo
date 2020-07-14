package br.edu.infnet.javainjecaopersistenciaemprestimos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.infnet.javainjecaopersistenciaemprestimos.service.ClienteService;

@Controller
public class ColetorController {

	
	@GetMapping(value = "/coletores")
    public ModelAndView getClientes(Model model) {
		
		ModelAndView modelAndView = new ModelAndView("coletores");
		
		return modelAndView;
    }
}
