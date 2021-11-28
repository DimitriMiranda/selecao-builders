package br.builders.cadastroclientesapi.domain.dto;

import lombok.Data;

@Data
public class EnderecoDTO {

    private Long id;
    private String rua;
    private long cep;
    private int numero;
    private String complemento;

}
