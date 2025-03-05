package jhonatan.decoramor.neighborhood;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import jhonatan.decoramor.clients.IClientRepository;
import org.springframework.stereotype.Service;

/**
 * Jhonatan Samuel Martinez Hernandez
 * year 2024
 * Analyts and Software Development
 */
@Service
public class NeighborhoodService {

    private final INeighborhoodRepository neighborhoodRepository;
    private final IClientRepository clientRepository;

// dependency injection here of the repository
    public NeighborhoodService(
            INeighborhoodRepository neighborhoodRepository,
            IClientRepository clientRepository) {
        this.neighborhoodRepository = neighborhoodRepository;
        this.clientRepository = clientRepository;
    }

    // create method post
    public NeighborhoodModel createNeighborhood(NeighborhoodModel newNeighborhood) {
        return this.neighborhoodRepository.save(newNeighborhood);
    }

    // GET list of neighborhoods method get
    public List<NeighborhoodDto> getExistingNeighborhoods() {

        try {
            List<NeighborhoodModel> listNeighborhood = this.neighborhoodRepository.findAll();
            List<NeighborhoodDto> listDto = new ArrayList();
            // loop through the entity list 
            for (int i = 0; listNeighborhood.size() > i; i++) {
                // create a new instance for a dto of neighborhood
                NeighborhoodDto TempNeighborhood = new NeighborhoodDto();
                // get the id of current neighborhood iteration and set it to the dto
                TempNeighborhood.setId(listNeighborhood.get(i).getId());
                // get the name of current neighborhood iteration and set it to the dto
                TempNeighborhood.setName(listNeighborhood.get(i).getName());
                // add the new created instance to the listDto
                listDto.add(TempNeighborhood);
            }
            // finally return the neighborhood dto list
            return listDto;
        } catch (Exception ex) {
            throw new RuntimeException("It was not possible to convert the entity list to Dto and return it. cause: " + ex);
        }

    }
    // Gets an specified neighborhood

    public NeighborhoodModel getById(Long id) {
        // get and optional of the class as an result
        Optional<NeighborhoodModel> neighborhoodOpt = this.neighborhoodRepository.findById(id);
        // obtain the object of the returned Optional 
        NeighborhoodModel desiredNeighborhood = neighborhoodOpt.get();
        // return the resulting object
        return desiredNeighborhood;
    }

}
