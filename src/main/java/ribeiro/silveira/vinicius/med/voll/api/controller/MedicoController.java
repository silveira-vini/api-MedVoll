package ribeiro.silveira.vinicius.med.voll.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ribeiro.silveira.vinicius.med.voll.api.medico.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid MedicoCadastroDTO dados) {
        repository.save(new Medico(dados));
    }

    @GetMapping
    public Page<MedicoListagemDTO> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable) {
        return repository.findAll(pageable)
                .map(m -> new MedicoListagemDTO(m.getId(), m.getNome(), m.getEmail(), m.getCrm(), m.getEspecialidade()));
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid MedicoAtualizacaoDTO dados) {
        var medico = repository.getReferenceById(dados.id());
    }

}
