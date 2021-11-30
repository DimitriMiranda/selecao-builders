package br.builders.cadastroclientesapi.domain.mapper;

import org.mapstruct.Mapper;

import br.builders.cadastroclientesapi.controller.form.ClienteForm;
import br.builders.cadastroclientesapi.domain.dto.ClienteDTO;
import br.builders.cadastroclientesapi.domain.model.Cliente;

@Mapper(componentModel = "spring")
public interface ClienteMapper {


    public Cliente toCliente(ClienteForm clienteform);

    public ClienteDTO toClienteDto(Cliente cliente);

}
