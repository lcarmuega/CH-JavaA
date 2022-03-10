package com.desafio2.Desafio2;

import com.desafio2.Desafio2.entities.Autor;
import com.desafio2.Desafio2.entities.Categoria;
import com.desafio2.Desafio2.entities.Editorial;
import com.desafio2.Desafio2.entities.Libro;
import com.desafio2.Desafio2.services.AutorService;
import com.desafio2.Desafio2.services.CategoriaService;
import com.desafio2.Desafio2.services.EditorialService;
import com.desafio2.Desafio2.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BibliotecaApplication implements CommandLineRunner {

	@Autowired
	private AutorService autorService;

	@Autowired
	private EditorialService editorialService;

	@Autowired
	private CategoriaService categoriaService;

	@Autowired
	private LibroService libroService;

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {


		// Registro los autores
		Autor autor1 = new Autor("George Orwell");
		Autor autor2 = new Autor("Casey McQuiston");
		Autor autor3 = new Autor("Julia Quinn");
		Autor autor4 = new Autor("Karen M. McManus");
		Autor autor5 = new Autor("Dan Wells");
		autorService.createAutor(autor1);
		autorService.createAutor(autor2);
		autorService.createAutor(autor3);
		autorService.createAutor(autor4);
		autorService.createAutor(autor5);

		// Registro las editoriales
		Editorial editorial1 = new Editorial("Penguin");
		Editorial editorial2 = new Editorial("Planeta");
		editorialService.createEditorial(editorial1);
		editorialService.createEditorial(editorial2);

		// Registro las categorias
		Categoria categoria1 = new Categoria("Ciencia Ficción");
		Categoria categoria2 = new Categoria("Romance");
		Categoria categoria3 = new Categoria("Ficción Histórica");
		Categoria categoria4 = new Categoria("Misterio");
		Categoria categoria5 = new Categoria("Ficción Apocalíptica");
		categoriaService.createCategoria(categoria1);
		categoriaService.createCategoria(categoria2);
		categoriaService.createCategoria(categoria3);
		categoriaService.createCategoria(categoria4);
		categoriaService.createCategoria(categoria5);

		// Registro los libros
		Libro libro1 = new Libro("1984", autor1, editorial2, categoria1);
		Libro libro2 = new Libro("Red, White & Royal Blue", autor2, editorial1, categoria2);
		Libro libro3 = new Libro("The Duke and I", autor3, editorial1, categoria3);
		Libro libro4 = new Libro("One Of Us Is Lying", autor4, editorial1, categoria4);
		Libro libro5 = new Libro("Partials", autor5, editorial2, categoria5);
		libroService.createLibro(libro1);
		libroService.createLibro(libro2);
		libroService.createLibro(libro3);
		libroService.createLibro(libro4);
		libroService.createLibro(libro5);

		// Muestro por consola
		System.out.println("<------datos------>");

		System.out.println("<------Libros------>");
		System.out.println(libroService.getLibros());

		System.out.println("<------Autores------>");
		System.out.println(autorService.getAutores());

		System.out.println("<------Categorias------>");
		System.out.println(categoriaService.getCategorias());

		System.out.println("<------Editoriales------>");
		System.out.println(editorialService.getEditoriales());

		// Actualizamos los datos de un libro
		System.out.println("<------update------>");
		Libro libroNuevo = new Libro("One Last Stop", autor2, editorial1, categoria2);
		libroService.updateLibro(2L, libroNuevo);

		System.out.println("<------Libros------>");
		System.out.println(libroService.getLibros());


		// Borramos un autor
		System.out.println("<------delete------>");
		autorService.deleteAutor(1L);

		System.out.println("<------Autores------>");
		System.out.println(autorService.getAutores());

		System.out.println("<------Libros------>");
		System.out.println(libroService.getLibros());
	}
}
