package br.edu.infnet.javainjecaopersistenciaemprestimos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.infnet.javainjecaopersistenciaemprestimos.model.Coletor;
import br.edu.infnet.javainjecaopersistenciaemprestimos.service.ColetorService;

@Controller
public class ColetorController {
	
	@Autowired
	private ColetorService coletorService;

	@GetMapping(value = "/coletores")
	public ModelAndView getColetores() {

		ModelAndView modelAndView = new ModelAndView("coletores");

		List<Coletor> coletores = coletorService.getColetores();

		modelAndView.addObject("coletores", coletores);
		
		Coletor coletor = new Coletor();
		
		modelAndView.addObject("coletor" , coletor);

		return modelAndView;
	}

	@PostMapping(value = "/coletores")
	public ModelAndView add(@ModelAttribute Coletor coletor) {

		ModelAndView modelAndView = new ModelAndView("coletores");
		coletorService.save(coletor);
		
		List<Coletor> coletores = coletorService.getColetores();
		modelAndView.addObject("coletores", coletores);

		return modelAndView;
	}
}
