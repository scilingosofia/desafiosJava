package ar.com.educacionit.desafios.desafio4;

public class MyCustomList<T extends Comparable<T>> implements CollectionCustom<T> {
	private int size;
	private Object[] values;
	
	MyCustomList(){
		this.size=0;
		this.values = new Object[0];
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public void addFirst(T item) {
		if(size == 0 && item !=null) {
			add(item);
		} else if(item != null) {
			Object[]aux = expand();
			for(int i = aux.length-1 ; i > 0 ; i--) {
				aux[i] = aux[i-1];
			}
			aux[0] = item;
			this.values = aux;
			size++;
		}
		
	}

	@Override
	public void addLast(T item) {
		if(item!=null) {
			add(item);					
		}
	}
	private Object[]expand(){
		Object[] copy = new Object[size+1];
		for(int i = 0 ; i < values.length ; i++) {
			copy[i] = values[i];
		}
		return copy;
	}

	@Override
	public void add(T item) {
		if (item !=null) {
			Object[]aux = expand();
			this.values = aux;
			values[size] = item;
			size ++;
		}		
	}
	
	private Object[] compressValuesFrom(int index) {
		Object[]aux = new Object[values.length-1];
		if(values.length>1) {
			int auxI = 0;
			int valuesI = 0;
			while(valuesI < values.length) {
				if(valuesI != index) {
					aux[auxI] = values[valuesI];
					auxI++;
				}
				
				valuesI++;
			}
		}
		return aux;
	}

	@Override
	public T remove(T item) {
		T foundValue = null;
		if (item !=null) {
			int iterator = 0;
			boolean found = false;
			while (!found &&iterator < values.length) {
				if(item.equals(values[iterator])){
					found = true;
				}
				iterator++;
			}
			if(found) {
				var index = iterator-1;
				foundValue = (T)values[index];
				values = compressValuesFrom(index);
				size--;
				
			} 
		}
		return foundValue;
	}

	@Override
	public void removeAll() {
		this.size = 0;
		Object[]aux = new Object[size];
		this.values = aux;
		return;
	}

	@Override
	public boolean empty() {
		return size == 0 ;
	}

}
