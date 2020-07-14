package br.edu.infnet.javainjecaopersistenciaemprestimos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmprestimoController {
	
	
	@GetMapping(value = "/")
    public String getMainPage(Model model) {
		return "principal";
    }

}
