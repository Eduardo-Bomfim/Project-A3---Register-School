package org.example.entidades.aluno;

import org.example.entidades.Usuario;

public class Aluno extends Usuario {


    public Aluno(long id, long registroAcademico, String nome, String email, String senha) {
        super(id, registroAcademico, nome, email, senha);
    }
}
