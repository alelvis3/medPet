package br.com.unip.medPet.domain.paciente.responsavel;

import br.com.unip.medPet.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoRespAnimal(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco
) {
}
