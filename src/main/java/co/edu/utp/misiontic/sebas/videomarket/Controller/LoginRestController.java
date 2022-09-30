package co.edu.utp.misiontic.sebas.videomarket.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.utp.misiontic.sebas.videomarket.Controller.dto.LoginRequest;
import co.edu.utp.misiontic.sebas.videomarket.Service.SecurityService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/login")
public class LoginRestController {

    private final SecurityService securityService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        // if (request.getUsername().equals("admin") &&
        // request.getPassword().equals("123")) {
        // return ResponseEntity.ok("Usuario valido");
        // } else {
        // return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error
        // authenticating user");
        // }

        try {
            var response = securityService.validateUser(request.getUsername(),
                    request.getPassword());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
