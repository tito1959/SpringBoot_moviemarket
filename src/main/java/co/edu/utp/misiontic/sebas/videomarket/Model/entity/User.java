package co.edu.utp.misiontic.sebas.videomarket.Model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String username;
    private String password;
    private String name;
    @Column(unique = true)
    private String email;
    private Boolean active;
    private Boolean admin;
}
