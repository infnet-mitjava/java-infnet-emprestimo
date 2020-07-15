package br.edu.infnet.javainjecaopersistenciaemprestimos.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.javainjecaopersistenciaemprestimos.model.Cliente;
import br.edu.infnet.javainjecaopersistenciaemprestimos.model.Coletor;
import br.edu.infnet.javainjecaopersistenciaemprestimos.model.Emprestimo;
import br.edu.infnet.javainjecaopersistenciaemprestimos.model.Pagamento;

@Service
public class EmprestimoService {
	
	@Autowired 
	private ClienteService clienteService;
	
	@Autowired
	private ColetorService coletorService;
	
	@Autowired
	private PagamentoService pagamentoService;
	
	private List<Emprestimo> emprestimos = new ArrayList<>();

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void save(Emprestimo emprestimo, String strDataEmprestimo, String clienteId, String coletorId) {
		
		emprestimo.setQuitado(false);
		emprestimo.setParcelasPagas(0);
		
		Cliente cliente = clienteService.getCliente(Integer.parseInt(clienteId));
		emprestimo.setCliente(cliente);
		
		Coletor coletor = coletorService.getColetor(Integer.parseInt(coletorId));
		emprestimo.setColetor(coletor);
		
		cliente.addEmprestimo(emprestimo);
		coletor.getEmprestimos().add(emprestimo);
		
		Date myDate = criaData(strDataEmprestimo);  
		
		emprestimo.setDataEmprestimo(myDate);
		
		calculaJuros(emprestimo);
		
		emprestimos.add(emprestimo);
		
		emprestimo.getPagamentos().forEach(p -> System.out.println(p.getData() + " " + p.getMontanteAPagar()));
	}

	private void criaPagamentos(Emprestimo emprestimo, Double jurosAOMes) {
		
		List<Pagamento> pagamentos = new ArrayList<>();
		
		IntStream.rangeClosed(1, emprestimo.getNumeroParcelas()).forEach(n -> {
			
			Date dataParaOPagamento = calculaDataParaPagamento(n, emprestimo.getDiaVencimento(), emprestimo.getDataEmprestimo());
			
			Pagamento pagamento = new Pagamento(emprestimo, dataParaOPagamento,  emprestimo.getMontante() / emprestimo.getNumeroParcelas() + jurosAOMes, jurosAOMes, "", false);
			
			pagamentos.add(pagamento);
			pagamentoService.save(pagamento);
			
		});
		
		emprestimo.setPagamentos(pagamentos);
		
	}

	private Date calculaDataParaPagamento(int numeroParcela, Integer diaVencimento, Date dataEmprestimo) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(dataEmprestimo);
		cal.add(Calendar.MONTH, numeroParcela);
		cal.set(Calendar.DAY_OF_MONTH, diaVencimento);
		
		return cal.getTime();
	}

	private void calculaJuros(Emprestimo emprestimo) {
		
		Double jurosAOMes = emprestimo.getMontante() * emprestimo.getTaxaDeJuro();
		
		Double jurosTotal =  jurosAOMes * emprestimo.getNumeroParcelas();
		
		emprestimo.setMontante( emprestimo.getMontante() + jurosTotal);
		
		criaPagamentos(emprestimo, jurosAOMes);
		
		
		
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
