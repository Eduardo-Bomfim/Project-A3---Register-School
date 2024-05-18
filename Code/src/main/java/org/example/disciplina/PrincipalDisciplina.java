package org.example.disciplina;

public class PrincipalDisciplina {

	public static void main(String[] args) {

		Disciplina disciplina01 = new Disciplina(0, "Arthur","1234", "Trinta horas", "Matutino", "Guerra Mundial" );

		System.out.println("ID: " + disciplina01.getId());
		System.out.println("Nome do aluno: " + disciplina01.getNome());
		System.out.println("Código da disciplina: "+ disciplina01.getCodigo());
		System.out.println("Carga hóraria: " + disciplina01.getCargaHoraria());
		System.out.println("Turno: " + disciplina01.getTurno());
		System.out.println("Assunto: " + disciplina01.getAssuntos());

	}

}
