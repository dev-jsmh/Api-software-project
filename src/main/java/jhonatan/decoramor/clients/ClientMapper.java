package jhonatan.decoramor.clients;

import jhonatan.decoramor.neighborhood.NeighborhoodDto;
import jhonatan.decoramor.neighborhood.NeighborhoodMapper;
import jhonatan.decoramor.neighborhood.NeighborhoodModel;
import org.springframework.stereotype.Component;

/**
 * Jhonatan Samuel Martinez Hernandez year 2024 Analyts and Software Development
 */
@Component
public class ClientMapper {

    // converts a client entity to Dto
    public ClientDto toDto(ClientModel clientModel) {

        ClientDto tempClient = new ClientDto();

        // get each propertie from the client entity and set them to the dto object
        tempClient.setId(clientModel.getId());
        tempClient.setDni(clientModel.getDni());
        tempClient.setPhone(clientModel.getPhone());
        tempClient.setNames(clientModel.getNames());
        tempClient.setLastNames(clientModel.getLastNames());
        tempClient.setAddress(clientModel.getAddress());
        tempClient.setImage(clientModel.getImage());
        tempClient.setLastMaintenance(clientModel.getLastMaintenance());
        tempClient.setNextMaintenance(clientModel.getNextMaintenance());

        // map the neighborhood Entity to DTO
        NeighborhoodModel neighborhoodEntity = clientModel.getNeighborhood();
        // create an instance of the mapper
        NeighborhoodMapper neighMapper = new NeighborhoodMapper();
        // store the result
        NeighborhoodDto neighborhoodDto = neighMapper.converToDto(neighborhoodEntity);
        // set the converted neighborhood to the client 
        tempClient.setNeighborhood(neighborhoodDto);

        return tempClient;

    }

}
