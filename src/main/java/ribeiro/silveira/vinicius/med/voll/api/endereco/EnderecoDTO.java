package ribeiro.silveira.vinicius.med.voll.api.endereco;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record EnderecoDTO(
        @NotNull
        String logradouro,
        @NotNull
        String bairro,
        @NotNull
        @Pattern(regexp = "\\d{8}")
        String cep,
        @NotNull
        String cidade,
        @NotNull
        String uf,
        String numero,
        String complemento) {
}
