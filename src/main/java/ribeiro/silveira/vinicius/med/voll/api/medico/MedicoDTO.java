package ribeiro.silveira.vinicius.med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import ribeiro.silveira.vinicius.med.voll.api.endereco.EnderecoDTO;

public record MedicoDTO(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull
        @Pattern(regexp = "\\d{10,11}")
        String telefone,
        @NotNull
        Especialidade especialidade,
        @NotNull
        @Valid
        EnderecoDTO endereco) {
}
