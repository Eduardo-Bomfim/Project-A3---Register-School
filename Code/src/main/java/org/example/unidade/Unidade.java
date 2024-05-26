package org.example.unidade;

import org.example.exception.unchecked.ELimiteExcedidoException;
import org.example.sala.Sala;

import java.util.ArrayList;

public class Unidade {

    private long id;
    private String nome;
    private String bairro;
    private String telefone;
    private String cnpj;
    private short limiteSala;
    private ArrayList<Sala> salas;

    public Unidade(long id, String nome, String bairro, String telefone, String cnpj, short limiteSala) {
        this.id = id;
        this.nome = nome;
        this.bairro = bairro;
        this.telefone = telefone;
        this.cnpj = cnpj;
        this.limiteSala = limiteSala;
        salas = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    //Métodos

    public void adicionarSala(Sala sala){
        if (limiteSala < salas.size()){
            salas.add(sala);
        }else{
            throw new ELimiteExcedidoException("A unidade já atingiu o limite de salas.");
        }
    }

    public Sala consultarSalas(){
        for (Sala sala : salas){
            return sala;
        }
        return null;
    }
}
