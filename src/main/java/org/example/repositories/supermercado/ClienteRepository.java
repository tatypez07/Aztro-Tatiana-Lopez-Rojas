package org.example.repositories.supermercado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.example.models.supermercado.Cliente;

import java.util.List;


public class ClienteRepository {
    private final EntityManagerFactory emf;

    public ClienteRepository(EntityManagerFactory emf) {

    this.emf = emf;

     }

     public void save(Cliente cliente){
        EntityManagerFactory entityManager = emf.createEntityManager();
         EntityTransaction transaction = entityManager.createEntityManager().getTransaction();
         transaction.begin();
         entityManager.merge(Cliente);
         transaction.commit();
         entityManager.close();
     }

     public Cliente finById(long id){
        EntityManager entityManager = emf.createEntityManager();
        Cliente cliente = entityManager.find(Cliente.class, id);
        entityManager.close();
        return cliente;
     }


    public List<Cliente> findAll() {
    }
}

