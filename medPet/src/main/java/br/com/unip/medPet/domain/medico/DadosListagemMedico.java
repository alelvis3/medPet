package br.com.unip.medPet.domain.medico;

public record DadosListagemMedico(Long id, String nome, String email, String crmv, Especialidade especialidade) {

    public DadosListagemMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrmv(), medico.getEspecialidade());
    }

}
