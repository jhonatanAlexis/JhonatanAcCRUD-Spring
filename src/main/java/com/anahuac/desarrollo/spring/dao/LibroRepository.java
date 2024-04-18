package com.anahuac.desarrollo.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anahuac.desarrollo.spring.entidades.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer>{
	//metodo para encontrar el libro por el nombre
	Libro findByNombre(String nombre);
	//metodo para encontrar el libro por el isbn
	Libro findByIsbn(String isbn);
	//metodo para ver si ya existe el isbn
	boolean existsByIsbn(String isbn);
}
