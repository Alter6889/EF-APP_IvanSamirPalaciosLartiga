package cibertec.edu.pe.EF_APP_IvanSamirPalaciosLartiga.Service;

import cibertec.edu.pe.EF_APP_IvanSamirPalaciosLartiga.model.Cliente;
import cibertec.edu.pe.EF_APP_IvanSamirPalaciosLartiga.repository.ClienteRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Retry(name="registrarCliente")
    @CircuitBreaker(name = "registrarCliente", fallbackMethod = "fallbackRegistrarCliente")
    public Cliente registrarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    //si todo sale mal
    public Cliente fallbackRegistrarCliente(Cliente cliente, Throwable t){
        return new Cliente();
    }
}
