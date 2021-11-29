package br.builders.cadastroclientesapi.domain.model;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rua;
    private long cep;
    private int numero;
    private String complemento;
    @ManyToOne
    private Cliente cliente;

}
