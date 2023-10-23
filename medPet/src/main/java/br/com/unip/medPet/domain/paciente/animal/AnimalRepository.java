package br.com.unip.medPet.domain.paciente.animal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    Page<Animal> findAllByAtivoTrue(Pageable paginacao);
    @Query("""
            select a.ativo
            from Animal a
            where
            a.id = :id
            """)
    Boolean findAtivoById(Long id);


        Page<Animal> findAnimalByResponsavelAnimalEquals(long id, Pageable paginacao);
}
