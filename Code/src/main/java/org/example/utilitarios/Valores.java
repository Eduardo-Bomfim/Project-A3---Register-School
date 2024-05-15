package org.example.utilitarios;

import java.time.LocalDateTime;

public class Valores {
    
    private long id;
    private double valorAula;
    private LocalDateTime dataHora;

    public Valores(long id, double valorAula, LocalDateTime dataHora) {
        this.id = id;
        this.valorAula = valorAula;
        this.dataHora = dataHora;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
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

    public void setId(long id) {
        this.id = id;
    }

    public void consultarValorAula(){}
}
