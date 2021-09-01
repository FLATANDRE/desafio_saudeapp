package com.saude.dao;

import com.saude.entity.SolicitacaoAutorizacao;

import java.util.List;

public class SolicitacaoAutorizacaoDAO extends GenericDAO {

    private static SolicitacaoAutorizacaoDAO instance;


    public static SolicitacaoAutorizacaoDAO getInstance(){
        if (instance == null){
            instance = new SolicitacaoAutorizacaoDAO();
        }
        return instance;
    }

    public SolicitacaoAutorizacaoDAO() {
        super();
    }

    public void save(SolicitacaoAutorizacao solicitacaoAutorizacao) {
        entityManager.getTransaction().begin();
        entityManager.persist(solicitacaoAutorizacao);
        entityManager.getTransaction().commit();
    }

    public List<SolicitacaoAutorizacao> findAll() {
        return entityManager.createQuery("FROM " +
                SolicitacaoAutorizacao.class.getSimpleName()).getResultList();
    }
}
