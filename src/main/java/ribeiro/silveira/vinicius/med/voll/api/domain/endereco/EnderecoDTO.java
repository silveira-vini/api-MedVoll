package ribeiro.silveira.vinicius.med.voll.api.domain.endereco;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record EnderecoDTO(
        @NotNull (message = "logradouro é obrigatório")
        String logradouro,
        @NotNull (message = "bairro é obrigatório")
        String bairro,
        @NotNull (message = "CEP obrigatório")
        @Pattern(regexp = "\\d{8}", message = "Formato de CEP incorreto")
        String cep,
        @NotNull (message = "Cidade obrigatório")
        String cidade,
        @NotNull (message = "UF obrigatório")
        String uf,
        String numero,
        String complemento) {
}
