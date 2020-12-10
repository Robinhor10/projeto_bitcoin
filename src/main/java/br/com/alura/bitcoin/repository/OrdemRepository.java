package br.com.alura.bitcoin.repository;

import javax.enterprise.context.ApplicationScoped;

import br.com.alura.bitcoin.model.Ordem;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class OrdemRepository implements PanacheRepository<Ordem> {
    
}