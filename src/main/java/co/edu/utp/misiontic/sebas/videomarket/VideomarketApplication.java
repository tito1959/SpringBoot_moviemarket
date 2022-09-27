package co.edu.utp.misiontic.sebas.videomarket;

import java.util.Arrays;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import co.edu.utp.misiontic.sebas.videomarket.Model.entity.Category;
import co.edu.utp.misiontic.sebas.videomarket.Model.entity.Movie;
import co.edu.utp.misiontic.sebas.videomarket.Model.repository.CategoryRepository;
import co.edu.utp.misiontic.sebas.videomarket.Model.repository.MovieRepository;
import lombok.AllArgsConstructor;
import lombok.Data;

@SpringBootApplication
public class VideomarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideomarketApplication.class, args);
	}

	/*
	 * Command line runne = ejecuta un programa desde la linea de comandos: en este
	 * caso para alamacenar datos jdbc
	 */
	@Component // los componentes indican a spring que ejecutar
	@Data
	@AllArgsConstructor
	public static class DataLoader implements CommandLineRunner {

		private final CategoryRepository categoryRepository;
		private final MovieRepository movieRepository;

		@Override
		public void run(String... args) throws Exception {
			loadData();
		}

		private void loadData() {

			var scifi = categoryRepository.save(new Category("Sci-fi"));
			var romance = categoryRepository.save(new Category("Romance"));
			var comedy = categoryRepository.save(new Category("Comedy"));
			var action = categoryRepository.save(new Category("Action"));

			var categories = Arrays.asList(
					scifi,
					romance,
					comedy,
					action);

			categoryRepository.saveAll(categories);

			var movies = Arrays.asList(
					new Movie(001L, "Matrix", "Best of the best", 120, "Matrix", scifi),
					new Movie(002L, "Toy Story", "Best anime action", 180, "null", scifi),
					new Movie(003L, "Rambo", "Best of action and shooter", 229, "null", action),
					new Movie(004L, "One nigh in the museum", "Best of comedy animalistic", 120, "null", comedy));

			movieRepository.saveAll(movies);
		}

	}

}
