package org.example.utilitarios;

import java.time.LocalDateTime;

public class Valores {

	private int id;
	private double valorAula;
	private String dataHora;

	public Valores(int id, double valorAula, String dataHora) {
		this.id = id;
		this.valorAula = valorAula;
		this.dataHora = dataHora;
	}

	public String getDataHora() {
		return dataHora;
	}

	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}

	public double getValorAula() {
		return valorAula;
	}

	public void setValorAula(double valorAula) {
		this.valorAula = valorAula;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void consultarValorAula() {
	}

	public String toString() {
		return "Id: " + getId() + "\nValor da aula: " + getValorAula() + "\nHora da aula: " + getDataHora(); 
	}
}
