package ar.com.educacionit.desafios.desafio3;

public class TorreDeControl {
	private Pista[] pistas;
	private Operario operario;
	
	TorreDeControl(Operario operario, Pista[]pistas){
		this.pistas = pistas;
		this.operario = operario;
	}
	
	public void controlar(ObjetoVolador[] objetosVoladores) {
		for (ObjetoVolador objetoVolador : objetosVoladores) {
			if(Aterrizable.class.isAssignableFrom(objetoVolador.getClass())) {
				((Aterrizable) objetoVolador).aterrizar(pistas[0]);
			} else {
				var puedeAterrizar = operario.autorizar(objetoVolador);
				informar(puedeAterrizar, objetoVolador, pistas[1]);
			}
		}
	}
	
	private void informar(boolean puedeAterrizar, ObjetoVolador objeto, Pista pista) {
		if(puedeAterrizar) {
			System.out.println("El " + objeto.toString() +" puede aterrizar en " + pista.getNombre());
		} else {
			System.out.println("El " + objeto.toString() +" no puede aterrizar." );
		}
		
	}
	

}
