package br.com.alura.bitcoin.service;

import java.time.LocalDate;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

import br.com.alura.bitcoin.model.Ordem;
import br.com.alura.bitcoin.model.Usuario;
import br.com.alura.bitcoin.repository.OrdemRepository;

@ApplicationScoped
public class OrdemService {

    @Inject
    OrdemRepository ordemRepository;
    //Securitycontext injetado aqui para pegar o userid informado na requisição
    public void inserir(@Context SecurityContext securityContext, Ordem ordem) {
        //optional está validando se o usuário foi informado ou não, caso negativo faz tratamento de erro
        Optional<Usuario> usuarioOptional = 
                Usuario.findByIdOptional(ordem.getUserId());
        Usuario usuario = usuarioOptional.orElseThrow();
        if(!usuario.getUsername().equals(securityContext.getUserPrincipal().getName())) { 
            throw new RuntimeException("O usuário logado é diferente do userId");

        }
        ordem.setData(LocalDate.now());
        ordem.setStatus("ENVIADA");
        ordemRepository.persist(ordem);
    }

}
