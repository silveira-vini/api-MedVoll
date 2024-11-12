package ribeiro.silveira.vinicius.med.voll.api.domain.medico;

import ribeiro.silveira.vinicius.med.voll.api.domain.endereco.Endereco;

public record MedicoDadosDetalhadoDTO(Long id,
                                      String nome,
                                      String email,
                                      String crm,
                                      String telefone,
                                      Especialidade especialidade,
                                      Endereco endereco) {

    public MedicoDadosDetalhadoDTO(Medico medico) {
        this(medico.getId(),
                medico.getNome(),
                medico.getEmail(),
                medico.getCrm(),
                medico.getTelefone(),
                medico.getEspecialidade(),
                medico.getEndereco());
    }
}

