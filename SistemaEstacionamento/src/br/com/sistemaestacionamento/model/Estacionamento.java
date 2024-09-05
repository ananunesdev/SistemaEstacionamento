package br.com.sistemaestacionamento.model;

import javax.print.attribute.standard.DateTimeAtCompleted;

public class Estacionamento {
	private Integer id; 
	private String placa;
	private Float valor; 
	private String status;
	private DateTimeAtCompleted entrada;
	public DateTimeAtCompleted getEntrada() {
		return entrada;
	}
	public void setEntrada(DateTimeAtCompleted entrada) {
		this.entrada = entrada;
	}
	public DateTimeAtCompleted getSaida() {
		return saida;
	}
	public void setSaida(DateTimeAtCompleted saida) {
		this.saida = saida;
	}
	private DateTimeAtCompleted saida;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public Float getValor() {
		return valor;
	}
	public void setValor(Float valor) {
		this.valor = valor;
	}

}
