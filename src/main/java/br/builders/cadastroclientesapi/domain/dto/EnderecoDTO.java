package br.builders.cadastroclientesapi.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class
EnderecoDTO implements Serializable {
    public static final String CACHE_NAME = "EnderecoDTO";
    @JsonProperty(value ="id",required = false)
    private Long id;
    private String rua;
    private long cep;
    private int numero;
    private String complemento;

}
