package ribeiro.silveira.vinicius.med.voll.api.paciente;

import jakarta.validation.constraints.NotNull;
import ribeiro.silveira.vinicius.med.voll.api.endereco.EnderecoDTO;

public record PacienteAtualizacaoDTO(
        @NotNull
        Long id,
        String nome,
        String telefone,
        EnderecoDTO endereco) {
}
