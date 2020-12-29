package br.com.alura.bitcoin.repository;

import javax.enterprise.context.ApplicationScoped;

import br.com.alura.bitcoin.model.Ordem;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

/*Repository é um padrão de projeto que trabalha com a técnica ORM (Object Relational Mapper). 
O modelo consiste em fazer uma abstração do JPA (Java Persistence API).
O repository é uma classe que fornece métodos de persistência e geralmente é injetado em uma classe Controller ou Service. */



/* Dessa forma é considerada melhor em relação ao exemplo do active records usado na classe Usuario,
pois dessa forma eu aloco memoria para a toda aplicação utilizar quando houver requisição a esse endpoint,
ou seja, não aloca memoria por instancia, tornando mais performatica a classe,
outro ponto é o código fica mais enxuto e o metodo panacheentitybase fica abstrato */

@ApplicationScoped
public class OrdemRepository implements PanacheRepository<Ordem> {
    
}