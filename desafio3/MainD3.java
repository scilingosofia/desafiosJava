package ar.com.educacionit.desafios.desafio3;

public class MainD3 {

	public static void main(String[] args) {
		ObjetoVolador[] objetosVoladores = {new Avion(false, true), new Helicoptero(true, false), new OVNI(false, false), new Avion(false, true), new OVNI(true, false), new Helicoptero(false, true)};
		
		Pista[]pistas = {new Pista("Pista 1"), new Pista("Pista 2")};
		Operario operario = new Operario();
		TorreDeControl torre = new TorreDeControl(operario, pistas);
		
		torre.controlar(objetosVoladores);
		
	}

}
