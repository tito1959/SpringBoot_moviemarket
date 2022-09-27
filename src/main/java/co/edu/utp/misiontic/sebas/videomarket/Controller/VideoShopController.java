package co.edu.utp.misiontic.sebas.videomarket.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import co.edu.utp.misiontic.sebas.videomarket.Service.CatalogService;
import lombok.AllArgsConstructor;

/*
 * Controlador dedicado a la navegación de toda la web
 */
@AllArgsConstructor
@Controller
public class VideoShopController {

    private CatalogService catalogService;

    @GetMapping("/catalog")
    public String goToCatalog(Model model) {
        var categories = this.catalogService.getCategories();

        model.addAttribute("name", "Bienvenidos a mi pagina");
        model.addAttribute("categories", categories);
        System.out.println(categories);
        return "catalog";
    }

    @GetMapping("/catalog/{id}")
    public String loadCatalogById(@PathVariable("id") Integer id, Model model) {

        var categoryOp = this.catalogService.getCategoryById(id);
        var categories = catalogService.getCategories();
        model.addAttribute("categories", categories);

        if (categoryOp.isEmpty()) {
            // trhows error
            model.addAttribute("error", "La categoria no existe");
        } else {

            var category = categoryOp.get();
            var categoryMovies = this.catalogService.getMoviesByCategoryId(id);

            model.addAttribute("name", category.getName());
            model.addAttribute("id", category.getId());
            model.addAttribute("movies", categoryMovies);
        }

        return "catalog";
    }

    @GetMapping("/contact")
    public String goToContact(Model model) {
        return "contact";
    }

    @GetMapping("/login")
    public String goToLogin(Model model) {
        return "login";
    }

}
