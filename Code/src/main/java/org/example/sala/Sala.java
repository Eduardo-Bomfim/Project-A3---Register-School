package org.example.sala;

import org.example.exception.unchecked.EEstadoIlegalException;

public class Sala {

    // Atributos da classe Sala
    private long id;
    private int numero;
    private int capacidade;
    private int andar;
    private String tipoSala;
    private boolean disponibilidade;

    // Construtor da classe Sala
    public Sala(long id, int numero, int capacidade, int andar, String tipoSala){
        this.id = id;
        this.numero = numero;
        this.capacidade = capacidade;
        this.andar = andar;
        this.tipoSala = tipoSala;
        disponibilidade = true;
    }

    // Métodos getters e setters
    public long getId() {
        return id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public String getTipoSala() {
        return tipoSala;
    }

    public void setTipoSala(String tipoSala) {
        this.tipoSala = tipoSala;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    // Método para reservar uma sala
    public void reservar() {
        if (isDisponibilidade()) {
            setDisponibilidade(false);
        } else {
            throw new EEstadoIlegalException("Sala já está reservada.");
        }
    }

    // Método para cancelar a reserva de uma sala
    public void cancelarReserva() {
        if (!isDisponibilidade()) {
            setDisponibilidade(true);
        } else {
            throw new EEstadoIlegalException("Sala já está disponível.");
        }
    }
}