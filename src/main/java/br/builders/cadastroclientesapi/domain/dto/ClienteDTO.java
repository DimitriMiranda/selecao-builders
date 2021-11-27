package br.builders.cadastroclientesapi.domain.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import br.builders.cadastroclientesapi.domain.model.Endereco;
import lombok.Data;

@Data
public class ClienteDTO {
	
	
		private Long id;
	    private String nome;
	    private Date dataNascimento;
	    private String numeroDocumento;
        private List<Endereco> endereco = new ArrayList<>();

}
