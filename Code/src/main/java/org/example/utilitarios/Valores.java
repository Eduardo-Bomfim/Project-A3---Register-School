package org.example.utilitarios;

public class Valores {

    private double valorAula;
    private int dataHora;

    public Valores(double valorAula, int horas) {
        this.valorAula = valorAula;
        this.dataHora = dataHora;
    }

    public int getDataHora() {
        return dataHora;
    }

    public void setDataHora(int dataHora) {
        this.dataHora = dataHora;
    }

    public double getValorAula() {
        return valorAula;
    }

    public void setValorAula(double valorAula) {
        this.valorAula = valorAula;
    }

    public void valorPorAula(int datahora, double valorAula){
        this.dataHora = datahora;
        this.valorAula = valorAula;
    }

    @Override
    public String toString() {
        return "Valores{" +
                ", valor=" + valorAula +
                ", horas=" + dataHora +
                '}';
    }
}
