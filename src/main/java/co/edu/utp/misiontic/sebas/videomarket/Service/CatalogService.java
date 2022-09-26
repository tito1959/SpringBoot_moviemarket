package co.edu.utp.misiontic.sebas.videomarket.Service;

import java.util.List;
import java.util.Optional;

import co.edu.utp.misiontic.sebas.videomarket.Controller.dto.CategoryDto;
import co.edu.utp.misiontic.sebas.videomarket.Controller.dto.MovieDto;

public interface CatalogService {

    public List<CategoryDto> getCategories();

    public Optional<CategoryDto> getCategoryById(Integer id); // Null pointer exception

    public List<MovieDto> getMoviesByCategoryId(Integer categoryId);
}
