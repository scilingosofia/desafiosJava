package ar.com.educacionit.desafios.desafio2;

public class Examen {
	private short numero;
	private float nota;
	
	public Examen(short numero, float nota) {
		this.numero = numero;
		this.nota = nota;
	}
	
	public short getNumero() {
		return numero;
	}
	public float getNota() {
		return nota;
	}
}
