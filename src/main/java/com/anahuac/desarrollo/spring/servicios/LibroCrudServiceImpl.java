package com.anahuac.desarrollo.spring.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anahuac.desarrollo.spring.dao.LibroRepository;
import com.anahuac.desarrollo.spring.entidades.Libro;

@Service
public class LibroCrudServiceImpl implements LibroCrudService{
	@Autowired
	private LibroRepository libroRepository;
	
	public List<Libro> findAll(){
		return libroRepository.findAll();
	}
	
	public Libro agregar(Libro _libro) {
		return libroRepository.save(_libro);
	}
	
	public void eliminar(int _id) {
		libroRepository.deleteById(_id);
	}
	
	public Optional<Libro> obtenerUsuario(Integer _id){
		return libroRepository.findById(_id);
	}
	
	public Libro obtenerLibro(String nombre) {
		return libroRepository.findByNombre(nombre);
	}
	
	public Libro obtenerIsbn(String isbn) {
		return libroRepository.findByIsbn(isbn);
	}
	
	public boolean existeIsbn(String isbn) {
		return libroRepository.existsByIsbn(isbn);
	}
}
