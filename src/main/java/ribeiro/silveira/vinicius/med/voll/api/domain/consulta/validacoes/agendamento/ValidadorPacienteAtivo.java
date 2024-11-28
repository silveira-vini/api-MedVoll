package ribeiro.silveira.vinicius.med.voll.api.domain.consulta.validacoes.agendamento;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ribeiro.silveira.vinicius.med.voll.api.domain.consulta.DadosAgendamentoDTO;
import ribeiro.silveira.vinicius.med.voll.api.domain.exceptions.ValidacaoException;
import ribeiro.silveira.vinicius.med.voll.api.domain.paciente.PacienteRepository;

@Component
public class ValidadorPacienteAtivo implements ValidadoresAgendamentoDeConsulta{

    @Autowired
    private PacienteRepository repository;

    public void validar(DadosAgendamentoDTO dados) {

        var pacienteAtivo = repository.findAtivoById(dados.idPaciente());
        if (!pacienteAtivo) throw new ValidacaoException("Não é possível agendar um paciente excluído");
    }
}
