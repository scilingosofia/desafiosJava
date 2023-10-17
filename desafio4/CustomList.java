package ar.com.educacionit.desafios.desafio4;


public class CustomList <T extends Comparable<T> >implements CollectionCustom<T> {
	//esta implementacion tiene problemas de casteo de Clases, no puedo instanciar
	//los valores sin hacer lo de la linea 12 pero luego rompe al tratar de operar...
	private T[] valores;
	private int size = 0;
	
	@SuppressWarnings("unchecked")
	public CustomList() {
		valores = (T[]) new Object[1];
		size = 1;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void addFirst(T item) {
		//agrega el item que viene por parametro a la lista en la primera posición
		if (item !=null && size == 0) {
			valores[0] = item;
			size = 1;
//			lastPos = 1;
			return;
		}
		
		if(item != null) {
			//redimensionar el array
			T[] nuevoArray = expandArray();
			
			//mover todos los elementos una posición
			
			for (int i = size -1 ; i > 0 ; i-- ) {
				nuevoArray[i] = nuevoArray[i-1];
			}
			
			nuevoArray[0] = item;
			size ++;
		}
		
		return;
		
	}
	
	private T[]expandArray(){
		//devuelve una copia del arreglo original con una posicion extra
		@SuppressWarnings("unchecked")
		T[] aux = (T[])new Object[size + 1];
		
		for(int i = 0 ; i < size ; i ++) {
			aux[i] = valores[i];
		}
		return aux;
	}

	@Override
	public void addLast(T item) {
		if(size == 0 && item!= null) {
			valores[0] = item;
			size = 1;
//			lastPos = 1;
			return;
		}
		
		if(item != null) {
			Object[] nuevoArray = expandArray();
			nuevoArray[nuevoArray.length -1] = item;
			size = nuevoArray.length;	
		}
	}

	@Override
	public void add(T item) {
		addLast(item);
	}

	@Override
	public T remove(T item) {
		if (item == null || size ==0) {
			return null;
		}
		
		boolean found = false;
		int i = 0;
		T valorBuscado = null;
		
		while(!found && i < size) {
			if(valores[i].equals(item)) {
				found = true;
				valorBuscado =(T) valores[i];
			}
			
			i++;
		}
		if(found) {
			int index = i-1;
			//desplazo todos los items existentes una posicion a la izquierda desde la posicion index
			
			while(i < size) {
				valores[index] = valores[i];
				i++;
				index++;
			}
			
			//redimensiono el arreglo restandole una posicion
			@SuppressWarnings("unchecked")
			T[] aux = (T[])new Object[size -1];
			
			//copio los valores 
			for(int j = 0 ; j < aux.length ; j++) {
				aux[j] = valores[j];
			}
			//actualizo valores
			valores = aux;
			//actualizo el size
			size --;
		}
		
		return valorBuscado;
	}

	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		return size == 0;
	}


}
