package ar.com.educacionit.desafios.desafio2;

public class Alumno {
	private String nombre;
	private String apellido;
	private Examen[] examenes;
	
	public Alumno(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.examenes = new Examen[0];
	}
	
	public void agregarExamen(Examen examen) {
		if (examen != null) {
			resizeExamenes();
			examenes[examenes.length-1] = examen;
		}
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public Examen[] getExamenes() {
		return examenes;
	}
	
	private void resizeExamenes() {
		var auxExamenes = new Examen[examenes.length +1];
		
		for(int i = 0 ; i< examenes.length ; i++) {
			auxExamenes[i] = examenes[i];
		}
		
		this.examenes = auxExamenes;
	}
	
	public float obtenerMenorNota() {
		float menor = 10;
		
		for (Examen examen : examenes) {
			if(examen.getNota() < menor) {
				menor = examen.getNota();
			}
		}
		
		return menor;
	}
	
	public float obtenerMayorNota(){
		float mayor = 0;
		
		for (Examen examen : examenes) {
			if(examen.getNota() > mayor) {
				mayor = examen.getNota();
			}
		}
		
		return mayor;
	}
	
	public float obtenerPromedio() {
		float promedio = 0;
		
		for (Examen examen : examenes) {
			promedio += examen.getNota();
		}
		
		return promedio/examenes.length;
	}
	
	public boolean promociona(float baseline) {
		return obtenerPromedio() >= baseline;
	}

	@Override
	public String toString() {
		return "Alumno: " + nombre + " " + apellido + ", menor nota: " + obtenerMenorNota()
				+ ", mayor nota: " + obtenerMayorNota() + ", promedio: " + obtenerPromedio();
	}
	
	
}
