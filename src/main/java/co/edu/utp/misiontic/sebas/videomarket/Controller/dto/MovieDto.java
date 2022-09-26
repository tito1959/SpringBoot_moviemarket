package co.edu.utp.misiontic.sebas.videomarket.Controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {

    private Integer id;
    private String name;
    private Integer categoryId;
    private String description;
    private Integer duration;
    private String imageUrl;
}
