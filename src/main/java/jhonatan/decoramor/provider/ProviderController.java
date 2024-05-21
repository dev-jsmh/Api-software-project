/*
Developed by Jhonatan Samuel Martinez Hernandez year 2024
Software Analyst and Developer
 */
package jhonatan.decoramor.provider;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author samuel
 */
@RestController
@RequestMapping("/api/v1/providers")// localhost:8080/providers
public class ProviderController {

    private final ProviderService providerService;

    /*
    injected the class providerService that implements the functionality 0f business layer
    for providers in the contructor of the class as a dependencie
     */
    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }
// ========== get all providers ===========

    @GetMapping // localhost:8080/providers || Get method
    public List<ProviderModel> getAll() {
        /*
    funtion that call the provider service and returns a list of providers. 
    It is execute when making a get request to the url 
         */
        return this.providerService.getAllproviders();
    }

    // ========== get an specified provider ===========
    @GetMapping("/{id_provider}")
    public ProviderModel getProviderById(
            @PathVariable("id_provider") Long id_provider
    ) {
        // call the service and use it to get and object of the provider 
        return this.providerService.getById(id_provider);
    }

    // ========== create a new provider ===============
    @PostMapping
    public ProviderModel createNewProvider(@RequestBody ProviderModel newProvider) {
        return this.providerService.create(newProvider);
    }

    // ========== update an specified provider =========
    @PutMapping("/{id_provider}")
    public ProviderModel updateProviderById(
            @PathVariable("id_provider") Long id_provider,
            @RequestBody ProviderModel modProvider) {
        // Get object of the modify provider data from body
        // get the id variable from the url 
        // pass it to a function of the service
        return this.providerService.updateProvider(id_provider, modProvider);
    }

    // ========== delete an specified provider ==========
    @DeleteMapping("/{id_provider}")
    public void deleteProiverById(@PathVariable Long id_provider) {
        // call the service and use it to delete a specified provider by its id
        this.providerService.delete(id_provider);
    }
}
/*
Developed by Jhonatan Samuel Martinez Hernandez year 2024
Software Analyst and Developer
 */
