package org.example.grupo;

public class Grupo {
	private int id;
	private String horarioAula;
	private String nome;
	private int limiteAlunos;

	public Grupo(int id, String horarioAula, String nome, int limiteAlunos) {
		super();
		this.id = id;
		this.horarioAula = horarioAula;
		this.nome = nome;
		this.limiteAlunos = limiteAlunos;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHorarioAula() {
		return horarioAula;
	}

	public void setHorarioAula(String horarioAula) {
		this.horarioAula = horarioAula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getLimiteAlunos() {
		return limiteAlunos;
	}

	public void setLimiteAlunos(int limiteAlunos) {
		this.limiteAlunos = limiteAlunos;
	}
	
	public void consultarAlunosInscritos() {
		
	}
    public void adicionarAlunos() {
    	
    }
    public void removerAlunos() {
    	
    	
    }
    public String toString() {
    	return "Id: " + getId() + "\nHorário da aula: " + getHorarioAula() + "\nNome: " + getNome() + "\nLimite de alunos: " + getLimiteAlunos();
}
}
