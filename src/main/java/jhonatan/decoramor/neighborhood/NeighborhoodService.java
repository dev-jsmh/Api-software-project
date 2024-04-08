package jhonatan.decoramor.neighborhood;

import static java.util.Arrays.sort;
import java.util.List;
import java.util.Optional;
import jhonatan.decoramor.clients.IClientRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author samuel
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
    public List<NeighborhoodModel> getExistingNeighborhoods() {
        return this.neighborhoodRepository.findAll();
    }
 // Gets an specified neighborhood
    public NeighborhoodModel getById(Long id){
        // get and optional of the class as an result
        Optional<NeighborhoodModel> neighborhoodOpt = this.neighborhoodRepository.findById(id);
        // obtain the object of the returned Optional 
        NeighborhoodModel desiredNeighborhood = neighborhoodOpt.get();
        // return the resulting object
        return desiredNeighborhood;
    }

}
