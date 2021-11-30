package br.builders.cadastroclientesapi.service;

import br.builders.cadastroclientesapi.controller.form.ClienteForm;
import br.builders.cadastroclientesapi.domain.dto.ClienteDTO;
import br.builders.cadastroclientesapi.domain.model.Cliente;


import java.util.Date;

public interface ClienteService {

    public ClienteDTO converterToClienteDto(Cliente cliente);
    public Cliente converterToCliente(ClienteForm clienteForm);
    public int calcularIdade(Date dataNascimento);
	
} 