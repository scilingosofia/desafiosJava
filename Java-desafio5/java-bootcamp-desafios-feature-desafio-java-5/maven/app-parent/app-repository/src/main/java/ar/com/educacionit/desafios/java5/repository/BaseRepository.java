package ar.com.educacionit.desafios.java5.repository;

import java.util.Optional;

public interface BaseRepository<T> {
	public void save(T Entity);
	public Optional<T> getById(Long id);
}
