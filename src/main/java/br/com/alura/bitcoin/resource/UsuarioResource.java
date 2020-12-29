package br.com.alura.bitcoin.resource;

import javax.annotation.security.PermitAll;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import br.com.alura.bitcoin.model.Usuario;

@Path("/usuarios")
public class UsuarioResource {
    @POST
    @PermitAll // permite que essa classe seja acionada para cadastro, ainda que o user não tenha dado na base
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void inserir(Usuario usuario) {
        Usuario.adicionar(usuario);
    }    
}