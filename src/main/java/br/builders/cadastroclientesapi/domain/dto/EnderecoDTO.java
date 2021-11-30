package br.builders.cadastroclientesapi.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class
EnderecoDTO {

    @JsonProperty(value ="id",required = false)
    private Long id;
    private String rua;
    private long cep;
    private int numero;
    private String complemento;

}
