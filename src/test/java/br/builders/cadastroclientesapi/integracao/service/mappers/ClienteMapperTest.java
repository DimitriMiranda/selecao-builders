package br.builders.cadastroclientesapi.integracao.service.mappers;

import br.builders.cadastroclientesapi.domain.dto.ClienteDTO;
import br.builders.cadastroclientesapi.domain.mapper.ClienteMapper;
import br.builders.cadastroclientesapi.domain.model.Cliente;
import br.builders.cadastroclientesapi.domain.model.Endereco;
import br.builders.cadastroclientesapi.service.ClienteServiceImpl;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.security.SecureRandom;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClienteMapperTest {



    private ClienteMapper mapper = Mappers.getMapper(ClienteMapper.class);
    private Cliente cliente;


    @BeforeEach
    public void setUp() {

        String generatedString = RandomStringUtils.random(10, true, false);

        SecureRandom secureRandom = new SecureRandom();
        List<Endereco> enderecoList = new ArrayList<>();


        Endereco endereco = new Endereco();
        endereco.setId(1L);
        endereco.setCep(secureRandom.nextInt());
        endereco.setNumero(secureRandom.nextInt());
        endereco.setRua(generatedString);
        endereco.setComplemento(generatedString);

        enderecoList.add(endereco);

        Cliente cliente = new Cliente();
        cliente.setId(secureRandom.nextLong());
        cliente.setNome(generatedString);
        cliente.setDataNascimento(Date.from(Instant.now()));
        cliente.setNumeroDocumento(generatedString);

        cliente.setEndereco(enderecoList);

        this.cliente = cliente;

    }


    @Test
    public void converterToClienteDto() {

        ClienteDTO clienteDTO = mapper.toClienteDto(this.cliente);
        Assertions.assertInstanceOf(ClienteDTO.class, clienteDTO);


    }


}
