package co.edu.utp.misiontic.sebas.videomarket.Service;

import java.util.List;
import co.edu.utp.misiontic.sebas.videomarket.Controller.dto.UserRequest;
import co.edu.utp.misiontic.sebas.videomarket.Controller.dto.UserResponse;

public interface SecurityService {

    public UserResponse validateUser(String username, String password);

    List<UserResponse> getAllUsers();

    public UserResponse getUserByUsername(String username);

    public void createUser(UserRequest user);

    public void updateUser(UserRequest user);

    public void deleteUser(String username);

    public void activateUser(String username);

    public void inactivateUser(String username);
}
