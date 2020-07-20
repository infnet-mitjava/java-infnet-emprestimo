package br.edu.infnet.javainjecaopersistenciaemprestimos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.javainjecaopersistenciaemprestimos.model.Coletor;
import br.edu.infnet.javainjecaopersistenciaemprestimos.repository.ColetorRepository;

@Service
public class ColetorService {

	@Autowired
	private ColetorRepository coletorRepository;
	

	public List<Coletor> getColetores() {
		return coletorRepository.findAll();
	}

	public void save(Coletor coletor) {
		coletorRepository.save(coletor);
	}

	public Coletor getColetor(int id) {
		return coletorRepository.findById(id).get();
	}

}
