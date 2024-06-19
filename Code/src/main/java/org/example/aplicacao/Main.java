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

    private final Registro registro;
    private final Unidade unidade;
    private final Scanner sc;
    private final Grupo grupo = null;
    private final Disciplina disciplina = null;

    public Main() {
        this.registro = new Registro(1);
        this.unidade = new Unidade(1, "UNIFACS", "Tancredo Neves", "7199999-9999", "36888999-87", (short) 5);
        this.sc = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Main app = new Main();
        app.run();
    }

    public void run() {
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

    private void cadastrarCoordenador() {
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

        switch (opcao) {
            case 1 -> areaAtuacao = Area.CIENCIAS_HUMANAS;
            case 2 -> areaAtuacao = Area.CIENCIAS_DA_NATUREZA;
            case 3 -> areaAtuacao = Area.LINGUAGENS;
            case 4 -> areaAtuacao = Area.EXATAS;
            default -> throw new IllegalStateException("Opção inválida!");
        }

        registro.cadastroUsuario(new Coordenador(1, 1, nome, email, senha, areaAtuacao));
    }

    private void cadastrarProfessor() {
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

        switch (opcao) {
            case 1 -> areaAtuacao = Area.CIENCIAS_HUMANAS;
            case 2 -> areaAtuacao = Area.CIENCIAS_DA_NATUREZA;
            case 3 -> areaAtuacao = Area.LINGUAGENS;
            case 4 -> areaAtuacao = Area.EXATAS;
            default -> throw new IllegalStateException("Opção inválida!");
        }

        registro.cadastroUsuario(new Professor(2, 12, nome, email, senha, areaAtuacao));
    }

    private void cadastrarAluno() {
        System.out.println("Digite o seu nome: ");
        String nome = sc.next();
        System.out.println("Digite o seu email: ");
        String email = sc.next();
        System.out.println("Digite a senha: ");
        String senha = sc.next();

        registro.cadastroUsuario(new Aluno(3, 123, nome, email, senha));
    }

    private Usuario loginUsuario() {
        System.out.println("Digite o seu email: ");
        String email = sc.next();
        System.out.println("Digite a sua senha: ");
        String senha = sc.next();

        return registro.autenticarUsuario(email, senha);
    }

    private void telaLogin() {
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

    private void menuCoordenador(Coordenador coordenador) {
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

            switch (opcao) {
                case 1 -> {
                    coordenador.criarSala(unidade, 1, (short) 1, (short) 5, (short) 1, "Laboratório");
                    coordenador.criarSala(unidade, 2, (short) 2, (short) 5, (short) 1, "Sala de Aula");
                }
                case 2 -> {coordenador.criarGrupo(unidade, 1, "7° Ano", "Matutino", "120");
                    coordenador.criarGrupo(unidade, 2, "9° Ano", "Vespertino", "160");}
                case 3 -> { coordenador.criarDisciplinas(unidade, 1, "Matemática", "120987", "120", "Matutino", "Equa" +
                        "ção 2° grau");
                    coordenador.criarDisciplinas(unidade, 2, "Geografia", "130977", "160", "Vespertino", "Equação 1° " +
                            "grau");}
                case 4 -> System.out.println(coordenador.exibirDisciplinas(unidade));
                case 5 -> System.out.println(coordenador.exibirSalas(unidade));
                case 6 -> System.out.println(coordenador.exibirGrupos(unidade));
                case 7 -> coordenador.gerarRelatório(unidade);
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 9);
    }

    private void menuProfessor(Professor professor) {
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

            switch (opcao) {
                case 1 -> System.out.println(professor.consultarDisciplinasMinistradas(unidade));
                case 2 -> System.out.println(professor.consultarGrupos(unidade));
                case 3 -> professor.definirValoresAulas(2, 30);
                case 4 -> System.out.println(professor.consultarAlunosInscritos(grupo));
                case 5 -> mudarAreaProfessor(professor);
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 9);
    }

    private void mudarAreaProfessor(Professor professor) {
        System.out.println("""
                Informe qual a sua área de atuação: 
                | 1 - Ciências Humanas
                | 2 - Ciências da Natureza
                | 3 - Linguagens
                | 4 - Exatas
                """);
        int opcao = sc.nextInt();
        Area areaAtuacao;

        switch (opcao) {
            case 1 -> areaAtuacao = Area.CIENCIAS_HUMANAS;
            case 2 -> areaAtuacao = Area.CIENCIAS_DA_NATUREZA;
            case 3 -> areaAtuacao = Area.LINGUAGENS;
            case 4 -> areaAtuacao = Area.EXATAS;
            default -> throw new IllegalStateException("Opção inválida!");
        }
        professor.setArea(areaAtuacao);
    }

    private void menuAluno(Aluno aluno) {
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

            switch (opcao) {
                case 1 -> System.out.println(aluno.consultarDisciplinas(unidade));
                case 2 -> System.out.println(aluno.consultarGrupos(unidade));
                case 3 -> aluno.realizarInscricaoGrupo(grupo, aluno);
                case 4 -> aluno.cancelarInscricaoGrupo(grupo, aluno);
                case 5 -> aluno.realizarMatriculaDisciplina(disciplina);
                case 6 -> aluno.cancelarMatriculaDisciplina(disciplina);
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 9);
    }
}
