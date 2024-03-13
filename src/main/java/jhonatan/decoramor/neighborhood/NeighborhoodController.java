package jhonatan.decoramor.neighborhood;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jhonatan samuel Martinez Hernandez
 */
@RestController
@RequestMapping("/neighborhoods")
public class NeighborhoodController {

    private final NeighborhoodService neighborhoodService;

    public NeighborhoodController(
            NeighborhoodService neighborhoodService )
    {
        this.neighborhoodService = neighborhoodService;
    }

    // create a new neighborhood
    @PostMapping
    public NeighborhoodModel createNeighborhood(@RequestBody NeighborhoodModel newNeighborhood) {
        try {
            return this.neighborhoodService.createNeighborhood(newNeighborhood);

        } catch (Exception e) {
            throw new RuntimeException("Error al crear el cliente. " + e.getMessage());
        }
    }

    // Get a list of existing neighborhoods
    @GetMapping
    public List<NeighborhoodModel> getExistingNeighborhoods() {

        try {
            return this.neighborhoodService.getExistingNeighborhoods();

        } catch (Exception e) {
            throw new RuntimeException("Error al crear el cliente. " + e.getMessage());
        }
    }
}
