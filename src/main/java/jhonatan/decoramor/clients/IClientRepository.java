/*

Developed by Jhonatan Samuel Martinez Hernandez

 */
package jhonatan.decoramor.clients;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jhonatan Samuel Martinez Hernandez
 */
@Repository
public interface IClientRepository extends JpaRepository<ClientModel,Long> {
    
}
