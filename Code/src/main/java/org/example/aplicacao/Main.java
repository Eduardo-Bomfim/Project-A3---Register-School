package org.example.aplicacao;

import org.example.disciplina.Disciplina;
import org.example.entidades.aluno.Aluno;
import org.example.entidades.coordenador.Area;
import org.example.entidades.coordenador.Coordenador;
import org.example.entidades.professor.Professor;
import org.example.entidades.usuario.Usuario;
import org.example.grupo.Grupo;
import org.example.registro.Registro;
import org.example.unidade.Unidade;

import java.util.Scanner;

public class Main {

    // Instância de Registro para gerenciar usuários
    static Registro registro = new Registro(1);
    // Instância de Unidade representando uma universidade
    static Unidade unidade = new Unidade(1L, "UNIFACS", "Tancredo Neves", "7199999-9999", "36888999-87", (short) 5);
    // Scanner para ler entradas do usuário
    static Scanner sc = new Scanner(System.in);
    // Instância de Grupo representando uma turma
    static Grupo grupo = new Grupo(1, "124567891", "Matutino", "08:30");
    //Instância de Disciplina representando uma materia
    static Disciplina disciplina = new Disciplina(1, "Geografia", "123", "120", "Matutino", "Globalização",
            Area.CIENCIAS_HUMANAS);

    public static void main(String[] args) {
        int menu1, menu2, menuCadastro;

        do {
            System.out.println("""
                    ------------------------------------------------
                    | 1 - Entrar
                    | 9 - Sair
                    ------------------------------------------------
                    """);
            menu1 = sc.nextInt();

            switch (menu1) {
                case 1 -> {
                    do {
                        System.out.println("""
                                ------------------------------------------------
                                | 1 - Cadastrar
                                | 2 - Login
                                | 9 - Voltar
                                ------------------------------------------------
                                """);
                        menu2 = sc.nextInt();

                        switch (menu2) {
                            case 1 -> {
                                System.out.println("""
                                        ------------------------------------------------
                                        | 1 - Coordenador
                                        | 2 - Aluno
                                        | 3 - Professor
                                        | 9 - Voltar
                                        ------------------------------------------------
                                        """);
                                menuCadastro = sc.nextInt();

                                // Chama métodos de cadastro baseados na escolha do usuário
                                switch (menuCadastro) {
                                    case 1 -> cadastrarCoordenador();
                                    case 2 -> cadastrarAluno();
                                    case 3 -> cadastrarProfessor();
                                }
                            }

                            case 2 -> telaLogin();
                        }
                    } while (menu2 != 9);
                }

                case 9 -> System.out.println("Saindo...");
                default -> System.out.println("Escolha uma opção válida!");
            }
        } while (menu1 != 9);

        sc.close();
    }

    // Método para cadastrar um coordenador
    static void cadastrarCoordenador() {
        System.out.println("Digite o seu nome: ");
        String nome = sc.next();
        System.out.println("Digite o seu email: ");
        String email = sc.next();
        System.out.println("Digite a senha: ");
        String senha = sc.next();

        System.out.println("""
                Informe qual a sua área de atuação: 
                | 1 - Ciências Humanas
                | 2 - Ciências da Natureza
                | 3 - Linguagens
                | 4 - Exatas
                """);
        int opcao = sc.nextInt();
        Area areaAtuacao;

        // Define a área de atuação com base na escolha do usuário
        switch (opcao) {
            case 1 -> areaAtuacao = Area.CIENCIAS_HUMANAS;
            case 2 -> areaAtuacao = Area.CIENCIAS_DA_NATUREZA;
            case 3 -> areaAtuacao = Area.LINGUAGENS;
            case 4 -> areaAtuacao = Area.EXATAS;
            default -> throw new IllegalStateException("Opção inválida!");
        }

        // Registra o coordenador no sistema
        registro.cadastroUsuario(new Coordenador(1, 12, nome, email, senha, areaAtuacao));
    }

    // Método para cadastrar um professor
    static void cadastrarProfessor() {
        System.out.println("Digite o seu nome: ");
        String nome = sc.next();
        System.out.println("Digite o seu email: ");
        String email = sc.next();
        System.out.println("Digite a senha: ");
        String senha = sc.next();
        System.out.println("""
                Informe qual a sua área de atuação: 
                | 1 - Ciências Humanas
                | 2 - Ciências da Natureza
                | 3 - Linguagens
                | 4 - Exatas
                """);
        int opcao = sc.nextInt();
        Area areaAtuacao;

        // Define a área de atuação com base na escolha do usuário
        switch (opcao) {
            case 1 -> areaAtuacao = Area.CIENCIAS_HUMANAS;
            case 2 -> areaAtuacao = Area.CIENCIAS_DA_NATUREZA;
            case 3 -> areaAtuacao = Area.LINGUAGENS;
            case 4 -> areaAtuacao = Area.EXATAS;
            default -> throw new IllegalStateException("Opção inválida!");
        }

        // Registra o professor no sistema
        registro.cadastroUsuario(new Professor(1, 12, nome, email, senha, areaAtuacao));
    }

    // Método para cadastrar um aluno
    static void cadastrarAluno() {
        System.out.println("Digite o seu nome: ");
        String nome = sc.next();
        System.out.println("Digite o seu email: ");
        String email = sc.next();
        System.out.println("Digite a senha: ");
        String senha = sc.next();

        // Registra o aluno no sistema
        registro.cadastroUsuario(new Aluno(1, 12, nome, email, senha));
    }

    // Método para autenticar um usuário
    static Usuario loginUsuario() {
        System.out.println("Digite o seu email: ");
        String email = sc.next();
        System.out.println("Digite a sua senha: ");
        String senha = sc.next();

        // Autentica o usuário
        return registro.autenticarUsuario(email, senha);
    }

    // Método que exibe a tela de login e redireciona para o menu apropriado
    static void telaLogin() {
        Usuario usuarioLogado = loginUsuario();
        if (usuarioLogado != null) {
            System.out.println("Login efetuado com sucesso!");

            if (usuarioLogado instanceof Coordenador) {
                menuCoordenador((Coordenador) usuarioLogado);
            } else if (usuarioLogado instanceof Professor) {
                menuProfessor((Professor) usuarioLogado);
            } else if (usuarioLogado instanceof Aluno) {
                menuAluno((Aluno) usuarioLogado);
            }
        } else {
            System.out.println("Credenciais Inválidas.");
        }
    }

    // Menu específico para coordenadores
    static void menuCoordenador(Coordenador coordenador) {
        int opcao;
        do {
            System.out.println("""
                    ----------------------------------------------------
                    | 1 - Criar salas
                    | 2 - Criar grupo
                    | 3 - Criar disciplinas
                    | 4 - Exibir disciplinas
                    | 5 - Exibir salas
                    | 6 - Exibir grupos
                    | 7 - Gerar relatório
                    | 9 - Voltar
                    ----------------------------------------------------
                    """);
            opcao = sc.nextInt();

            // Chama métodos do coordenador baseados na escolha do usuário
            switch (opcao) {
                case 1 -> coordenador.criarSala(unidade, 1, (short) 1, (short) 5, (short) 1, "Laboratório");
                case 2 -> coordenador.criarGrupo(unidade, 1, "7° Ano", "Matutino", "120");
                case 3 -> coordenador.criarDisciplinas(unidade, 1, "Matemática", "120987", "120", "Matutino", "Equação 2° grau", Area.EXATAS);
                case 4 -> coordenador.exibirDisciplinas(unidade);
                case 5 -> coordenador.exibirSalas(unidade);
                case 6 -> coordenador.exibirGrupos(unidade);
                case 7 -> coordenador.gerarRelatório(unidade);
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 9);
    }

    // Menu específico para professores
    static void menuProfessor(Professor professor) {
        int opcao;
        do {
            System.out.println("""
                    ----------------------------------------------------
                    | 1 - Consultar disciplinas ministradas
                    | 2 - Consultar grupos
                    | 3 - Definir valores das aulas
                    | 4 - Exibir alunos inscritos
                    | 5 - Mudar área
                    | 9 - Voltar
                    ----------------------------------------------------
                    """);
            opcao = sc.nextInt();

            // Chama métodos do professor baseados na escolha do usuário
            switch (opcao) {
                case 1 -> professor.consultarDisciplinasMinistradas(unidade);
                case 2 -> professor.consultarGrupos(unidade);
                case 3 -> professor.definirValoresAulas(2, 30);
                case 4 -> professor.consultarAlunosInscritos(grupo);
                case 5 -> mudarAreaProfessor(professor);
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 9);
    }

    // Método para mudar a área de atuação de um professor
    static void mudarAreaProfessor(Professor professor) {
        System.out.println("""
                Informe qual a sua área de atuação: 
                | 1 - Ciências Humanas
                | 2 - Ciências da Natureza
                | 3 - Linguagens
                | 4 - Exatas
                """);
        int opcao = sc.nextInt();
        Area areaAtuacao;

        // Define a nova área de atuação com base na escolha do usuário
        switch (opcao) {
            case 1 -> areaAtuacao = Area.CIENCIAS_HUMANAS;
            case 2 -> areaAtuacao = Area.CIENCIAS_DA_NATUREZA;
            case 3 -> areaAtuacao = Area.LINGUAGENS;
            case 4 -> areaAtuacao = Area.EXATAS;
            default -> throw new IllegalStateException("Opção inválida!");
        }
        professor.setArea(areaAtuacao);
    }

    // Menu específico para alunos
    static void menuAluno(Aluno aluno) {
        int opcao;
        do {
            System.out.println("""
                    ----------------------------------------------------
                    | 1 - Consultar disciplinas
                    | 2 - Consultar grupos
                    | 3 - Realizar inscrição no grupo
                    | 4 - Cancelar inscrição no grupo
                    | 5 - Realizar matricula na disciplina
                    | 6 - Cancelar matricula na disciplina
                    | 9 - Voltar
                    ----------------------------------------------------
                    """);
            opcao = sc.nextInt();

            // Chama métodos do aluno baseados na escolha do usuário
            switch (opcao) {
                case 1 -> aluno.consultarDisciplinas(unidade);
                case 2 -> aluno.consultarGrupos(unidade);
                case 3 -> aluno.realizarInscricaoGrupo(grupo, aluno);
                case 4 -> aluno.cancelarInscricaoGrupo(grupo, aluno);
                case 5 -> aluno.realizarMatriculaDisciplina(disciplina);
                case 6 -> aluno.cancelarMatriculaDisciplina(disciplina);
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 9);
    }
}
