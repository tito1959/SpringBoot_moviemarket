package co.edu.utp.misiontic.sebas.videomarket.Model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.utp.misiontic.sebas.videomarket.Model.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}