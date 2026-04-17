package com.crud.repository;

import com.crud.model.Funcionario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    boolean existsByEmail(String email);

    boolean existsByCpf(String cpf);

    boolean existsByCpfAndIdNot(@NotBlank(message = "Cpf é obrigatório") String cpf, Long id);

    boolean existsByEmailAndIdNot(@NotBlank(message = "Email é Obrigatório") @Email(message = "Email Inválido") String email, Long id);
}