package ribeiro.silveira.vinicius.med.voll.api.paciente;

import ribeiro.silveira.vinicius.med.voll.api.endereco.EnderecoDTO;

public record PacienteDTO(String nome,
                          String email,
                          String telefone,
                          String cpf,
                          EnderecoDTO enderecoDTO) {
}
