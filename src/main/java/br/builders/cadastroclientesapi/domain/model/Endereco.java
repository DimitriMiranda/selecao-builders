package br.builders.cadastroclientesapi.domain.model;

import javax.persistence.*;

import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name="endereco")
public class Endereco {

//    public static final String CACHE_NAME = "Endereco";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rua;
    private long cep;
    private int numero;
    private String complemento;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", updatable = false )
    private Cliente cliente;

}
