package ribeiro.silveira.vinicius.med.voll.api.domain.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import ribeiro.silveira.vinicius.med.voll.api.domain.endereco.EnderecoDTO;

public record PacienteCadastroDTO(
        @NotBlank (message = "Nome é obrigatório")
        String nome,
        @NotBlank (message = "Email é obrigatório")
        @Email (message = "Formato do email incorreto")
        String email,
        @NotBlank (message = "Telefone é obrigatório")
        String telefone,
        @NotBlank (message = "CPF é obrigatório")
        @Pattern(regexp = "\\d{11}", message = "Formato de CPF incorreto")
        String cpf,
        @NotNull (message = "Dados de endereço obrigatório")
        @Valid
        EnderecoDTO endereco) {
}
