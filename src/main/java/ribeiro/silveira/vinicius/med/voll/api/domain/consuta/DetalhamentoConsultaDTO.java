package ribeiro.silveira.vinicius.med.voll.api.domain.consuta;

import java.time.LocalDateTime;

public record DetalhamentoConsultaDTO(Long id, Long IdMedico, Long IdPaciente, LocalDateTime data) {
}
