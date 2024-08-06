/*

Developed by Jhonatan Samuel Martinez Hernandez year 2024
Software Analyst and Developer


 */
package jhonatan.decoramor.clients;

import java.util.List;
import java.util.Set;
import jhonatan.decoramor.neighborhood.NeighborhoodModel;
import jhonatan.decoramor.service.ServiceModel;
import org.springframework.web.bind.annotation.CrossOrigin;
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
 * @author Jhonatan Samuel Martinez Hernandez year 2024
 */
//@CrossOrigin( origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(
            ClientService clientService) {
        this.clientService = clientService;
    }

// ---------------------------------------------------------------------
// Get a list of all existing clients
    @GetMapping
    public List<ClientDto> getAll() {

        try {
            return clientService.getAllClients();

        } catch (Exception e) {
            throw new RuntimeException("Error al consultar la lista cliente. " + e.getMessage());
        }

    }

    // return a specific client by its id
    @GetMapping("/{client_id}")
    public ClientModel getClientById(
            // Here i get the id variable from the url 
            @PathVariable("client_id") Long client_id
    ) {

        // call the service and use the method to get the specified client from the data base
        return this.clientService.getClientById(client_id);
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
    
   
// ==================== modify existing client data ==================== 
    
    @PutMapping("/{id}")
    public ClientModel modifyClient(
            @PathVariable("id") Long id,
            @RequestBody ClientModel modClient
    ){
        return this.clientService.modifyClient(id, modClient);
    }
    
// ========================= Delete existing client ======================== 
  @DeleteMapping("/{client_id}")
    public void deleteClient(@PathVariable Long client_id){
        this.clientService.deleteClient(client_id);
    }
    

// ---------------------------------------------------------------------
// create or save a new service for a client
    @PutMapping("/{client_id}/schedule-service")
    public ServiceModel scheduleServiceToClient(
            @RequestBody ServiceModel newservice,
            @PathVariable Long client_id) {
        try {
            return clientService.scheduleServiceToClient(newservice, client_id);

        } catch (Exception e) {
            throw new RuntimeException("Error al agendar servicio a el cliente. " + e.getMessage());
        }
    }

// --------------- this works but doesn't print result in the server ------------
// assign neighborhood to a client by its id 
    @PutMapping("/{client_id}/assign-neighborhood/{neighborhood_id}")
    public ClientModel assignClientToNeighborhood(
            @PathVariable("neighborhood_id") Long neighborhood_id,
            @PathVariable("client_id") Long client_id
    ) {
        return this.clientService.assignClientToNeighborhood(neighborhood_id, client_id);
    }

}
