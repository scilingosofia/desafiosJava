package ar.com.educacionit.desafios.desafio2;

public class Calculadora {
	public static Alumno[] obtenerMejoresAlumnos(Alumno[] alumnos) {
		float mejorNota = obtenerMejorNota(alumnos);
		Alumno[] mejoresAlumnos = obtenerAlumnosConMejorNota(alumnos, mejorNota);	
		
		return mejoresAlumnos;
	}
	
	public static Alumno[] obtenerPeoresAlumnos(Alumno[] alumnos) {
		float peorNota = obtenerPeorNota(alumnos);
		Alumno[] peoresAlumnos = obtenerAlumnosConPeorNota(alumnos, peorNota);	
		
		return peoresAlumnos;
	}
	
	private static float obtenerMejorNota(Alumno[] alumnos) {
		float mejorNota = 0;
		
		for (Alumno alumno : alumnos) {
			if(alumno.obtenerMayorNota() > mejorNota) {
				mejorNota = alumno.obtenerMayorNota();
			}

		}
		return mejorNota;
	}
	
	private static Alumno[] obtenerAlumnosConMejorNota(Alumno[] alumnos, float nota) {
		Alumno[] mejoresAlumnos = new Alumno[0];
		
		
		for (Alumno alumno : alumnos) {
			if(alumno.obtenerMayorNota() == nota) { 
				//si la mejor nota del alumno coincide con la nota buscada, 
				//redimensiono el vector usando un auxiliar
				Alumno[] alumnosAux = new Alumno[mejoresAlumnos.length+1];
				for(int i = 0 ; i < mejoresAlumnos.length ; i++) {
					alumnosAux[i] = mejoresAlumnos[i];
				}
				alumnosAux[alumnosAux.length-1] = alumno;
				
				mejoresAlumnos = alumnosAux;
			}
		}
		
		return mejoresAlumnos;
	}
	
	private static Alumno[] obtenerAlumnosConPeorNota(Alumno[] alumnos, float nota) {
		Alumno[] peoresAlumnos = new Alumno[0];
		
		
		for (Alumno alumno : alumnos) {
			if(alumno.obtenerMenorNota() == nota) { 
				//si la mejor nota del alumno coincide con la nota buscada, 
				//redimensiono el vector usando un auxiliar
				Alumno[] alumnosAux = new Alumno[peoresAlumnos.length+1];
				for(int i = 0 ; i < peoresAlumnos.length ; i++) {
					alumnosAux[i] = peoresAlumnos[i];
				}
				alumnosAux[alumnosAux.length-1] = alumno;
				
				peoresAlumnos = alumnosAux;
			}
		}
		
		return peoresAlumnos;
	}
	
	private static float obtenerPeorNota(Alumno[] alumnos) {
		float peorNota = 10;
		
		for (Alumno alumno : alumnos) {
			if(alumno.obtenerMenorNota() < peorNota) {
				peorNota = alumno.obtenerMenorNota();
			}

		}
		return peorNota;
	}

	public static Alumno[] obtenerPromocionados(Alumno[]alumnos, float baseline) {
		Alumno[] promocionados = new Alumno[0];
		
		for (Alumno alumno : alumnos) {
			if(alumno.promociona(baseline)) {
				Alumno[] auxPromocionados = new Alumno[promocionados.length +1];
				for(int i = 0 ; i < promocionados.length ; i++) {
					auxPromocionados[i] = promocionados[i];
				}
				auxPromocionados[auxPromocionados.length-1] = alumno;
				promocionados = auxPromocionados;
			}
		}
		
		return promocionados;
	}
	public static Alumno[] obtenerRecursantes(Alumno[]alumnos, float baseline) {
		Alumno[] recursantes = new Alumno[0];
		
		for (Alumno alumno : alumnos) {
			if(!alumno.promociona(baseline)) {
				Alumno[] auxRecursantes = new Alumno[recursantes.length +1];
				for(int i = 0 ; i < recursantes.length ; i++) {
					auxRecursantes[i] = recursantes[i];
				}
				auxRecursantes[auxRecursantes.length-1] = alumno;
				recursantes = auxRecursantes;
			}
		}
		
		return recursantes;
	}
}
