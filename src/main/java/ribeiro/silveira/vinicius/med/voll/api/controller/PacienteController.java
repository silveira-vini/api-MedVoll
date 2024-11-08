package ribeiro.silveira.vinicius.med.voll.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ribeiro.silveira.vinicius.med.voll.api.paciente.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid PacienteCadastroDTO dados) {
        repository.save(new Paciente(dados));
    }

    @GetMapping
    public Page<PacienteListagemDTO> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable) {
        return repository.findAllByAtivoTrue(pageable)
                .map(p -> new PacienteListagemDTO(p.getNome(), p.getEmail(), p.getCpf()));
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid PacienteAtualizacaoDTO dados) {
        var paciente = repository.getReferenceById(dados.id());
        paciente.atualizarDados(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        var paciente = repository.getReferenceById(id);
        paciente.excluir(id);
    }
}