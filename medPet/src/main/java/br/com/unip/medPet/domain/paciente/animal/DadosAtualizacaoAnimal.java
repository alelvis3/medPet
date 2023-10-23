package br.com.unip.medPet.domain.paciente.animal;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record DadosAtualizacaoAnimal(@NotNull
                                     Long id,
                                     String nome,
                                     String raca,
                                     String cor,
                                     Date nascimento,
                                     Long ResponsavelAnimal_id
) {
}