package br.com.unip.medPet.domain.paciente.animal;

import java.util.Date;

public record DadosListagemAnimal(Long id, String nome, Boolean ativo, String rga, Especie especie, String raca, String cor, Date nascimento, Long ResponsavelAnimal_id) {

    public DadosListagemAnimal(Animal animal) {
        this(animal.getId(), animal.getNome(), animal.getAtivo(),animal.getRga(),animal.getEspecie(),animal.getRaca(), animal.getCor(), animal.getNascimento(),animal.getResponsavelAnimal().getId());
    }
}
