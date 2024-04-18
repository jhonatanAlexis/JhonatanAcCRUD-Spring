package com.anahuac.desarrollo.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.anahuac.desarrollo.spring.entidades.Libro;
import com.anahuac.desarrollo.spring.servicios.LibroCrudService;

@Controller
public class LibroController {
	@Autowired
	public LibroCrudService usuarioService;
	
	@GetMapping(value="/inicio")
	public String findAll(Model modelo) {
		modelo.addAttribute("html_libros", usuarioService.findAll());
		return "index";
	}
	
	@RequestMapping(value="/libro/nuevo")
	public String agregar(Model modelo) {
		Libro libro = new Libro();
		modelo.addAttribute("libro", libro);
		return "add-user";
	}
	
	@RequestMapping(value="/añadirLibro", method = RequestMethod.POST)
	public String addBook(@ModelAttribute("libro") Libro libro, Model modelo) {
		boolean isbnExists = usuarioService.existeIsbn(libro.getIsbn());
		//si el isbn ya existe no se agrega el libro
		if(isbnExists == true) {
			modelo.addAttribute("error", "Ya exiiste el ibsn"); //lanza un mensaje de error si ya existe el isbn
		}else {
			usuarioService.agregar(libro);
			return "redirect:/inicio"; //si si se pudo agregar (no existia ese isbn) hace refresh a la pagina o sea te devuelve al inicio
		}
		return "add-user"; //si ya existia el isbn se queda en la pestaña de agregar usuario
	}
	
	@RequestMapping(value="/delete/{id}")
	public String eliminar(@PathVariable Integer id) {
		usuarioService.eliminar(id);
		return "redirect:/inicio";
	}
	
	@GetMapping(value="/edit/{id}")
	public String editar(@PathVariable Integer id, Model modelo) {
		modelo.addAttribute("libro", usuarioService.obtenerUsuario(id));
		return "add-user";
	}
	
	//metodo para encontrar el libro por su nombre
	@GetMapping(value="/obtenerLibro/{nombre}")
	public String findNombre(@PathVariable String nombre,Model modelo) {
		modelo.addAttribute("html_libros", usuarioService.obtenerLibro(nombre));
		return "index";
	}
	
	//metodo para encontrar el libro por su isbn
	@GetMapping(value="/obtener/{isbn}")
	public String findIsbn(@PathVariable String isbn, Model modelo) {
		modelo.addAttribute("html_libros", usuarioService.obtenerIsbn(isbn));
		return "index";
	}
}
