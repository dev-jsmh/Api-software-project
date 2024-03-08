package jhonatan.decoramor.provider;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author samuel
 */
@RestController
@RequestMapping("/Api/v1/providers")// localhost:8080/providers
public class ProviderController {

    private final ProviderService providerService;

    /*
    injected the class providerService that implements the functionality 0f business layer
    for providers in the contructor of the class as a dependencie
     */
    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    /*
    funtion that call the provider service and returns a list of providers. 
    It is execute when making a get request to the url 
    */
    @GetMapping // localhost:8080/providers || Get method
    public List<ProviderModel>getAll() {
        return providerService.getAllproviders();
    }
}
