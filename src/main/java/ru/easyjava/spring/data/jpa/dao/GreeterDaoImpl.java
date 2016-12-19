package ru.easyjava.spring.data.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;
import ru.easyjava.spring.data.jpa.entity.Greeter;

/**
 * JPA based implementation of GreeterDao.
 */
@Repository
public class GreeterDaoImpl implements GreeterDao {
    /**
     * JPA EM factory, provided by Spring.
     */
    @PersistenceUnit
    private EntityManagerFactory emf;

    @Override
    public final void addGreet(final Greeter g) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(g);
        em.getTransaction().commit();
    }

    @Override
    public final List<Greeter> getGreetings() {
        return emf.createEntityManager()
                .createQuery("from Greeter", Greeter.class)
                .getResultList();
    }
}
