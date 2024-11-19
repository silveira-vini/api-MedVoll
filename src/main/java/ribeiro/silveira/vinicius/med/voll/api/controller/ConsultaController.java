package ribeiro.silveira.vinicius.med.voll.api.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ribeiro.silveira.vinicius.med.voll.api.domain.consuta.DadosAgendamentoDTO;
import ribeiro.silveira.vinicius.med.voll.api.domain.consuta.DetalhamentoConsultaDTO;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoDTO dados) {
        System.out.println(dados);
        return ResponseEntity.ok(new DetalhamentoConsultaDTO(null, null, null, null));
    }
}
