package br.com.unip.medPet.domain.paciente.responsavel;

import br.com.unip.medPet.domain.endereco.Endereco;

public record DadosDetalhamentoRespAnimal(Long id, String nome, String email, String cpf, String telefone, Endereco endereco, Boolean ativo) {
    public DadosDetalhamentoRespAnimal(ResponsavelAnimal respAnimal) {
        this(respAnimal.getId(), respAnimal.getNome(), respAnimal.getEmail(), respAnimal.getCpf(), respAnimal.getTelefone(), respAnimal.getEndereco(),respAnimal.getAtivo());
    }
}
