package br.builders.cadastroclientesapi.service;

import br.builders.cadastroclientesapi.controller.form.ClienteForm;
import br.builders.cadastroclientesapi.domain.dto.ClienteDTO;
import br.builders.cadastroclientesapi.domain.mapper.ClienteMapper;
import br.builders.cadastroclientesapi.domain.model.Cliente;
import br.builders.cadastroclientesapi.repository.ClienteRepository;
import br.builders.cadastroclientesapi.utils.CadastroClientesUtils;
import lombok.Data;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@Service
public class ClienteServiceImpl implements ClienteService {


    private ClienteMapper mapper;

    private ClienteRepository repository;


    ClienteServiceImpl(ClienteRepository repository, ClienteMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    public ClienteDTO converterToClienteDto(Cliente cliente) {
        return mapper.toClienteDto(cliente);
    }

    public Cliente converterToCliente(ClienteForm clienteForm) {

        return mapper.toCliente(clienteForm);
    }


    public int calcularIdade(Date dataNascimento) {

        return CadastroClientesUtils.getDiferencaEntreAnos(dataNascimento);
    }

    @CacheEvict(cacheNames = ClienteDTO.CACHE_NAME, allEntries = true)
    public ClienteDTO create(ClienteForm clienteForm) {
        Cliente response = this.repository.save(this.converterToCliente(clienteForm));
        return this.converterToClienteDto(response);
    }


    @Cacheable(cacheNames = ClienteDTO.CACHE_NAME)
    public Page<ClienteDTO> list(Pageable pageable) {

        List<ClienteDTO> clientes = new ArrayList<>();
        this.repository.findAll(pageable).forEach(cliente -> {
            ClienteDTO clienteDTO = this.converterToClienteDto(cliente);
            clienteDTO.setIdade(this.calcularIdade(cliente.getDataNascimento()));
            clientes.add(clienteDTO);

        });

        Page<ClienteDTO> page = new PageImpl<>(clientes);
        return page;
    }


    @CacheEvict(cacheNames = ClienteDTO.CACHE_NAME, allEntries = true)
    public ClienteDTO update(long id, ClienteForm cliente) {

        ClienteDTO clienteDTO = this.repository.findById(id).map(record -> {

            record = this.converterToCliente(cliente);
            record.setId(id);
            Cliente updated = this.repository.save(record);
            ClienteDTO response = this.converterToClienteDto(updated);
            return response;

        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,""));

        return clienteDTO;


    }

    @CacheEvict(cacheNames = ClienteDTO.CACHE_NAME, allEntries = true)
    public ResponseEntity delete(long id) {

        return this.repository.findById(id)
                .map(record -> {
                    this.repository.delete(record);
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }).orElse(ResponseEntity.notFound().build());
    }


}