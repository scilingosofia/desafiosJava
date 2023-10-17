package ar.com.educacionit.desafios.desafio4;

public interface CollectionCustom<T> {
	public int size();
	public void addFirst(T item);
	public void addLast(T item);
	public void add(T item);
	public T remove(T item);
	public void removeAll();
	public boolean empty();
}
