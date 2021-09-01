package com.saude.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;

public class GenericDAO {

    protected EntityManager entityManager;
    protected CriteriaBuilder cb;

    public GenericDAO() {
        entityManager = getEntityManager();
        cb = entityManager.getCriteriaBuilder();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("saudeAppHibernate");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

}

