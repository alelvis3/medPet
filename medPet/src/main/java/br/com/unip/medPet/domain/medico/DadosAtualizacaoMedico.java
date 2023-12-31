package br.com.unip.medPet.domain.medico;

import jakarta.validation.constraints.NotNull;
import  br.com.unip.medPet.domain.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
