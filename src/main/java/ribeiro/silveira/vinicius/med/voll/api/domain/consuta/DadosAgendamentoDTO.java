package ribeiro.silveira.vinicius.med.voll.api.domain.consuta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAgendamentoDTO(Long idMedico,
                                  @NotNull
                                  Long idPaciente,
                                  @NotNull
                                  @Future
                                  LocalDateTime data) {
}
