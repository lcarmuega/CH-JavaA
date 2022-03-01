package com.desafio1.Desafio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

@SpringBootApplication
public class PeliculasApplication implements CommandLineRunner {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(PeliculasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.createTables();

		this.insertData();

		this.listData();
	}

	private void createTables() {
		// Nos aseguramos de que las tablas no existan
		jdbcTemplate.execute("DROP TABLE IF EXISTS movie_actors");
		jdbcTemplate.execute("DROP TABLE IF EXISTS categories");
		jdbcTemplate.execute("DROP TABLE IF EXISTS movies");
		jdbcTemplate.execute("DROP TABLE IF EXISTS actors");

		// Creamos la tabla de categorias
		String CreateSQLTableCategories = "CREATE TABLE categories(id serial NOT NULL, category varchar NULL, CONSTRAINT category_pkey PRIMARY KEY(id))";
		jdbcTemplate.execute(CreateSQLTableCategories);

		// Creamos la tabla de peliculas
		String CreateSQLTableMovies = "CREATE TABLE movies(id serial NOT NULL, name_movie varchar NULL, " +
				" release_date DATE, category_id Integer, CONSTRAINT movie_pkey PRIMARY KEY(id), FOREIGN KEY (category_id) REFERENCES categories(id))";
		jdbcTemplate.execute(CreateSQLTableMovies);

		// Creamos la tabla de actores
		String CreateSQLTableActors = "CREATE TABLE actors(id serial NOT NULL, name_actor varchar NULL, CONSTRAINT actor_pkey PRIMARY KEY(id))";
		jdbcTemplate.execute(CreateSQLTableActors);

		// Creamos la tabla de relacion entre actores y peliculas
		String CreateSQLTableMovieActor = "CREATE TABLE movie_actor(id_movie INTEGER NOT NULL, id_actor INTEGER NOT NULL, " +
				"PRIMARY KEY(id_movie,id_actor), FOREIGN KEY(id_movie) REFERENCES movies(id), FOREIGN KEY(id_actor) REFERENCES actors(id))";
		jdbcTemplate.execute(CreateSQLTableMovieActor);
	}

	private void insertData(){
		// Insertamos registros en la tabla de categorias
		String insertFirstCategory = "INSERT INTO categories VALUES(1,'Accion')";
		jdbcTemplate.execute(insertFirstCategory);

		String insertSecondCategory = "INSERT INTO categories VALUES(2,'Romance')";
		jdbcTemplate.execute(insertSecondCategory);

		// Insertamos registros en la tabla de peliculas
		String insertFirstMovie = "INSERT INTO movies VALUES(1,'Spider-Man: No Way Home','2021-12-15', 1)";
		jdbcTemplate.execute(insertFirstMovie);

		String insertSecondMovie = "INSERT INTO movies VALUES(2,'Pride and Prejudice','2005-11-25', 2)";
		jdbcTemplate.execute(insertSecondMovie);

		// Insertamos registros en la tabla de actores
		String insertFirstActor = "INSERT INTO actors VALUES(1,'Tom Holland')";
		jdbcTemplate.execute(insertFirstActor);

		String insertSecondActor = "INSERT INTO actors VALUES(2, 'Keira Knightley')";
		jdbcTemplate.execute(insertSecondActor);

		// Insertamos registros en la tabla de relacion entre actores y peliculas
		String insertFirstMovieActor = "INSERT INTO movie_actor VALUES(1,1)";
		jdbcTemplate.execute(insertFirstMovieActor);

		String insertSecondMovieActor = "INSERT INTO movie_actor VALUES(2,2)";
		jdbcTemplate.execute(insertSecondMovieActor);
	}

	private void listData(){
		String SQLView = "SELECT m.name_movie as movie, c.category as category, a.name_actor as actor " +
				"FROM movie_actor ma, movies m, actors a, categories c " +
				"WHERE m.id = ma.id_movie and a.id = ma.id_actor and m.category_id = c.id";

		List<String> data = new ArrayList<>();

		jdbcTemplate.query(SQLView, new Object[] {}, (rs, row) ->
						"Pelicula: " + rs.getString("movie") +
								", Categoria: "+ rs.getString("category") +
								", Actor: " + rs.getString("actor"))
				.forEach(movie -> data.add(movie));
		System.out.println(data);
	}
}
