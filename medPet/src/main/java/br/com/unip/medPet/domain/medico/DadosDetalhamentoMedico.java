package br.com.unip.medPet.domain.medico;

import  br.com.unip.medPet.domain.endereco.Endereco;

public record DadosDetalhamentoMedico(Long id,
                                      String nome,
                                      String email,
                                      Boolean ativo,
                                      String crmv,
                                      String telefone,
                                      Especialidade especialidade,
                                      Endereco endereco) {

    public DadosDetalhamentoMedico(Medico medico) {
        this(medico.getId(),
                medico.getNome(),
                medico.getEmail(),
                medico.getAtivo(),
                medico.getCrmv(),
                medico.getTelefone(),
                medico.getEspecialidade(),
                medico.getEndereco());
    }
}
