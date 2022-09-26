package co.edu.utp.misiontic.sebas.videomarket.Controller.dto;

public class CategoryDto {

    private String name;
    private Integer id;

    public CategoryDto() {
    }

    public CategoryDto(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
