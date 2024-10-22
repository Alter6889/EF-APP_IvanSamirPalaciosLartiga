package cibertec.edu.pe.EF_APP_IvanSamirPalaciosLartiga.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import cibertec.edu.pe.EF_APP_IvanSamirPalaciosLartiga.model.Cliente;
import cibertec.edu.pe.EF_APP_IvanSamirPalaciosLartiga.Service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping("/registrar")
    public Cliente registrarCliente(@RequestBody Cliente cliente) {
        return clienteService.registrarCliente(cliente);
    }
}
