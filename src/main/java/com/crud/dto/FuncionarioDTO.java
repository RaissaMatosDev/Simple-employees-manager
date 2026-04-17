package com.crud.dto;

import com.crud.enums.Funcao;
import com.crud.model.Funcionario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record FuncionarioDTO(

        @NotBlank(message = "Nome é obrigatório")
        String nome,

        @NotBlank(message = "Email é Obrigatório")
        @Email(message = "Email Inválido")
        String email,

        @NotBlank(message = "Cpf é obrigatório")
        String cpf,

        Funcao funcao
) {
        public Funcionario toEntity() {
                return Funcionario.builder()
                        .nome(this.nome())
                        .email(this.email())
                        .cpf(this.cpf())
                        .funcao(this.funcao())
                        .build();
        }
}