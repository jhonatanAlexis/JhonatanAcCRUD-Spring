package com.anahuac.desarrollo.spring.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Libros")
public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	@Column(name = "nombre", nullable = false)
	private String nombre;
	@Column(name = "autor", nullable = false)
	private String autor;
	@Column(name = "isbn", nullable = false)
	private String isbn;
	
	public Libro() {
		
	}
	
	public Libro(int _id, String _nombre, String _autor, String _isbn) {
		this.id = _id;
		this.nombre = _nombre;
		this.autor = _autor;
		this.isbn = _isbn;
	}
	
	public Libro(String _nombre, String _autor, String _isbn) {
		this.nombre = _nombre;
		this.autor = _autor;
		this.isbn = _isbn;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getAutor() {
		return this.autor;
	}
	
	public String getIsbn() {
		return this.isbn;
	}
	
	public void setId(int _id) {
		this.id = _id;
	}
	
	public void setNombre(String _nombre) {
		this.nombre = _nombre;
	}
	
	public void setAutor(String _autor) {
		this.autor = _autor;
	}
	
	public void setIsbn(String _isbn) {
		this.isbn = _isbn;
	}
}
