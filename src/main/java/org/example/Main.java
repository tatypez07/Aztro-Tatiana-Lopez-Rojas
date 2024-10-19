import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.models.supermercado.Cliente;

import javax.swing.text.html.parser.Entity;
import java.sql.SQLOutput;
import java.util.List;

public class Main {
    public static void main(String[] args){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPu");
        ClienteRepository ClienteRepository = new ClienteRepository (emf);

        Cliente cliente = new Cliente();
        cliente.setNombre("Tatiana");





    }
}