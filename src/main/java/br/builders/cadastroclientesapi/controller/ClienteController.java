package br.builders.cadastroclientesapi.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.builders.cadastroclientesapi.controller.form.ClienteForm;
import br.builders.cadastroclientesapi.domain.dto.ClienteDTO;
import br.builders.cadastroclientesapi.domain.mapper.ClienteMapper;
import br.builders.cadastroclientesapi.domain.model.Cliente;
import br.builders.cadastroclientesapi.service.ClienteServiceImpl;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

  private ClienteServiceImpl service;

  
  ClienteController(ClienteServiceImpl service) {
	  
	  this.service = service;
  }

  
  
  @GetMapping
  public String listAll(){
	
	  return "teste rota";
	  
 }
  
  
  @PostMapping
  public ClienteDTO create(@RequestBody @Valid  ClienteForm clienteForm){
	  
	Cliente response =  service.repository.save(service.converterToCliente(clienteForm));
	return  service.converterToClienteDto(response);
	  
 }
  
  
}
