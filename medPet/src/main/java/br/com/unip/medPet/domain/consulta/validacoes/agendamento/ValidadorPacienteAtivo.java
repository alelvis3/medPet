package br.com.unip.medPet.domain.consulta.validacoes.agendamento;

import br.com.unip.medPet.domain.ValidacaoException;
import br.com.unip.medPet.domain.consulta.DadosAgendamentoConsulta;
import br.com.unip.medPet.domain.paciente.animal.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteAtivo implements ValidadorAgendamentoDeConsulta {
    @Autowired
    private AnimalRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
        var pacienteEstaAtivo = repository.findAtivoById(dados.idAnimal());
        if (!pacienteEstaAtivo) {
            throw new ValidacaoException("Consulta não pode ser agendada com paciente excluído");
        }
    }
}