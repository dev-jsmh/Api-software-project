/*

Developed by Jhonatan Samuel Martinez Hernandez year 2024


 */
package jhonatan.decoramor.clients;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import jhonatan.decoramor.neighborhood.INeighborhoodRepository;
import jhonatan.decoramor.neighborhood.NeighborhoodModel;
import jhonatan.decoramor.service.IServiceRepository;
import jhonatan.decoramor.service.ServiceModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

/**
 *
 * @author Jhonatan Samuel Martinez Hernandez
 */
@Service
public class ClientService {

    private final IClientRepository clientRepository;
    private final IServiceRepository serviceRepository;
    private final INeighborhoodRepository neighborhoodRepository;

    public ClientService(IClientRepository clientRepository, IServiceRepository serviceRepository, INeighborhoodRepository neighborhoodRepository) {
        this.clientRepository = clientRepository;
        this.serviceRepository = serviceRepository;
        this.neighborhoodRepository = neighborhoodRepository;
    }
// ======================= get a list of existing clients ======================

    public List<ClientModel> getAllClients() {

        try {
            return clientRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar los clientes: " + e.getMessage());
        }
    }

    // =================== get a specific client by its id =====================
    public ClientModel getClientById(Long client_id) {

        try {
            // find out is client exists and return an optional 
            Optional<ClientModel> clientOpt = this.clientRepository.findById(client_id);
            // get the client form optional 
            ClientModel desiredClient = clientOpt.get();
            // return client object
            return desiredClient;
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar los clientes: " + e.getMessage());
        }
    }

    // ================== Modify existing client data ==========================
    public ClientModel modifyClient(Long id, ClientModel modClient) {

        try {
            // get the request client from data base 
            ClientModel desiredClient = this.clientRepository.findById(id).get();
            // assing to desired client properties from the modify client 
            desiredClient.setDni(modClient.getDni());
            desiredClient.setFirst_name(modClient.getFirst_name());
            desiredClient.setSecund_name(modClient.getSecund_name());
            desiredClient.setFirst_lastname(modClient.getFirst_lastname());
            desiredClient.setSecund_lastname(modClient.getSecund_lastname());
            desiredClient.setPhone(modClient.getPhone());
            desiredClient.setAddress(modClient.getAddress());
            // return result of saving the modify client data
            return this.clientRepository.save(desiredClient);
            
        } catch (Exception ex) { // throws an error if present
            throw new RuntimeException("The client could have not been modify or found. ", ex);
        }
    }

// ======================= Save a new client in the database ===================
    public ClientModel CreateClient(ClientModel client) {
        try {
            return clientRepository.save(client);

        } catch (Exception e) {
            throw new RuntimeException("Error al intentar crear el nueco cliente. " + e.getMessage());
        }
    }
    // ---------------------------------------------------------------------
// get the list of services a client has passing as argument the client id

    // ---------------------------------------------------------------------
//==================== create or save a new service for a client ===============
    public ServiceModel scheduleServiceToClient(ServiceModel serviceRequest, Long client_id) {
        try {
            // get optional of client 
            Optional<ClientModel> Opclient = clientRepository.findById(client_id);
            // get client entity from the optional 
            ClientModel clientTemp = Opclient.get();

            // create a new service
            ServiceModel newService = new ServiceModel(
                    serviceRequest.getDate(),
                    serviceRequest.getDescription(),
                    serviceRequest.getEstimate_value());

            // assing the client to the creadted service
            newService.setClient(clientTemp);

            // verify if service info came to the service layer of client
            System.out.println("This is the client id: " + clientTemp.getId() + " and this the info for the new schedule service: ");

            System.out.println(newService.getClient().toString());
            System.out.println(newService.getDate());
            System.out.println(newService.getDescription());
            //convert the price of the service ( Double ) to String
            System.out.println(String.valueOf(newService.getEstimate_value()));
            // save the new service to the data base
            return this.serviceRepository.save(newService);
        } catch (Exception e) {
            throw new RuntimeException("Error al agendar el servicio creado al cliente solicitado. " + e.getMessage());
        }
    }
    
    // ============================= Delete client =============================

    public ClientModel deleteClient( Long id){
        
        try{
        
        // look for the client in the data base. Store in a variable
        ClientModel desiredClient = this.clientRepository.findById(id).get();
        // delete the client by its id
        this.clientRepository.deleteById(id);
        // return the previously found client
        return desiredClient;
        
        // prints an error in console if present
        }catch(Exception ex){
        throw new RuntimeException("Error when deleting the client. ", ex); 
        }
        
    }
    

    // =================== Methods related to neighborhood -=====================
    // assign neighborhood to client
    public ClientModel assignClientToNeighborhood(Long neighborhood_id, Long client_id) {

        // find the client 
        ClientModel clientIn = clientRepository.findById(client_id).get();
        // find the neighborhood
        NeighborhoodModel neighborhoodIn = neighborhoodRepository.findById(neighborhood_id).get();
        clientIn.setNeighborhood(neighborhoodIn);
        System.out.println(" estos son los clientes que pertenecen al barrio " + neighborhoodIn.toString());

        return clientRepository.save(clientIn);

    }

}
