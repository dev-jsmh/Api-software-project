/*

Developed by Jhonatan Samuel Martinez Hernandez year 2024


 */
package jhonatan.decoramor.clients;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jhonatan Samuel Martinez Hernandez
 */
@Service
public class ClientService {

    private final IClientRepository clientRepository;

    public ClientService(IClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<ClientModel> getAllClients() {
        
          try {
           return clientRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar los clientes: " + e.getMessage());
        }
    }
}
