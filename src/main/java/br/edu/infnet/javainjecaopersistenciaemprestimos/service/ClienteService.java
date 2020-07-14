package br.edu.infnet.javainjecaopersistenciaemprestimos.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.infnet.javainjecaopersistenciaemprestimos.model.Cliente;
import br.edu.infnet.javainjecaopersistenciaemprestimos.model.Endereco;

@Service
public class ClienteService {
	
	private List<Cliente> clientes = new ArrayList<>();
	
	public ClienteService () {
		clientes.add(new Cliente(2, "Marcos", new Endereco("RJ", "RJ", "RJ" , "654321","rua tres", "2"), 1000.33));
		clientes.add(new Cliente(1, "Thiago", new Endereco("RJ", "SG", "NEVES" , "123456", "rua dois","1"), 200.33));
	}

	public List<Cliente> getClientes() {
		
		return clientes;
	}

	public void save(Cliente cliente) {
		clientes.add(cliente);
	}

	public Cliente getCliente(int parseInt) {
		return clientes.get(0);
	}

}
