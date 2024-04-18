package com.anahuac.desarrollo.spring.servicios;

import java.util.List;
import java.util.Optional;

import com.anahuac.desarrollo.spring.entidades.Libro;

public interface LibroCrudService {
	public List<Libro> findAll();
	public Libro agregar(Libro _libro);
	public void eliminar(int _id);
	public Optional<Libro> obtenerUsuario(Integer _id);
	public Libro obtenerLibro(String nombre);
	public Libro obtenerIsbn(String isbn);
	public boolean existeIsbn(String isbn);
}
