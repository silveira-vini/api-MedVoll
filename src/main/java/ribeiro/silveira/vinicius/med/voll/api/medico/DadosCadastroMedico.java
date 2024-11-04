package ribeiro.silveira.vinicius.med.voll.api.medico;

import ribeiro.silveira.vinicius.med.voll.api.endereco.Endereco;

public record DadosCadastroMedico(String nome,
                                  String email,
                                  String crm,
                                  Especialidade especialidade,
                                  Endereco endereco) {
}
