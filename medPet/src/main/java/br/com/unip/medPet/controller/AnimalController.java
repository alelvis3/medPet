package br.com.unip.medPet.controller;

import br.com.unip.medPet.domain.paciente.animal.*;
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
@RequestMapping("animal")
@SecurityRequirement(name = "bearer-key")
public class AnimalController {
    @Autowired
    private AnimalRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroAnimal dados, UriComponentsBuilder uriBuilder) {
        var animal = new Animal(dados);
        repository.save(animal);

        var uri = uriBuilder.path("/animal/{id}").buildAndExpand(animal.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoAnimal(animal));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemAnimal>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemAnimal::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoAnimal dados) {
        var animal = repository.getReferenceById(dados.id());
        animal.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoAnimal(animal));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var animal = repository.getReferenceById(id);
        animal.excluir();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var animal = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoAnimal(animal));
    }

    @GetMapping("/RespAnimal/{id}")
    public ResponseEntity<Page<DadosListagemAnimal>> listar(@PathVariable Long id, @PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemAnimal::new);
        return ResponseEntity.ok(page);
    }

}