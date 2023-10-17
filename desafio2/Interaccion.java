package ar.com.educacionit.desafios.desafio2;

import java.util.Scanner;

public class Interaccion {
	private static float promedioBase;
	
	public static int getCantidad(Scanner teclado, String entidad) {
		System.out.println("Indique cantidad de "+entidad);
		return teclado.nextInt();
	}
	
	public static void cargarAlumnos(int maxAlumnos, int maxNotas, Alumno[] alumnos, Scanner teclado) {
		
		for(int i = 0 ; i < maxAlumnos ; i++) {
			//carga de un alumno:
			System.out.println("Nombre: ");
			String nombreAlumno = teclado.next();
			System.out.println("Apellido: ");
			String apellidoAlumno = teclado.next();
			
			Alumno alumno = new Alumno(nombreAlumno, apellidoAlumno);
			
			//carga de sus examenes
			for(int j = 0 ; j < maxNotas; j++) {
				System.out.println("Examen nro.: ");
				short examenNro = teclado.nextShort();
				System.out.println("Nota: ");
				float nota = teclado.nextFloat();
				
				Examen examen = new Examen(examenNro, nota);
				
				alumno.agregarExamen(examen);
			}
			
			//agrego el alumno cargado al vector de alumnos
			alumnos = resizeAlumnos(alumnos);
			alumnos[alumnos.length-1] = alumno;
			
		}
		
	}
	
	public static Alumno[] cargarAlumnos(int maxAlumnos, int maxNotas, Scanner teclado) {
		Alumno[] alumnos = new Alumno[0];
		for(int i = 0 ; i < maxAlumnos ; i++) {
			//carga de un alumno:
			System.out.println("Nombre: ");
			String nombreAlumno = teclado.next();
			System.out.println("Apellido: ");
			String apellidoAlumno = teclado.next();
			
			Alumno alumno = new Alumno(nombreAlumno, apellidoAlumno);
			
			//carga de sus examenes
			for(int j = 0 ; j < maxNotas; j++) {
				System.out.println("Examen nro.: ");
				short examenNro = teclado.nextShort();
				System.out.println("Nota: ");
				float nota = teclado.nextFloat();
				
				Examen examen = new Examen(examenNro, nota);
				
				alumno.agregarExamen(examen);
			}
			
			//agrego el alumno cargado al vector de alumnos
			alumnos = resizeAlumnos(alumnos);
			alumnos[alumnos.length-1] = alumno;
			
		}
		return alumnos;
		
	}
	
	private static Alumno[] resizeAlumnos(Alumno[] alumnos) {
		var auxAlumnos = new Alumno[alumnos.length +1];
		
		for(int i = 0 ; i< alumnos.length ; i++) {
			auxAlumnos[i] = alumnos[i];
		}
		
		return auxAlumnos;
	}
	
	private static void mostrarAlumnos(String titulo, Alumno[] alumnos) {
		System.out.println(titulo);
		
		for (Alumno alumno : alumnos) {
			System.out.println(alumno);
		}
	}
	
	public static void mostrarResultados(Alumno[] alumnos) {
		Alumno[] mejoresAlumnos = Calculadora.obtenerMejoresAlumnos(alumnos);
		mostrarAlumnos("1- alumno/s con la calificación más alta", mejoresAlumnos);
		Alumno[] peoresAlumnos = Calculadora.obtenerPeoresAlumnos(alumnos);
		mostrarAlumnos("2- alumno/s con la calificación más baja", peoresAlumnos);
		Alumno[] promocionados = Calculadora.obtenerPromocionados(alumnos,promedioBase);
		mostrarAlumnos("3-alumnos que promocionan", promocionados);
		Alumno[] recursantes = Calculadora.obtenerRecursantes(alumnos,promedioBase);
		mostrarAlumnos("4- alumnos que deben recursar la materia", recursantes);
	}
	
	public static void setPromedioBase(float nota) {
		promedioBase = nota;
	}

}
