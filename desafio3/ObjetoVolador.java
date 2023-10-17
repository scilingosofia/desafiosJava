package ar.com.educacionit.desafios.desafio3;

public abstract class ObjetoVolador {
	
	private boolean tieneTripulacion;
	private boolean llevaPasajeros;

	
	public void volar() {
		System.out.println("Volando...");
	}


	public ObjetoVolador(boolean tieneTripulacion, boolean llevaPasajeros) {
		super();
		this.tieneTripulacion = tieneTripulacion;
		this.llevaPasajeros = llevaPasajeros;
	}


	public boolean getTieneTripulacion() {
		return tieneTripulacion;
	}


	public boolean getLlevaPasajeros() {
		return llevaPasajeros;
	}
	
	
}
