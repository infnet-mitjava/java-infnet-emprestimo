package br.edu.infnet.javainjecaopersistenciaemprestimos.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.infnet.javainjecaopersistenciaemprestimos.model.Emprestimo;

@Service
public class EmprestimoService {
	
	private List<Emprestimo> emprestimos = new ArrayList<>();

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void save(Emprestimo emprestimo, String strData) {
		
		Date myDate = criaData(strData);  
		
		emprestimo.setData(myDate);
		
		emprestimos.add(emprestimo);
		
	}

	private Date criaData(String strData) {
		Date myDate = null;
		
		try {
			myDate = new SimpleDateFormat("yyyy-MM-dd").parse(strData);
		} catch (ParseException e) {
			myDate = new Date();
		}
		return myDate;
	}
	

}
