package br.builders.cadastroclientesapi.domain.model;

import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="cliente")
public class Cliente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String nome;
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date dataNascimento;
    private String numeroDocumento;

    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "cliente_id")
	private List<Endereco> endereco = new ArrayList<>();

}
