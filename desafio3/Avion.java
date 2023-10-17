package ar.com.educacionit.desafios.desafio3;

public class Avion extends ObjetoVolador implements Aterrizable {

	public Avion(boolean tieneTripulacion, boolean llevaPasajeros) {
		super(tieneTripulacion, llevaPasajeros);
	}

	@Override
	public void aterrizar(Pista pista) {
		System.out.println("Avion aterrizando en "+ pista.getNombre());

	}

	@Override
	public String toString() {
		return "Avion";
	}
	
	
}
