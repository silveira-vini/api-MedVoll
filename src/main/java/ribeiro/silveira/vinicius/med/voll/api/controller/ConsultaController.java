package ribeiro.silveira.vinicius.med.voll.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ribeiro.silveira.vinicius.med.voll.api.domain.consulta.*;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private AgendaDeConsultas agenda;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoDTO dados) {
        agenda.agendar(dados);
        return ResponseEntity.ok(new DetalhamentoConsultaDTO(null, null, null, null));
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity cancelar(@RequestBody @Valid DadosCancelamentoDTO dados) {
        agenda.cancelarConsulta(dados);
        return ResponseEntity.noContent().build();
    }

}
