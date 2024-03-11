/*

Developed by Jhonatan Samuel Martinez Hernandez year 2024


 */
package jhonatan.decoramor.clients;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jhonatan Samuel Martinez Hernandez year 2024
 */
@RestController
@RequestMapping("/Api/v1/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<ClientModel> getAll() {

        try {
            return clientService.getAllClients();

        } catch (Exception e) {
            throw new RuntimeException("Error al consultar la lista cliente. " + e.getMessage());
        }

    }

    public ClientModel saveClient(@RequestBody ClientModel client) {
        try {
            return clientService.CreateClient(client);
        } catch (Exception e) {
            throw new RuntimeException("Error al crear el cliente. " + e.getMessage());
        }
    }
}
