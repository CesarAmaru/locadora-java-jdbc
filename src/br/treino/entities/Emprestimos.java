package br.treino.entities;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Emprestimos {
	private Integer id;
	private Cliente cliente;
	private Veiculo veiculo;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private Double valorTotal;
	private String status;
	
	public Emprestimos(){}
	public Emprestimos(Integer id, Cliente cliente, Veiculo veiculo, LocalDate dataInicio, LocalDate dataFim,
			String status) {
		this.id = id;
		this.cliente = cliente;
		this.veiculo = veiculo;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.status = status;
	}
	
	public Integer getId() {
		return id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public LocalDate getDataInicio() {
		return dataInicio;
	}
	public LocalDate getDataFim() {
		return dataFim;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public String getStatus() {
		return status;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}
	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setValorTotal() {
		Period periodo = Period.between(dataInicio, dataFim);
		this.valorTotal = veiculo.getBaseDailyFee() * periodo.getDays();
	}
	
	DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	@Override
	public String toString() {
		return String.format("id: %d | cliente-id: %d | veiculo-id: %d | data-inicio: %s | data-final: %s | valor total: %.2f | status: %s", 
				getId(), cliente.getId(), veiculo.getId(), getDataInicio().format(formatador), getDataFim().format(formatador), getValorTotal(), getStatus());
	}
	
}
