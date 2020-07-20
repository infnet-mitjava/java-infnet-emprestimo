package br.edu.infnet.javainjecaopersistenciaemprestimos.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "emprestimo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emprestimo { 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "coletor_id")
	private Coletor coletor;
	
	private Date dataEmprestimo;
	private Integer diaVencimento;
	private Double montante;
	private Double taxaDeJuro;
	private Integer numeroParcelas;
	private Integer parcelasPagas;
	private boolean quitado;
	
	private Double total;
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<Pagamento> pagamentos  = new ArrayList<>();

	public Emprestimo(Integer id, Cliente cliente, Coletor coletor, Date dataEmprestimo, Integer diaVencimento,
			Double montante, Double taxaDeJuro, Integer numeroParcelas, Integer parcelasPagas, boolean quitado,
			List<Pagamento> pagamentos) {
		this.id = id;
		this.cliente = cliente;
		this.coletor = coletor;
		this.dataEmprestimo = dataEmprestimo;
		this.diaVencimento = diaVencimento;
		this.montante = montante;
		this.taxaDeJuro = taxaDeJuro;
		this.numeroParcelas = numeroParcelas;
		this.parcelasPagas = parcelasPagas;
		this.quitado = quitado;
		this.pagamentos = pagamentos;
	}
	
}
