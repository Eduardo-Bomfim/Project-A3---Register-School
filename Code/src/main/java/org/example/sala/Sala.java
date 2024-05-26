package org.example.sala;

import org.example.exception.unchecked.EEstadoIlegalException;

public class Sala {

    private long id;
    private short numero;
    private short capacidade;
    private short andar;
    private String tipoSala;
    private boolean disponibilidade;

    public Sala(long id, short numero, short capacidade, short andar, String tipoSala) {
        this.id = id;
        this.numero = numero;
        this.capacidade = capacidade;
        this.andar = andar;
        this.tipoSala = tipoSala;
        disponibilidade = true;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public short getNumero() {
        return numero;
    }

    public void setNumero(short numero) {
        this.numero = numero;
    }

    public short getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(short capacidade) {
        this.capacidade = capacidade;
    }

    public short getAndar() {
        return andar;
    }

    public void setAndar(short andar) {
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

    public Sala reservar(){
        if(disponibilidade){
            disponibilidade = false;
        }else{
            throw new EEstadoIlegalException("A sala já está reservada.");
        }
        return null;
    }

    public void cancelarReserva(){
        if(!disponibilidade){
            disponibilidade = true;
        }else {
            throw new EEstadoIlegalException("A sala nunca foi reservada.");
        }
    }
}
