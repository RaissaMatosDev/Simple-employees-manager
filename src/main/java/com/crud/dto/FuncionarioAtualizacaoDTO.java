package com.crud.dto;

import com.crud.enums.Funcao;
import com.crud.model.Funcionario;
import jakarta.validation.constraints.Email;

public record FuncionarioAtualizacaoDTO(

                                        String nome,

                                        @Email(message = "Email Inválido")
                                        String email,


                                        String cpf,

                                        Funcao funcao) {
    public Funcionario toEntity() {
    return Funcionario.builder()
            .nome(this.nome())
            .email(this.email())
            .cpf(this.cpf())
            .funcao(this.funcao())
            .build();
}
}
