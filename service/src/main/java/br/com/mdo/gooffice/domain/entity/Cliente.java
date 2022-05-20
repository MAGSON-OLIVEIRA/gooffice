package br.com.mdo.gooffice.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cliente {

    @Id
    @Column(name = "api_key")
    private String chaveApi;

    @Column(name = "description")
    private String descricao;

    @Column(name = "active")
    private Boolean ativo;

}


