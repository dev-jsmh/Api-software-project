
package jhonatan.decoramor.neighborhood;

import jhonatan.decoramor.dtos.NeighborhoodDto;

/**
 * Jhonatan Samuel Martinez Hernandez
 * year 2024
 * Analyts and Software Development
 */
public class NeighborhoodMapper {
    
    public NeighborhoodDto converToDto(NeighborhoodModel neighborhoodModel ){
        
        // creates a dto object 
        NeighborhoodDto neighborhood = new NeighborhoodDto();
        // set data from the entity class
        neighborhood.setId(neighborhoodModel.getId());
        neighborhood.setName(neighborhoodModel.getName());
        // return the created neighborhood dto
        return neighborhood;
        
    }
    
    
    
}
