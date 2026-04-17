package com.crud.model;

import com.crud.dto.FuncionarioAtualizacaoDTO;
import com.crud.enums.Funcao;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "funcionarios")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String cpf;

    @Enumerated(EnumType.STRING)
    private Funcao funcao;

    public void update(FuncionarioAtualizacaoDTO dto) {
        if (dto.nome() != null) {
            this.nome = dto.nome();
        }
        if (dto.email() != null) {
            this.email = dto.email();
        }
        if (dto.cpf() != null) {
            this.cpf = dto.cpf();
        }
        if (dto.funcao() != null) {
            this.funcao = dto.funcao();
        }
    }


}
