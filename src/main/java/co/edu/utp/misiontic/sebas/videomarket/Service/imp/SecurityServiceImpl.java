package co.edu.utp.misiontic.sebas.videomarket.Service.imp;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import co.edu.utp.misiontic.sebas.videomarket.Controller.dto.UserRequest;
import co.edu.utp.misiontic.sebas.videomarket.Controller.dto.UserResponse;
import co.edu.utp.misiontic.sebas.videomarket.Model.entity.User;
import co.edu.utp.misiontic.sebas.videomarket.Model.repository.UserRepository;
import co.edu.utp.misiontic.sebas.videomarket.Service.SecurityService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SecurityServiceImpl implements SecurityService {

    private final UserRepository userRepository;

    @Override
    public UserResponse validateUser(String username, String password) {

        // var userOp = userRepository.findById(username);

        // if (userOp.isEmpty()) {
        // throw new RuntimeException("Usuario no existente");
        // }

        // var user = userOp.get();

        // if (!user.getIsActive()) {
        // throw new RuntimeException("Usuario Inactivo");
        // }

        // if (!user.getPassword().equals(password)) {
        // throw new RuntimeException("Credenciales invalidas");
        // }

        var userOp = userRepository.findByUsernameAndPasswordAndActiveIsTrue(username, password);

        if (userOp.isEmpty()) {
            throw new RuntimeException("Usuario no existente");
        }

        var user = userOp.get();

        return UserResponse.builder()
                .username(user.getUsername())
                .name(user.getName())
                .email(user.getEmail())
                .admin(user.getAdmin())
                .build();
    }

    @Override
    public void createUser(UserRequest user) {

        var userOp = userRepository.findById(user.getUsername());

        if (userOp.isPresent()) {
            throw new RuntimeException("El usuario ya existe");
        }

        userOp = userRepository.findByEmail(user.getEmail());

        if (userOp.isPresent()) {
            throw new RuntimeException("El correo ingresado ya existe.");
        }

        var userDb = new User(); // nuevo obj de tipo userEnity

        userDb.setUsername(user.getUsername());
        userDb.setEmail(user.getPassword());
        userDb.setName(user.getName());
        userDb.setEmail(user.getEmail()); // Db es campo unico
        userDb.setActive(true);
        userDb.setAdmin(user.getAdmin());

        userDb = userRepository.save(userDb); // recibe dato de cual id genero, que puede usarse en otro proceso.
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> UserResponse.builder()
                        .username(user.getUsername())
                        .name(user.getName())
                        .email(user.getEmail())
                        .admin(user.getAdmin())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse getUserByUsername(String username) {
        var userOp = userRepository.findById(username);

        if (userOp.isEmpty()) {
            throw new RuntimeException("El usuario no existe");
        }

        var user = userOp.get();

        return UserResponse.builder()
                .username(user.getUsername())
                .name(user.getName())
                .email(user.getEmail())
                .admin(user.getAdmin())
                .build();
    }

    @Override
    public void updateUser(UserRequest user) {

    }

    @Override
    public void deleteUser(String username) {

    }

    @Override
    public void activateUser(String username) {
        var userOp = userRepository.findById(username);

        if (userOp.isEmpty()) {
            throw new RuntimeException("El usuario no existe");
        }

        var user = userOp.get(); // tambien devuelve un obj de tipo Entity
        user.setActive(true);
        userRepository.save(user);
    }

    @Override
    public void inactivateUser(String username) {

        var userOp = userRepository.findById(username);

        if (userOp.isEmpty()) {
            throw new RuntimeException("El usuario no existe");
        }

        var user = userOp.get(); // tambien devuelve un obj de tipo Entity
        user.setActive(false);
        userRepository.save(user);
    }

}
