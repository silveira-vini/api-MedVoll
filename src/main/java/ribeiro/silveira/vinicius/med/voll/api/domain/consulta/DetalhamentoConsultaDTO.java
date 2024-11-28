package ribeiro.silveira.vinicius.med.voll.api.domain.consulta;

import java.time.LocalDateTime;

public record DetalhamentoConsultaDTO(Long id, Long IdMedico, Long IdPaciente, LocalDateTime data) {

    public DetalhamentoConsultaDTO(Consulta consulta) {
        this(consulta.getId(),
                consulta.getMedico().getId(),
                consulta.getPaciente().getId(),
                consulta.getData());
    }
}
