package br.com.unip.medPet.domain.paciente.responsavel;

import br.com.unip.medPet.domain.paciente.animal.Animal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RespAnimalRepository extends JpaRepository<ResponsavelAnimal, Long> {
    Page<ResponsavelAnimal> findAllByAtivoTrue(Pageable paginacao);

}
