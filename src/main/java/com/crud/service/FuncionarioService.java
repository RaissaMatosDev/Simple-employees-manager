package com.crud.service;

import com.crud.dto.FuncionarioAtualizacaoDTO;
import com.crud.dto.FuncionarioDTO;
import com.crud.model.Funcionario;
import com.crud.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

    private final FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public Funcionario salvar(FuncionarioDTO dto) {

        if (repository.existsByEmail(dto.email())) {
            throw new RuntimeException("Email já cadastrado");
        }

        if (repository.existsByCpf(dto.cpf())) {
            throw new RuntimeException("CPF já cadastrado");
        }
        Funcionario funcionario = dto.toEntity();

        return repository.save(funcionario);
    }

    public Funcionario buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado!"));
    }

    public Funcionario atualizar(Long id, FuncionarioAtualizacaoDTO dto) {

        Funcionario existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        if (repository.existsByEmailAndIdNot(dto.email(), id)) {
            throw new RuntimeException("Email já cadastrado");
        }

        if (repository.existsByCpfAndIdNot(dto.cpf(), id)) {
            throw new RuntimeException("CPF já cadastrado");
        }
        {
            existente.update(dto);

            return repository.save(existente);
        }
    }

    public void deletar(Long id) {
        Funcionario existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        repository.delete(existente);

    }

}
