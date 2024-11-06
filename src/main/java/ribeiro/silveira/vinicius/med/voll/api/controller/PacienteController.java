package ribeiro.silveira.vinicius.med.voll.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ribeiro.silveira.vinicius.med.voll.api.paciente.Paciente;
import ribeiro.silveira.vinicius.med.voll.api.paciente.PacienteCadastroDTO;
import ribeiro.silveira.vinicius.med.voll.api.paciente.PacienteListagemDTO;
import ribeiro.silveira.vinicius.med.voll.api.paciente.PacienteRepository;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar (@RequestBody @Valid PacienteCadastroDTO dados) {
        repository.save(new Paciente(dados));
    }

    @GetMapping
    public Page<PacienteListagemDTO> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable) {
        return repository.findAll(pageable)
                .map(p -> new PacienteListagemDTO(p.getNome(), p.getEmail(), p.getCpf()));
    }
}