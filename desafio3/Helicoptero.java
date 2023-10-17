package ar.com.educacionit.desafios.desafio3;

public class Helicoptero extends ObjetoVolador implements Aterrizable {

	public Helicoptero(boolean tieneTripulacion, boolean llevaPasajeros) {
		super(tieneTripulacion, llevaPasajeros);
	}

	@Override
	public void aterrizar(Pista pista) {
		System.out.println("Helicoptero aterrizando en " + pista.getNombre());

	}

	@Override
	public String toString() {
		return "Helicoptero";
	}
	
	

}
