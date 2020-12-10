package br.com.alura.bitcoin.service;


import java.util.List;

// Interface que nos permitira chamar o endpoint externo para obter as infos de operações
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import br.com.alura.bitcoin.model.Bitcoin;

// Por boas práticas o caminho do endpoint chamado deve ficar no arquivo application.properties
@Path("/bitcoins")
@RegisterRestClient(configKey = "bitcoin-api") //Quando definido o configkey, eu posso no app properties declarar ao invés do full qualified da class

public interface BitcoinService {
   @GET
   @Produces(MediaType.APPLICATION_JSON)
 public List<Bitcoin> listar();
}