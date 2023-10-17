package ar.com.educacionit.desafios.desafio3;

public class Operario {
	
	public boolean autorizar(ObjetoVolador objetoVolador) {
		return objetoVolador.getTieneTripulacion() || objetoVolador.getLlevaPasajeros();
	}

}
