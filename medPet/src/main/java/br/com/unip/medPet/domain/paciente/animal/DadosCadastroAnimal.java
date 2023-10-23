package br.com.unip.medPet.domain.paciente.animal;

import br.com.unip.medPet.domain.paciente.responsavel.ResponsavelAnimal;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.Date;

public record DadosCadastroAnimal(
        @NotBlank
        String nome,
        @NotBlank
        @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}")
        String rga,
        @NotNull
        Especie especie,
        @NotNull
        String raca,
        @NotNull
        String sexo,
        @NotNull
        String cor,
        Date nascimento,
        @NotNull
        Long ResponsavelAnimal_id
) {
}
