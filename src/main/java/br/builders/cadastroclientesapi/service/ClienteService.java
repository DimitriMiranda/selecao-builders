package br.builders.cadastroclientesapi.service;

import br.builders.cadastroclientesapi.controller.form.ClienteForm;
import br.builders.cadastroclientesapi.domain.dto.ClienteDTO;
import br.builders.cadastroclientesapi.domain.model.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;





import java.util.Date;

public interface ClienteService {

    public ResponseEntity update(long id, ClienteForm cliente);
    public ResponseEntity delete(long id);
    public Page<ClienteDTO> list(Pageable pageable);
    public ClienteDTO create(ClienteForm cliente);
    public ClienteDTO converterToClienteDto(Cliente cliente);
    public Cliente converterToCliente(ClienteForm clienteForm);
    public int calcularIdade(Date dataNascimento);


	
} 