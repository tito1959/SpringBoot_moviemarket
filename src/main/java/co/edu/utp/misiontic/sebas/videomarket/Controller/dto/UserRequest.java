package co.edu.utp.misiontic.sebas.videomarket.Controller.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserRequest {

    private String username;
    private String password;
    private String name;
    private String email;
    private Boolean admin;
}
