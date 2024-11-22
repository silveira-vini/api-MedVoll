package ribeiro.silveira.vinicius.med.voll.api.domain.consulta;

import java.time.LocalDateTime;

public record DetalhamentoConsultaDTO(Long id, Long IdMedico, Long IdPaciente, LocalDateTime data) {
}
