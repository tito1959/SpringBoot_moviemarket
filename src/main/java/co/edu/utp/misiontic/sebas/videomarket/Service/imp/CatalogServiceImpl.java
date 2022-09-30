package co.edu.utp.misiontic.sebas.videomarket.Service.imp;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import co.edu.utp.misiontic.sebas.videomarket.Controller.dto.CategoryDto;
import co.edu.utp.misiontic.sebas.videomarket.Controller.dto.ContactDto;
import co.edu.utp.misiontic.sebas.videomarket.Controller.dto.MovieDto;
import co.edu.utp.misiontic.sebas.videomarket.Model.entity.Contact;
import co.edu.utp.misiontic.sebas.videomarket.Model.repository.CategoryRepository;
import co.edu.utp.misiontic.sebas.videomarket.Model.repository.ContactRepository;
import co.edu.utp.misiontic.sebas.videomarket.Model.repository.MovieRepository;
import co.edu.utp.misiontic.sebas.videomarket.Service.CatalogService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CatalogServiceImpl implements CatalogService {

    private final CategoryRepository categoryRepository;
    private final MovieRepository movieRepository;
    private final ContactRepository contactRepository;

    @Override
    public List<CategoryDto> getCategories() {
        var categories = categoryRepository.findAll(Sort.by("name"));

        return categories.stream()
                .map(data -> new CategoryDto(data.getName(), data.getId().intValue()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CategoryDto> getCategoryById(Integer id) {
        var category = categoryRepository.findById(id.longValue());

        if (category.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(new CategoryDto(category.get().getName(), category.get().getId().intValue()));
    }

    @Override
    public List<MovieDto> getMoviesByCategoryId(Integer categoryId) {

        var movies = movieRepository.findAllByCategoryId(categoryId.longValue());

        var categoryMovies = movies.stream()
                .map(movie -> MovieDto.builder()
                        .id(movie.getCode().intValue())
                        .duration(movie.getLenght())
                        .name(movie.getName())
                        .description(movie.getDescription())
                        .imageUrl(movie.getImageUrl())
                        .build())
                .collect(Collectors.toList());
        return categoryMovies;
    }

    @Override
    public void saveContact(ContactDto contact) {
        var entity = new Contact();
        entity.setDate(new Date());
        entity.setName(contact.getName());
        entity.setEmail(contact.getEmail());
        entity.setSubject(contact.getSubject());
        entity.setMessage(contact.getMessage());

        contactRepository.save(entity);
    }

}
