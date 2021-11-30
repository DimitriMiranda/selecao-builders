package br.builders.cadastroclientesapi.controller.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.builders.cadastroclientesapi.domain.dto.EnderecoDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Getter
@Setter
public class ClienteForm {

	@NotBlank @NotNull @Size(min = 5, max = 50)
    private String nome;
    @JsonFormat(pattern="dd/MM/yyyy")
	private Date dataNascimento;
	@NotBlank @NotNull @Size(min = 5, max = 50)
    private String numeroDocumento;
    @Size(min=1)
    private List<EnderecoDTO> endereco = new ArrayList<>();
	
}
