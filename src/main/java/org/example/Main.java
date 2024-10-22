import io.github.cdimascio.dotenv.Dotenv;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.models.supermercado.Cliente;
import org.example.repositories.supermercado.ClienteRepository;

import java.util.List;


public class Main {
    public static void main(String[] args){
        Dotenv dotenv = Dotenv.configure().load();

        System.setProperty("jakarta.persistence.jdcb.url", dotenv.get("DB_URL"));
        System.setProperty("jakarta.persistence.jdcb.user", dotenv.get("DB_USER"));
        System.setProperty("jakarta.persistence.jdcb.password", dotenv.get("DB_PASSWORD"));

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPu");
        ClienteRepository clienteRepository = new ClienteRepository(emf);

        Cliente cliente = new Cliente();
        cliente.setNombre("Tatiana");
        cliente.setApellido("Lopez");
        clienteRepository.save(cliente);

        List<Cliente>clientes = clienteRepository.findAll();

        for (Cliente personacliente : clientes){
            System.out.println(personacliente.getCompras());
            System.out.println(personacliente);
        }
            emf.close();
    }
}