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
    // ---------------------------------------------------------------------
// get the list of services a client has passing as argument the client id

    public Set<ServiceModel> clientPurchasedServices(Long client_id) {
        try {
            ClientModel client = clientRepository.findById(client_id).get();
            return client.getPurchased_services();

        } catch (Exception e) {
            throw new RuntimeException("Error al intentar crear el nueco cliente. " + e.getMessage());
        }
    }

    // ---------------------------------------------------------------------
// create or save a new service for a client
    public ClientModel scheduleServiceToClient(ServiceModel serviceRequest, Long client_id) {
        try {
            // get optional of client 
            Optional<ClientModel> Opclient = clientRepository.findById(client_id);
            // get client entity from the optional 
            ClientModel client = Opclient.get();

            // create a new service
            ServiceModel newService = new ServiceModel(
                    serviceRequest.getDate(),
                    serviceRequest.getDescription(),
                    serviceRequest.getEstimate_value()
            );

            ServiceModel newService2 = new ServiceModel("test", "test new service createds", 40.000);

            // set client to service 
            newService.setClient(client);
            newService2.setClient(client);

            // List of services of the client
            Set<ServiceModel> ListOfServices = client.getPurchased_services();
            // add the new schedule service to the client's list 
            ListOfServices.add(newService);
            ListOfServices.add(newService2);
            client.setPurchased_services(ListOfServices);

            // verify if service info came to the service layer of client
            System.out.println("This is the client id: " + client.getId() + " and this the info for the new schedule service: ");

            System.out.println(newService.getClient().toString());
            System.out.println(newService.getDate());
            System.out.println(newService.getDescription());
            System.out.println(newService.getEstimate_value());

            return clientRepository.save(client);
        } catch (Exception e) {
            throw new RuntimeException("Error al agendar el servicio creado al cliente solicitado. " + e.getMessage());
        }

    }
    // assign neighborhood to client
    public NeighborhoodModel assignClientToNeighborhood(Long neighborhood_id, Long client_id) {
        
        // find the client 
        ClientModel clientIn = clientRepository.findById(client_id).get();
        // find the neighborhood
        NeighborhoodModel neighborhoodIn = neighborhoodRepository.findById(neighborhood_id).get();
        // List of client that belong the neighborhood
        Set<ClientModel> clients = neighborhoodIn.getClientList();
        
        // set the neighborhood to a client
        clientIn.setNeighborhood(neighborhoodIn);
         // add the neighborhood to a client
        clients.add(clientIn);
        // set client list to neighborhood
        neighborhoodIn.setClientList(clients);
       System.out.println(" estos son los clientes que pertenecen al barrio " + neighborhoodIn.toString() );
        
       return neighborhoodRepository.save(neighborhoodIn);
    }

}
