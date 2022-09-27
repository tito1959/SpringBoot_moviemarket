package co.edu.utp.misiontic.sebas.videomarket.Model.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.utp.misiontic.sebas.videomarket.Model.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findAllByCategoryId(Long categoryId);
}
