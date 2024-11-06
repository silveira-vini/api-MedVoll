package ribeiro.silveira.vinicius.med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import ribeiro.silveira.vinicius.med.voll.api.endereco.EnderecoDTO;

public record MedicoAtualizacaoDTO(
        @NotNull
        Long id,
        String nome,
        @Pattern(regexp = "\\d{10,11}")
        String telefone,
        @Valid
        EnderecoDTO endereco) {
}
