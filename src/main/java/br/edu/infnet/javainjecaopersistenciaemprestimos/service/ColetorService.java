package br.edu.infnet.javainjecaopersistenciaemprestimos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.infnet.javainjecaopersistenciaemprestimos.model.Coletor;

@Service
public class ColetorService {

private List<Coletor> coletores = new ArrayList<>();
	
	public ColetorService () {
		coletores.add(new Coletor(1 , "Nome Coletor"));
		coletores.add(new Coletor(2 , "Nome Coletor 2"));
	}

	public List<Coletor> getColetores() {
		return coletores;
	}

	public void save(Coletor coletor) {
		coletores.add(coletor);
	}

	public Coletor getColetor(int coletorId) {
		return coletores.get(0);
	}

}
