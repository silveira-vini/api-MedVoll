package ribeiro.silveira.vinicius.med.voll.api.domain.consulta;

import jakarta.validation.constraints.NotNull;

public record DadosCancelamentoDTO(
        @NotNull
        Long idConsulta,
        @NotNull
        MotivoCancelamento motivo) {
}
