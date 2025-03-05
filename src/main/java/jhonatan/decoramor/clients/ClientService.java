/*

Developed by Jhonatan Samuel Martinez Hernandez year 2024


 */
package jhonatan.decoramor.clients;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import jhonatan.decoramor.neighborhood.INeighborhoodRepository;
import jhonatan.decoramor.neighborhood.NeighborhoodModel;
import jhonatan.decoramor.appointment.AppointmentModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import jhonatan.decoramor.appointment.IAppointmentRepository;

/**
 *
 * @author Jhonatan Samuel Martinez Hernandez
 */
@Service
public class ClientService {

    private final IClientRepository clientRepository;
    private final IAppointmentRepository appointmentRepository;
    private final INeighborhoodRepository neighborhoodRepository;
    // dto mapper 
    private final ClientMapper clientMapper;

    public ClientService(IClientRepository clientRepository, IAppointmentRepository appointmentRepository, INeighborhoodRepository neighborhoodRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.appointmentRepository = appointmentRepository;
        this.neighborhoodRepository = neighborhoodRepository;
        this.clientMapper = clientMapper;
    }
    // ======================= get a list of existing clients ======================

    public List<ClientDto> getAllClients() {

        // create a new instance of client mapper
        ClientMapper mapper = new ClientMapper();
        try {

            List<ClientModel> listClients = clientRepository.findAll();
            List<ClientDto> listDto = new ArrayList();

            for (int i = 0; i < listClients.size(); i++) {
                // get client from the current iteration and convert to dto
                ClientDto dto = mapper.toDto(listClients.get(i));
                // add the return client dto to the list
                listDto.add(dto);
            }
            return listDto;
        } catch (Exception e) {
            throw new RuntimeException("It was not possible to convert client entities to dto's and return a list. cause: " + e.getMessage());
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
            desiredClient.setNames(modClient.getNames());
            desiredClient.setLastNames(modClient.getLastNames());
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

            // get the neighborhood from data base
            Optional<NeighborhoodModel> OptNeighborhood = neighborhoodRepository.findById(client
                    .getNeighborhood()
                    .getId());
            // extract the class entity from the neighborhood optional 
            NeighborhoodModel neighborhoodIn = OptNeighborhood.get();
            // save the client in the data base
            ClientModel newClient = clientRepository.save(client);

            // get the result and assign a neighborhood to the client
            newClient.setNeighborhood(neighborhoodIn);
            // return the client with the neighborhood
            return newClient;

        } catch (Exception e) {
            throw new RuntimeException("Error al intentar crear el nuevo cliente. " + e.getMessage());
        }
    }

    // ============================= Delete client =============================
    public void deleteClient(Long client_id) {

        try {

            // look for the client in the data base. Store in a variable
            ClientModel desiredClient = this.clientRepository.findById(client_id).get();
            // delete the client by its id
            System.out.println("Client id number is: " + client_id);
            this.clientRepository.deleteById(client_id);
            // return the previously found client
            System.out.println("Client deleted successufuly. ");

            // prints an error in console if present
        } catch (Exception ex) {
            throw new RuntimeException("Deleting the client has faild. It isn't an client id number specified. " + ex.getMessage());
        }

    }

}
