package br.builders.cadastroclientesapi.integracao.service;

import br.builders.cadastroclientesapi.controller.form.ClienteForm;
import br.builders.cadastroclientesapi.domain.dto.ClienteDTO;
import br.builders.cadastroclientesapi.domain.dto.EnderecoDTO;
import br.builders.cadastroclientesapi.domain.mapper.ClienteMapper;
import br.builders.cadastroclientesapi.domain.model.Cliente;
import br.builders.cadastroclientesapi.domain.model.Endereco;
import br.builders.cadastroclientesapi.repository.ClienteRepository;
import br.builders.cadastroclientesapi.service.ClienteServiceImpl;
import br.builders.cadastroclientesapi.utils.CadastroClientesUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ClienteServiceTeste {


    @InjectMocks
    private ClienteServiceImpl service;

    @Mock
    private ClienteRepository repository;

    @Mock
    private ClienteMapper mapper;

    private Cliente cliente;

    private ClienteDTO clienteDTO;


    private ClienteForm clienteForm;


    @BeforeEach
    public void setUp() {

        this.cliente = mockGetCliente();
        this.clienteForm = mockGetClienteForm();
        this.clienteDTO =  mockGetClienteDTO();
        clienteDTO.setEndereco(mockGetEnderecoDTO());

    }








    @Test
    @DisplayName("calcularIdade_test")
    public void calcularIdade_test() throws ParseException {

        Assertions.assertNotNull(service.calcularIdade(new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1998")));

    }



    @Test
    @DisplayName("Criando um novo cliente")
    public void criar_cliente_test() throws ParseException {

        when(mapper.toCliente(any())).thenReturn(this.cliente);
        when(repository.save(any())).thenReturn(this.cliente);
        when(mapper.toClienteDto(any())).thenReturn(this.clienteDTO);

        ClienteDTO  newCliente =  service.create(clienteForm);

        Assertions.assertInstanceOf(ClienteDTO.class, newCliente);

    }



    private Cliente mockGetCliente() {
        String generatedString = RandomStringUtils.random(10, true, false);

        SecureRandom secureRandom = new SecureRandom();
        List<Endereco> enderecoList = new ArrayList<>();

        Endereco endereco = new Endereco();
        endereco.setId(1L);
        endereco.setCep(secureRandom.nextInt());
        endereco.setNumero(secureRandom.nextInt());
        endereco.setRua(CadastroClientesUtils.generatedString(10,true,false));
        endereco.setComplemento(CadastroClientesUtils.generatedString(10,true,false));

        Cliente cliente = new Cliente();
        cliente.setId(secureRandom.nextLong());
        cliente.setNome(CadastroClientesUtils.generatedString(10,true,false));
        cliente.setDataNascimento(Date.from(Instant.now()));
        cliente.setNumeroDocumento(CadastroClientesUtils.generatedString(10,true,false));

        endereco.setCliente(cliente);
        enderecoList.add(endereco);

        cliente.setEndereco(enderecoList);

        return  cliente;
    }

    private ClienteForm mockGetClienteForm() {

        clienteForm = new ClienteForm();

        clienteForm.setNome(CadastroClientesUtils.generatedString(10,true,false));


        return clienteForm;
    }





    private ClienteDTO mockGetClienteDTO() {

        clienteDTO  = new ClienteDTO();

        clienteDTO.setNome(CadastroClientesUtils.generatedString(10,true,false));


        return clienteDTO;
    }


    private List<EnderecoDTO> mockGetEnderecoDTO() {
        EnderecoDTO enderecoDTO = new EnderecoDTO();


        enderecoDTO.setId(1L);
        enderecoDTO.setCep(CadastroClientesUtils.generatedInt());
        enderecoDTO.setNumero(CadastroClientesUtils.generatedInt());
        enderecoDTO.setRua(CadastroClientesUtils.generatedString(10,true,false));
        enderecoDTO.setComplemento(CadastroClientesUtils.generatedString(10,true,false));

        List<EnderecoDTO> enderecoDTOList = new ArrayList<>();


        enderecoDTOList.add(enderecoDTO);

        return enderecoDTOList;
    }


}
