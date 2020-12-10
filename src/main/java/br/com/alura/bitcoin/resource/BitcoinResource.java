package br.com.alura.bitcoin.resource;


import javax.inject.Inject;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import br.com.alura.bitcoin.model.Bitcoin;
import br.com.alura.bitcoin.service.BitcoinService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

//Essa classe tem o objetivo de ser a porta de entrada para a requisição do endpoint,
// O Usuário vai acionar essa classe e a mesma chamará o bitcoinservice para que seja chamada a API externa

@Path("/bitcoins")
public class BitcoinResource {

    @Inject
    @RestClient

    BitcoinService bitcoinService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bitcoin> listar() {
        return bitcoinService.listar();
    }


    
}