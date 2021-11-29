package br.builders.cadastroclientesapi.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

//import br.builders.cadastroclientesapi.controller.form.ClienteForm;
//import br.builders.cadastroclientesapi.domain.dto.ClienteDTO;
//import br.builders.cadastroclientesapi.domain.model.Cliente;
import org.mapstruct.Mappings;

import br.builders.cadastroclientesapi.controller.form.ClienteForm;
import br.builders.cadastroclientesapi.domain.dto.ClienteDTO;
import br.builders.cadastroclientesapi.domain.model.Cliente;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
	
	// Em caso de insert ID deve ser null


			//@Mapping(target = "cliente.id", ignore = true)
			//@Mapping(target = "cliente.nome", source = "nome")
	        public  Cliente toCliente(ClienteForm clienteform);

	public  ClienteDTO toClienteDto(Cliente cliente);

}
