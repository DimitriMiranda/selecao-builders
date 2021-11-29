package br.builders.cadastroclientesapi.controller;

import javax.validation.Valid;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import br.builders.cadastroclientesapi.controller.form.ClienteForm;
import br.builders.cadastroclientesapi.domain.dto.ClienteDTO;
import br.builders.cadastroclientesapi.domain.model.Cliente;
import br.builders.cadastroclientesapi.service.ClienteServiceImpl;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

  private ClienteServiceImpl service;

  ClienteController(ClienteServiceImpl service) {

	  this.service = service;
  }

  

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ClienteDTO create(@RequestBody @Valid  ClienteForm clienteForm){

      Cliente response =  service.repository.save(service.converterToCliente(clienteForm));
	return  service.converterToClienteDto(response);


 }

}
