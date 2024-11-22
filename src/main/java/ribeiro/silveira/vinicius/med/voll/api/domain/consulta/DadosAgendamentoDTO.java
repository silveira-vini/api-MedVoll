package ribeiro.silveira.vinicius.med.voll.api.domain.consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import ribeiro.silveira.vinicius.med.voll.api.domain.medico.Especialidade;

import java.time.LocalDateTime;

public record DadosAgendamentoDTO(Long idMedico,
                                  @NotNull
                                  Long idPaciente,
                                  @NotNull
                                  @Future
                                  LocalDateTime data,
                                  Especialidade especialidade) {
}
