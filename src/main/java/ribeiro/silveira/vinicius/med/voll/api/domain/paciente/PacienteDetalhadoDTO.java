package ribeiro.silveira.vinicius.med.voll.api.domain.paciente;

import ribeiro.silveira.vinicius.med.voll.api.domain.endereco.Endereco;

public record PacienteDetalhadoDTO(Long id,
                                   String nome,
                                   String email,
                                   String telefone,
                                   String cpf,
                                   Endereco endereco) {

    public PacienteDetalhadoDTO(Paciente paciente) {
        this(paciente.getId(),
                paciente.getNome(),
                paciente.getEmail(),
                paciente.getTelefone(),
                paciente.getCpf(),
                paciente.getEndereco());
    }
}
