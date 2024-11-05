package ribeiro.silveira.vinicius.med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ribeiro.silveira.vinicius.med.voll.api.medico.Medico;
import ribeiro.silveira.vinicius.med.voll.api.medico.MedicoDTO;
import ribeiro.silveira.vinicius.med.voll.api.medico.MedicoRepository;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody MedicoDTO dados) {
        repository.save(new Medico(dados));
    }
}
