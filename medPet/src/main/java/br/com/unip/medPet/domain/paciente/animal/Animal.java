package br.com.unip.medPet.domain.paciente.animal;

import br.com.unip.medPet.domain.paciente.responsavel.ResponsavelAnimal;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "animal")
@Entity(name = "Animal")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Boolean ativo;

    private String rga;

    @Enumerated(EnumType.STRING)
    private Especie especie;
    private String raca;
    private String sexo;
    private String cor;
    private Date nascimento;

    @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "ResponsavelAnimal_id")
    private ResponsavelAnimal responsavelAnimal;


    public Animal(DadosCadastroAnimal dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.rga = dados.rga();
        this.especie = dados.especie();
        this.raca = dados.raca();
        this.sexo = dados.sexo();
        this.cor = dados.cor();
        this.nascimento = dados.nascimento();
        this.responsavelAnimal = new ResponsavelAnimal(dados.ResponsavelAnimal_id());


    }

    public void atualizarInformacoes(DadosAtualizacaoAnimal dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.raca()!= null) {
            this.raca = dados.raca();
        }
        if (dados.cor()!=null) {
            this.cor = dados.cor();
        }
        if (dados.nascimento()!=null) {
            this.nascimento = dados.nascimento();
        }
        if (dados.ResponsavelAnimal_id()!=null) {
            this.responsavelAnimal = new ResponsavelAnimal(dados.ResponsavelAnimal_id());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
