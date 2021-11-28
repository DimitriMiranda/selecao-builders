package br.builders.cadastroclientesapi.service;
import br.builders.cadastroclientesapi.domain.mapper.ClienteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import br.builders.cadastroclientesapi.controller.form.ClienteForm;
import br.builders.cadastroclientesapi.domain.dto.ClienteDTO;
//import br.builders.cadastroclientesapi.domain.mapper.ClienteMapper;
import br.builders.cadastroclientesapi.domain.model.Cliente;
import br.builders.cadastroclientesapi.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Service
public class ClienteServiceImpl  implements ClienteService {
	

   private ClienteMapper mapper;

   public ClienteRepository repository;



	ClienteServiceImpl(ClienteRepository repository, ClienteMapper mapper ) {
         this.repository = repository;
		 this.mapper = mapper;
	}


	public ClienteDTO  converterToClienteDto(Cliente cliente) {
		return mapper.toClienteDto(cliente);
	}

	public Cliente  converterToCliente(ClienteForm clienteForm) {

		return mapper.toCliente(clienteForm);
	}
	
	
	
	
}