package br.builders.cadastroclientesapi.controller;

import javax.validation.Valid;

import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import br.builders.cadastroclientesapi.controller.form.ClienteForm;
import br.builders.cadastroclientesapi.domain.dto.ClienteDTO;
import br.builders.cadastroclientesapi.domain.model.Cliente;
import br.builders.cadastroclientesapi.service.ClienteServiceImpl;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Sort.Direction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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



    @GetMapping
    public ResponseEntity<Page<ClienteDTO>> list(@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size= 10)	 Pageable pageable) {

       List<ClienteDTO> clientes = new ArrayList<>();
         service.repository.findAll().forEach(cliente -> {
            clientes.add(service.converterToClienteDto(cliente));
        });

         Page<ClienteDTO> page = new PageImpl<>(clientes);
         return ResponseEntity.ok(page);
    }



}
