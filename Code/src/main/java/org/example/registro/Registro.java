package org.example.registro;

import org.example.entidades.Usuario;
import org.example.exception.unchecked.EEstadoIlegalException;
import org.example.exception.unchecked.EIdNaoEncontradoException;

import java.util.ArrayList;

public class Registro {

    private long id;
    private ArrayList<Usuario> usuarios;

    //Construtor
    public Registro(long id) {
        this.id = id;
        usuarios = new ArrayList<>();
    }

    //Getters e Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    //Método
    public void cadastroUsuario(Usuario usuario){
        if (usuario != null){
            usuarios.add(usuario);
        }
        throw new NullPointerException("As informações do usuário estão vazias.");
    }

    public void excluirUsuario(long id){
        for(Usuario usuario : usuarios){
            if(usuario.getId() == id){
                usuarios.remove(usuario);
            }
            throw new EIdNaoEncontradoException("Usuário não encontrado.");
        }
    }

    public Usuario consultarRegistroUsuarios(){
        if (!usuarios.isEmpty()){
            for(Usuario usuario : usuarios){
                return usuario;
            }
        }
        throw new EEstadoIlegalException("Nenhum usuário encontrado.");
    }
}
