package ribeiro.silveira.vinicius.med.voll.api.controller;

import org.springframework.web.bind.annotation.*;
import ribeiro.silveira.vinicius.med.voll.api.medico.DadosCadastroMedico;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroMedico dados) {
        System.out.println("\nDADOS RECEBIDOS" + dados);
    }
}
