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
@Table(name="cliente")
public class Cliente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String nome;
    private Date dataNascimento;
    private String numeroDocumento;

    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "cliente_id")
	private List<Endereco> endereco = new ArrayList<>();

}
