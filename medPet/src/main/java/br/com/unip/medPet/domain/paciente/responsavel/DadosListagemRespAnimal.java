package br.com.unip.medPet.domain.paciente.responsavel;

public record DadosListagemRespAnimal(Long id, String nome, String email, String cpf) {

    public DadosListagemRespAnimal(ResponsavelAnimal responsavelAnimal){
        this(responsavelAnimal.getId(), responsavelAnimal.getNome(), responsavelAnimal.getEmail(), responsavelAnimal.getCpf());
    }

}
