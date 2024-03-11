
package jhonatan.decoramor.service;

import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author samuel
 */
public class ServiceController {
    
    private final ServiceService serviceService;
    
    public ServiceController(ServiceService serviceService){
        this.serviceService = serviceService;
    }
     // ---------------------------------------------------------------------
// create or save a new service for a client
     public ServiceModel saveClient(@RequestBody ServiceModel newservice) {
        try {
            return serviceService.createService(newservice);
        } catch (Exception e) {
            throw new RuntimeException("Error al crear el cliente. " + e.getMessage());
        }
    }
}
