
<%@ include file="header.jsp"%>

<body>

	<div class="container">
		<br>
		<h3>Empr�stimos</h3>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Cliente</th>
					<th scope="col">Coletor</th>
					<th scope="col">Data</th>
					<th scope="col">Vencimento</th>
					<th scope="col">Montante</th>
					<th scope="col">Juros</th>
					<th scope="col">Parcelas</th>
					<th scope="col">Parcelas Quitadas</th>
					<th scope="col">Quitado</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="emprestimo" items="${emprestimos }">
					<tr>
						<th scope="row">${emprestimo.id }</th>
						<td>${emprestimo.cliente.nome }</td>
						<td>${emprestimo.coletor.nome }</td>
						<td>${emprestimo.dataEmprestimo }</td>
						<td>${emprestimo.diaVencimento }</td>
						<td>${emprestimo.montante }</td>
						<td>${emprestimo.taxaDeJuro }</td>
						<td>${emprestimo.numeroParcelas }</td>
						<td>${emprestimo.parcelasPagas }</td>
						<td>${emprestimo.quitado }</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>

		<br>

		<h3>Novo Empr�stimo</h3>

		<form method="POST" modelAttribute="emprestimo">

			<div class="form-group">
				<label for="cliente">Cliente</label> <select name="clienteId"
					class="form-control">
					<option value="">..</option>
					<c:forEach var="cliente" items="${clientes}">
						<option value="${cliente.id}">${cliente.nome}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="coletor">Coletor</label> <select name="coletorId"
					class="form-control">
					<option value="">..</option>
					<c:forEach var="coletor" items="${coletores}">
						<option value="${coletor.id}">${coletor.nome}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="nome">Data</label> <input type="date"
					class="form-control" id="data" name="strData"
					 placeholder="Data do empr�stimo">
			</div>
			
			<div class="form-group">
				<label for="nome">Dia de Vencimento</label> <input type="number"
					class="form-control" id="diaVencimento" name="diaVencimento"
					 placeholder="Dia de Vencimento">
			</div>
			
			<div class="form-group">
				<label for="nome">Montante</label> <input type="text"
					class="form-control" id="montante" name="montante"
					 placeholder="Valor">
			</div>
			
			<div class="form-group">
				<label for="nome">Taxa de Juros Simples</label> <input type="text"
					class="form-control" id="taxaDeJuro" name="taxaDeJuro"
					 placeholder="Taxa De Juro">
			</div>
			
			<div class="form-group">
				<label for="nome">Quantidade de parcelas</label> <input type="number"
					class="form-control" id="numeroParcelas" name="numeroParcelas"
					 placeholder="Quantidade de Parcelas">
			</div>

			<button type="submit" class="btn btn-primary">Cadastrar</button>
		</form>



	</div>
</body>


<%@ include file="footer.jsp"%>
