package br.com.alura.bitcoin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;

// Entidade que irá persistir e recuperar info do banco de dados
@Entity // habilitando esse modelo p/ persistir dados
//Com panacheEntityBase fazer as operações com banco de dados

@UserDefinition /* Identifica que essa entidade usuario é que tem as infos
de credenciais de acesso do usuario usarname, password e role
*** SÓ PODEMOS TER UMA CLASSE NO PROJETO USANDO A ANOTAÇÃO USERDEFINITION */

// Desta forma estamos extendendo o metodo panache entitynase e essa forma acaba aumentando o
//desenvolvimento da nossa aplicação, além de alocar memoria para cada instancia feita par esse recurso

public class Usuario extends PanacheEntityBase {
    
    //Indicando o campo que é chave primária e também que o mesmo é auto increment no banco
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cpf;

    @Username // a extensão usurá a anotação para verificar as infos no banco , e não o que está definido abaixo na string
    private String username;

    @Password
    private String password;

    @Roles
    private String role;

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return String return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return String return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return String return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    // metodo estático para realizar a criptografia da senha informada no endpoint
public static void adicionar (Usuario usuario) {
    usuario.password = BcryptUtil.bcryptHash(usuario.password);
    usuario.role = validarUsername(usuario.username);
    usuario.persist();
}

private static String validarUsername(String username) {
    if (username.equals("alura")){
        return "admin";
    } return "user";
}

}