package org.example.utilitarios;

import java.time.LocalDateTime;

public class Valores {

    // Atributos da classe Valores
    private double valorAula;
    private String dataHora;

    // Construtor da classe Valores
    public Valores(double valorAula, String dataHora){
        this.valorAula = valorAula;
        this.dataHora = dataHora;
    }

    // Métodos getters e setters
    public double getValorAula() {
        return valorAula;
    }

    public void setValorAula(double valorAula) {
        this.valorAula = valorAula;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    // Método para definir o valor e a data/hora de uma aula
    public void valorPorAula(int dataHora, double valorAula){
        setDataHora(getDataHora());
        setValorAula(getValorAula());
    }

    // Método toString para representar os valores como uma string
    @Override
    public String toString() {
        return "Valores{" +
                "valorAula=" + valorAula +
                ", dataHora=" + dataHora +
                '}';
    }
}