package br.com.unip.medPet.domain.consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import br.com.unip.medPet.domain.medico.Especialidade;

import java.time.LocalDateTime;

public record DadosAgendamentoConsulta(
        Long idMedico,

        @NotNull
        Long idAnimal,

        @NotNull
        @Future
        LocalDateTime data,

        Especialidade especialidade) {
}
