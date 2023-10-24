package br.com.unip.medPet.controller;

import br.com.unip.medPet.domain.paciente.animal.AnimalRepository;
import br.com.unip.medPet.domain.paciente.responsavel.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("responsavel")
@SecurityRequirement(name = "bearer-key")
public class RespAnimalController {
    @Autowired
    private RespAnimalRepository respAnimalRepository;

    @Autowired
    private AnimalRepository animalRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroRespAnimal dados, UriComponentsBuilder uriBuilder) {
        var respAnimal = new ResponsavelAnimal(dados);
        respAnimalRepository.save(respAnimal);//Salva no banco de dados
        ///Devolve a cadastro para visualização do usuario em Json
        var uri = uriBuilder.path("/responsavel/{id}").buildAndExpand(respAnimal.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoRespAnimal(respAnimal));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemRespAnimal>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var page = respAnimalRepository.findAllByAtivoTrue(paginacao).map(DadosListagemRespAnimal::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoRespAnimal dados) {
        var respAnimal = respAnimalRepository.getReferenceById(dados.id());
        respAnimal.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoRespAnimal(respAnimal));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var respAnimal = respAnimalRepository.getReferenceById(id);
        respAnimal.excluir();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var respAnimal = respAnimalRepository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoRespAnimal(respAnimal));
    }

}