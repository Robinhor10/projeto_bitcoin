package br.com.alura.bitcoin.resource;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import br.com.alura.bitcoin.model.Ordem;
import br.com.alura.bitcoin.service.OrdemService;

@Path("/ordens")
public class OrdemResource {
    @Inject
    OrdemService ordemService;

    @POST
    @Transactional
    @RolesAllowed("user") // permite somente que user consigam enviar ordens
    @Consumes(MediaType.APPLICATION_JSON)
    
    public void inserir(@Context SecurityContext securityContext, Ordem ordem) {
        ordemService.inserir(securityContext, ordem);
    }
}