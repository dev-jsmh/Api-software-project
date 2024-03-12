/*

Developed by Jhonatan Samuel Martinez Hernandez year 2024


 */
package jhonatan.decoramor.clients;

import java.util.ArrayList;
import java.util.List;
import jhonatan.decoramor.service.ServiceModel;
import jhonatan.decoramor.service.ServiceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jhonatan Samuel Martinez Hernandez year 2024
 */
@RestController
@RequestMapping("/Api/v1/clients")
public class ClientController {

    private final ClientService clientService;
    private final ServiceService serviceService;

    public ClientController(ClientService clientService, ServiceService serviceService) {
        this.clientService = clientService;
        this.serviceService = serviceService;
    }

// ---------------------------------------------------------------------
// Get a list of all existing clients
    @GetMapping
    public List<ClientModel> getAll() {

        try {
            return clientService.getAllClients();

        } catch (Exception e) {
            throw new RuntimeException("Error al consultar la lista cliente. " + e.getMessage());
        }

    }
    // get all the purchased services for a specific client
    @GetMapping("/{client_id}/services")
    public ArrayList<ServiceModel> getAllclientPurchasedServices(
            @PathVariable("client_id") Long client_id 
    )
    {

        try {
            return clientService.clientPurchasedServices(client_id);

        } catch (Exception e) {
            throw new RuntimeException("Error al consultar la lista cliente. " + e.getMessage());
        }

    }
    
// ---------------------------------------------------------------------
// create a new client
 @PostMapping
    public ClientModel saveClient(@RequestBody ClientModel client) {
        try {
            return clientService.CreateClient(client);
        } catch (Exception e) {
            throw new RuntimeException("Error al crear el cliente. " + e.getMessage());
        }
    }
    
// ---------------------------------------------------------------------
// create or save a new service for a client
    @PostMapping("/{client_id}/services")
    public ClientModel addServiceToClient(
            @RequestBody ServiceModel newservice,
            @PathVariable Long client_id)
    {
        try {
            return clientService.addServiceToClient(newservice, client_id);
            
        } catch (Exception e) {
            throw new RuntimeException("Error al crear el cliente. " + e.getMessage());
        }
    }
}
