package br.builders.cadastroclientesapi.domain.model;

import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Cliente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String nome;
    private Date dataNascimento;
    private String numeroDocumento;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Endereco> endereco = new ArrayList<>();

}
