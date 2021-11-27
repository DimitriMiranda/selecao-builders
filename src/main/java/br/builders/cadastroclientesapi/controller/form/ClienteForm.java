package br.builders.cadastroclientesapi.controller.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.builders.cadastroclientesapi.domain.model.Endereco;
import lombok.Data;

@Data
public class ClienteForm {

	@NotBlank @NotNull @Size(min = 5, max = 50)
    private String nome;
	@NotBlank @NotNull
    private Date dataNascimento;
	@NotBlank @NotNull @Size(min = 5, max = 50)
    private String numeroDocumento;
    @Size(min=1)
    private List<Endereco> endereco = new ArrayList<>();
	
}
