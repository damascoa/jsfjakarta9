package com.olivet.controller;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class ClienteEJB {
    @PersistenceContext(unitName = "UnitPU")
    EntityManager em;

    public List clientes(){
        return em.createQuery("Select c From Cliente c").getResultList();
    }




}
