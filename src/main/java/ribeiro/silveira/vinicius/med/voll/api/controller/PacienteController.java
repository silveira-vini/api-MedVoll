package ribeiro.silveira.vinicius.med.voll.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ribeiro.silveira.vinicius.med.voll.api.paciente.PacienteDTO;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @PostMapping
    public void cadastrar (@RequestBody PacienteDTO dados) {
        System.out.println("\nDADOS PACIENTE: " + dados);
    }
}