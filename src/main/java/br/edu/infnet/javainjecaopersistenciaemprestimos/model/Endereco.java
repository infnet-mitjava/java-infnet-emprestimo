package br.edu.infnet.javainjecaopersistenciaemprestimos.model;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

	private String estado;
	private String cidade;
	private String bairro;
	private String cep;
	private String rua;
	private String numero;
}
