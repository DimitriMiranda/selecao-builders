package br.builders.cadastroclientesapi.controller;

import br.builders.cadastroclientesapi.controller.form.ClienteForm;
import br.builders.cadastroclientesapi.domain.dto.ClienteDTO;
import br.builders.cadastroclientesapi.domain.model.Cliente;
import br.builders.cadastroclientesapi.service.ClienteServiceImpl;
import org.springdoc.api.annotations.ParameterObject;
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
        return service.create(clienteForm);
    }


    @GetMapping
    public ResponseEntity<Page<ClienteDTO>> list( @PageableDefault(sort = "id", direction = Direction.DESC, page = 0, size = 10) @RequestParam(required = false) Pageable pageable) {
         return ResponseEntity.ok(service.list());
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable("id") long id,
                                 @Valid @RequestBody ClienteForm cliente) {

    return service.update(id,cliente);

    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
      return service.delete(id);
    }


}
