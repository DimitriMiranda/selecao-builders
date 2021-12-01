package br.builders.cadastroclientesapi.controller;

import br.builders.cadastroclientesapi.controller.form.ClienteForm;
import br.builders.cadastroclientesapi.domain.dto.ClienteDTO;
import br.builders.cadastroclientesapi.domain.model.Cliente;
import br.builders.cadastroclientesapi.service.ClienteServiceImpl;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteServiceImpl service;

    ClienteController(ClienteServiceImpl service) {

        this.service = service;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteDTO create(@RequestBody @Valid ClienteForm clienteForm) {
        Cliente response = service.repository.save(service.converterToCliente(clienteForm));
        return service.converterToClienteDto(response);
    }


    @GetMapping
    public ResponseEntity<Page<ClienteDTO>> list(@ParameterObject @PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10)  @RequestParam(required = false)  Pageable pageable) {

        List<ClienteDTO> clientes = new ArrayList<>();
        service.repository.findAll().forEach(cliente -> {
            ClienteDTO clienteDTO = service.converterToClienteDto(cliente);
            clienteDTO.setIdade(service.calcularIdade(cliente.getDataNascimento()));
            clientes.add(clienteDTO);

        });

        Page<ClienteDTO> page = new PageImpl<>(clientes);
        return ResponseEntity.ok(page);
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable("id") long id,
                                 @Valid @RequestBody ClienteForm cliente) {

        return service.repository.findById(id).map(record -> {

            record = service.converterToCliente(cliente);
            record.setId(id);
            Cliente updated = service.repository.save(record);
            ClienteDTO response = service.converterToClienteDto(updated);
            return ResponseEntity.ok().body(response);

        }).orElse(ResponseEntity.notFound().build());


    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {

        return service.repository.findById(id)
                .map(record -> {
                    service.repository.delete(record);
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }).orElse(ResponseEntity.notFound().build());


    }



}
