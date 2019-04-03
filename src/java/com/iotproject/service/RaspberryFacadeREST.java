/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iotproject.service;

import com.iotproject.javabeans.Raspberry;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Stateless
@Path("raspberry")
public class RaspberryFacadeREST {

    @PersistenceContext(unitName = "iotprojectPU")
    private EntityManager em;

    public RaspberryFacadeREST() {
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void create(Raspberry raspberry) {
        em.merge(raspberry);
    }

    @PUT
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void edit(Raspberry raspberry) {
        em.merge(raspberry);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        Query query = em.createQuery("SELECT s FROM Raspberry s WHERE s.raspberryId = :id");
        query.setParameter("id", id);
        em.remove(em.merge((Raspberry) query.getResultList().get(0)));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Raspberry find(@PathParam("id") Integer id) {
        Query query = em.createQuery("SELECT s FROM Raspberry s WHERE s.raspberryId = :id");
        query.setParameter("id", id);
        return (Raspberry) query.getResultList().get(0);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Raspberry> findAll() {
        Query query = em.createQuery("SELECT s FROM Raspberry s");
        return (List<Raspberry>) query.getResultList();
    }
    
}
