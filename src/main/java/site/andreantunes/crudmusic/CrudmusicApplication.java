package site.andreantunes.crudmusic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import site.andreantunes.crudmusic.services.ArtistaRepository;

@SpringBootApplication
public class CrudmusicApplication implements CommandLineRunner {

	@Autowired
	private ArtistaRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(CrudmusicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		App app = new App(repo);
		app.menu();
	}
}
