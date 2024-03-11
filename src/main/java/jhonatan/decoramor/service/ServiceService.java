package jhonatan.decoramor.service;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jhonatan samuel Martinez Hernandez
 */

/*
This service class has all the logic refered to services, allowing us 
to create, find, select, delete, edit data of a group of services or a specific one
 */
@Service
public class ServiceService {

    // Create a field for the repository interface
    private final IServiceRepository serviceRepository;

    // Make here a dependency injection of the service repository
    public ServiceService(IServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;

    }

        // ---------------------------------------------------------------------

    // Gets a list of services with tits respective information
    public List<ServiceModel> getAllServices() {
        try {
            return this.serviceRepository.findAll();
        }
        catch(Exception e){
        throw new RuntimeException("Fallo al devolvel la lista de servicios. " + e.getMessage());
        }

    }
    // ---------------------------------------------------------------------
// create or save a new service for a client
    public ServiceModel createService( ServiceModel service) {
        try{
           return this.serviceRepository.save(service);
        }
        catch(Exception e){
        throw new RuntimeException("Error al crear el servicio ingresado. " + e.getMessage());
        }

    }
}
