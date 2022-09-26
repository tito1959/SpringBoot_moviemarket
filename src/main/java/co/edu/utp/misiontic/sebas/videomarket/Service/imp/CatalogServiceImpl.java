package co.edu.utp.misiontic.sebas.videomarket.Service.imp;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import co.edu.utp.misiontic.sebas.videomarket.Controller.dto.CategoryDto;
import co.edu.utp.misiontic.sebas.videomarket.Controller.dto.MovieDto;
import co.edu.utp.misiontic.sebas.videomarket.Service.CatalogService;

@Service
public class CatalogServiceImpl implements CatalogService {

    private final List<CategoryDto> categories = Arrays.asList(
            new CategoryDto("Action", 1),
            new CategoryDto("Comedy", 2),
            new CategoryDto("Romance", 3),
            new CategoryDto("Sci-fi", 4));

    private final List<MovieDto> movies = Arrays.asList(
            new MovieDto(1, "Matrix", 4, "Best of the best", 120, "Matrix"),
            new MovieDto(2, "light Year", 4, "Clasic saga toy story", 120, "null"),
            new MovieDto(3, "El señor de los anillos", 4, "The ring lost come back", 180, "null"));

    @Override
    public List<CategoryDto> getCategories() {
        return categories;
    }

    @Override
    public Optional<CategoryDto> getCategoryById(Integer id) {
        var category = categories.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
        return category;
    }

    @Override
    public List<MovieDto> getMoviesByCategoryId(Integer categoryId) {
        var categoryMovies = movies.stream()
                .filter(m -> m.getCategoryId().equals(categoryId))
                .collect(Collectors.toList());
        return categoryMovies;
    }

}
