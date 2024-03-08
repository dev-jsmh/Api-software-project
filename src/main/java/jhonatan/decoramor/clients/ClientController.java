/*

Developed by Jhonatan Samuel Martinez Hernandez year 2024


 */
package jhonatan.decoramor.clients;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
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
       
            return clientService.getAllClients();
       
    }

}
