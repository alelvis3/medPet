package br.com.unip.medPet.domain.paciente.responsavel;

import br.com.unip.medPet.domain.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.util.Date;

public record DadosCadastroRespAnimal(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefone,
        @NotBlank
        @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")
        String cpf,

        @NotNull @Valid DadosEndereco endereco
) {
}
