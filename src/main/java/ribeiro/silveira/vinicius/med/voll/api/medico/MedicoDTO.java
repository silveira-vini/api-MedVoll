package ribeiro.silveira.vinicius.med.voll.api.medico;

import ribeiro.silveira.vinicius.med.voll.api.endereco.EnderecoDTO;

public record MedicoDTO(String nome,
                        String email,
                        String crm,
                        Especialidade especialidade,
                        EnderecoDTO endereco) {
}
