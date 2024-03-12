/*

Developed by Jhonatan Samuel Martinez Hernandez year 2024


 */
package jhonatan.decoramor.clients;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import jhonatan.decoramor.service.ServiceModel;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jhonatan Samuel Martinez Hernandez
 */
@Service
public class ClientService {

    private final IClientRepository clientRepository;

    public ClientService(IClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<ClientModel> getAllClients() {

        try {
            return clientRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar los clientes: " + e.getMessage());
        }
    }
// save a new client in the database

    public ClientModel CreateClient(ClientModel client) {
        try {
            return clientRepository.save(client);

        } catch (Exception e) {
            throw new RuntimeException("Error al intentar crear el nueco cliente. " + e.getMessage());
        }
    }

    public ArrayList<ServiceModel> clientPurchasedServices(Long client_id) {
        try {
            ClientModel client = clientRepository.findById(client_id).get();
            return client.getPurchased_services();

        } catch (Exception e) {
            throw new RuntimeException("Error al intentar crear el nueco cliente. " + e.getMessage());
        }
    }
    
    // ---------------------------------------------------------------------
// create or save a new service for a client
    public ClientModel addServiceToClient( ServiceModel serviceRequest, Long client_id) {
        try{
            // get optional of client 
            Optional<ClientModel> Opclient =  clientRepository.findById(client_id);
            // get client entity from the optional 
            ClientModel client = Opclient.get();
            
            // create a new service
            ServiceModel newService = new ServiceModel();
            
            // get and set the service info
            newService.setDate(serviceRequest.getDate());
            newService.setDescription(serviceRequest.getDescription());
            newService.setEstimate_value(serviceRequest.getEstimate_value());
            
            // schedule the new service to ta specific client
            client.scheduleService(newService);
            
            return clientRepository.save(client);
        }
        catch(Exception e){
        throw new RuntimeException("Error al agendar el servicio creado al cliente solicitado. " + e.getMessage());
        }

    }
    
}
