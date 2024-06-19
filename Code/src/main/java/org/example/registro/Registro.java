package org.example.registro;

import org.example.entidades.aluno.Aluno;
import org.example.entidades.coordenador.Coordenador;
import org.example.entidades.professor.Professor;
import org.example.entidades.usuario.Usuario;
import org.example.exception.unchecked.EEstadoIlegalException;
import org.example.exception.unchecked.EIdNaoEncontradoException;

import java.util.ArrayList;

public class Registro {

    // Atributos da classe Registro
    private long id;
    private ArrayList<Usuario> usuarios;

    // Construtor da classe Registro
    public Registro(long id) {
        this.id = id;
        usuarios = new ArrayList<>();
    }

    // Métodos getters e setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    // Método para cadastrar um usuário
    public void cadastroUsuario(Usuario usuario) {
        if (usuario != null) {
            usuarios.add(usuario);
        }else {
            throw new NullPointerException("As informações do usuário estão vazias.");
        }
    }

    // Método para excluir um usuário com base no id
    public void excluirUsuario(long id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                usuarios.remove(usuario);
            }
        }
        throw new EIdNaoEncontradoException("Usuário não encontrado.");
    }

    // Método para procurar um usuário com base no id
    public Usuario procurarUsuario(long id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        throw new EEstadoIlegalException("Nenhum usuário encontrado com o ID informado.");
    }

    // Método para autenticar um usuário com base no email e senha
    public Usuario autenticarUsuario(String email, String senha){
        for (Usuario usuario : usuarios) {
            if (usuario.autenticar(email, senha)){
                return usuario;
            }
        }
        throw new EEstadoIlegalException("Nenhum usuario encontrado com e-mail ou senha informada.");
    }

    // Método para consultar coordenadores cadastrados
    public ArrayList<Coordenador> consultarCoordenadores() {
        if (!usuarios.isEmpty()) {
            ArrayList<Coordenador> coordenadores = new ArrayList<>();
            for (Usuario usuario : usuarios) {
                if (usuario instanceof Coordenador) {
                    coordenadores.add((Coordenador) usuario);
                }
            }
            return coordenadores;
        }
        throw new EEstadoIlegalException("Nenhum usuário cadastrado.");
    }

    // Método para consultar professores cadastrados
    public ArrayList<Professor> consultarProfessores() {
        if (!usuarios.isEmpty()) {
            ArrayList<Professor> professores = new ArrayList<>();
            for (Usuario usuario : usuarios) {
                if (usuario instanceof Professor) {
                    professores.add((Professor) usuario);
                }
            }
            return professores;
        }
        throw new EEstadoIlegalException("Nenhum usuário cadastrado.");
    }

    // Método para consultar alunos cadastrados
    public ArrayList<Aluno> consultarAlunos() {
        if (!usuarios.isEmpty()) {
            ArrayList<Aluno> alunos = new ArrayList<>();
            for (Usuario usuario : usuarios) {
                if (usuario instanceof Professor) {
                    alunos.add((Aluno) usuario);
                }
            }
            return alunos;
        }
        throw new EEstadoIlegalException("Nenhum usuário cadastrado.");
    }

    // Método para consultar o registro de usuários
    public Usuario consultarRegistroUsuarios() {
        if (!usuarios.isEmpty()) {
            for (Usuario usuario : usuarios) {
                return usuario;
            }
        }
        throw new EEstadoIlegalException("Nenhum usuário cadastrado.");
    }

    // Método para procurar um coordenador com base no id
    public Coordenador procurarCoordenador(long id){
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Coordenador && usuario.getId() == id){
                return (Coordenador) usuario;
            }
        }
        throw new EEstadoIlegalException("Nenhum coordenador encontrado.");
    }
}