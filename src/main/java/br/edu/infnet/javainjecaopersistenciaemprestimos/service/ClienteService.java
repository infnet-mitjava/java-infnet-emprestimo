package br.edu.infnet.javainjecaopersistenciaemprestimos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.javainjecaopersistenciaemprestimos.model.Cliente;
import br.edu.infnet.javainjecaopersistenciaemprestimos.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	

	public List<Cliente> getClientes() {
		return clienteRepository.findAll();
	}

	public void save(Cliente cliente) {
		clienteRepository.save(cliente);
	}

	public Cliente getCliente(int id) {
		return clienteRepository.findById(id).get();
	}

}
