package jhonatan.decoramor.neighborhood;

import java.util.List;
import jhonatan.decoramor.clients.IClientRepository;

/**
 *
 * @author samuel
 */
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

    // create method get
    public List<NeighborhoodModel> getExistingNeighborhoods() {
        return this.neighborhoodRepository.findAll();
    }
 

}
