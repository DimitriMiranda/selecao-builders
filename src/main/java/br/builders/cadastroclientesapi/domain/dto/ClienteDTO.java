package br.builders.cadastroclientesapi.domain.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import br.builders.cadastroclientesapi.domain.model.Endereco;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class ClienteDTO {
	
	
		private Long id;
	    private String nome;
		@JsonFormat(pattern="dd/MM/yyyy")
	    private Date dataNascimento;
	    private String numeroDocumento;
		private int idade;
        private List<EnderecoDTO> endereco = new ArrayList<>();

}
