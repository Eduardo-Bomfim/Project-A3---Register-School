package org.example.entidades.coordenador;

import org.example.entidades.Usuario;

import java.util.List;

public class Coordenador extends Usuario {

    private String areaCoordenacao;

    public Coordenador(long id, long registroAcademico, String nome, String email, String senha, String areaCoordenacao) {
        super(id, registroAcademico, nome, email, senha);
        this.areaCoordenacao = areaCoordenacao;
    }

    public String getAreaCoordenacao() {
        return areaCoordenacao;
    }

    public void setAreaCoordenacao(String areaCoordenacao) {
        this.areaCoordenacao = areaCoordenacao;
    }

    public List consultarUsuarios(){
        return null;
    }

    public List consultarDisciplinas(){
        return null;
    }

    public List consultarGrupos(){
        return null;
    }

    public List consultarSalas(){
        return null;
    }
    
    public void definirLimitesAlunosSala(){}

    public void gerarRelatório(){}
    
}
