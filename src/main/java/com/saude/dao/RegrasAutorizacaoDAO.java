package com.saude.dao;

import com.saude.entity.RegraAutorizacao;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class RegrasAutorizacaoDAO extends GenericDAO {

    protected static RegrasAutorizacaoDAO instance;

    public RegrasAutorizacaoDAO() {
        super();
    }

    public static RegrasAutorizacaoDAO getInstance(){
        if (instance == null){
            instance = new RegrasAutorizacaoDAO();
        }

        return instance;
    }

    public RegraAutorizacao getById(final int id) {
        return entityManager.find(RegraAutorizacao.class, id);
    }

    public RegraAutorizacao getByIdProcedimento(final int idProcedimento) {
        CriteriaQuery<RegraAutorizacao> cr = cb.createQuery(RegraAutorizacao.class);
        Root<RegraAutorizacao> root = cr.from(RegraAutorizacao.class);
        cr.select(root).where(cb.equal(root.get("idProcedimento"),idProcedimento));

        return entityManager.createQuery(cr).getSingleResult();
    }

    public RegraAutorizacao getRegraValido(final int idProcedimento,final int idade,final char sexo) {
        CriteriaQuery<RegraAutorizacao> cr = cb.createQuery(RegraAutorizacao.class);
        Root<RegraAutorizacao> root = cr.from(RegraAutorizacao.class);
        Predicate procedimentoEq = cb.equal(root.get("idProcedimento"),idProcedimento);
        Predicate idadeEq =  cb.equal(root.get("idade"),idade);
        Predicate sexoEq =  cb.equal(root.get("sexo"),sexo);
        cr.select(root).where(
            cb.and(procedimentoEq,idadeEq,sexoEq)
        );

        RegraAutorizacao regra = null;
        try {
            regra = entityManager.createQuery(cr).getSingleResult();
        }catch (NoResultException ex) {
            System.out.println("Nenhum registro encontrado.");

        }
        return regra;
    }

    public List<RegraAutorizacao> findAll() {
        return entityManager.createQuery("FROM " +
                RegraAutorizacao.class.getSimpleName()).getResultList();
    }


}
