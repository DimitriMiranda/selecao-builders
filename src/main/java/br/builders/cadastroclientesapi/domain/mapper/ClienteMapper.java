package br.builders.cadastroclientesapi.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.builders.cadastroclientesapi.controller.form.ClienteForm;
import br.builders.cadastroclientesapi.domain.dto.ClienteDTO;
import br.builders.cadastroclientesapi.domain.model.Cliente;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
	
	// Em caso de insert ID deve ser null 
	 @Mapping(target = "id", ignore = true)
	 Cliente toCliente(ClienteForm clienteform);
	 
	 ClienteDTO toClienteDto(Cliente cliente);

}
