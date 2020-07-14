package br.edu.infnet.javainjecaopersistenciaemprestimos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagamentoController {

	@GetMapping(value = "/pagamentos")
    public String getClientes(Model model) {
		return "pagamentos";
    }
}
