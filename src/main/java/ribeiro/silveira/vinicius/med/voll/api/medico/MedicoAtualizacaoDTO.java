package ribeiro.silveira.vinicius.med.voll.api.medico;

import jakarta.validation.constraints.NotNull;
import ribeiro.silveira.vinicius.med.voll.api.endereco.EnderecoDTO;

public record MedicoAtualizacaoDTO(
        @NotNull
        Long id,
        String nome,
        String telefone,
        EnderecoDTO endereco) {
}
