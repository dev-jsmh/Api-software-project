package jhonatan.decoramor.service;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author samuel
 */
@RestController
@RequestMapping(value="/Api/v1/services")
public class ServiceController {

    private final ServiceService serviceService;

    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

// ---------------------------------------------------------------------
// get a list of all exiting services 
    @GetMapping
    public List<ServiceModel> getAllServices() {
        try {
            return serviceService.getAllServices();
        } catch (Exception e) {
            throw new RuntimeException("Error al crear el cliente. " + e.getMessage());
        }
    }

}
