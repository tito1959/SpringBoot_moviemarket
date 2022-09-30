package co.edu.utp.misiontic.sebas.videomarket.Model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.utp.misiontic.sebas.videomarket.Model.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByUsernameAndPasswordAndActiveIsTrue(String username, String password);

    Optional<User> findByEmail(String email);
}
