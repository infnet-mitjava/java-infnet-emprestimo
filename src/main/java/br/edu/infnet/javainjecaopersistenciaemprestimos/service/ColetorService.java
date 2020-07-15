package br.edu.infnet.javainjecaopersistenciaemprestimos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.infnet.javainjecaopersistenciaemprestimos.model.Coletor;
import br.edu.infnet.javainjecaopersistenciaemprestimos.model.Endereco;

@Service
public class ColetorService {

private List<Coletor> coletores = new ArrayList<>();
	
	public ColetorService () {
		
		coletores.add(new Coletor(1 , "Nome Coletor", new Endereco("RJ", "RJ", "RJ" , "654321","rua tres", "2")));
		coletores.add(new Coletor(2 , "Nome Coletor 2", new Endereco("RJ", "RJ", "RJ" , "654321","rua tres", "2")));
	}
	
	public List<Coletor> getColetores() {
		return coletores;
	}

	public void save(Coletor coletor) {
		coletores.add(coletor);
	}

	public Coletor getColetor(Integer coletorId) {
		return coletores.get(0);
	}

}
