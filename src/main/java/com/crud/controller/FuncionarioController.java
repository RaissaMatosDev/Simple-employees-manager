package com.crud.controller;

import com.crud.dto.FuncionarioAtualizacaoDTO;
import com.crud.dto.FuncionarioDTO;
import com.crud.model.Funcionario;
import com.crud.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/funcionarios")

public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping
    public ResponseEntity<Funcionario> criar(@RequestBody @Valid FuncionarioDTO funcionario) {
        Funcionario novo = funcionarioService.salvar(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }



    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscar(@PathVariable Long id) {
            return ResponseEntity.ok(funcionarioService.buscarPorId(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizar(@PathVariable Long id,
                                                 @RequestBody @Valid FuncionarioAtualizacaoDTO funcionario){
        Funcionario atualizado = funcionarioService.atualizar(id, funcionario);
        return ResponseEntity.ok(atualizado);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        funcionarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }



}
