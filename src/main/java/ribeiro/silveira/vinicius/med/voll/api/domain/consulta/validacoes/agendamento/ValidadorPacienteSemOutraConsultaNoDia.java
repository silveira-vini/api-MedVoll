package ribeiro.silveira.vinicius.med.voll.api.domain.consulta.validacoes.agendamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ribeiro.silveira.vinicius.med.voll.api.domain.consulta.ConsultaRepository;
import ribeiro.silveira.vinicius.med.voll.api.domain.consulta.DadosAgendamentoDTO;
import ribeiro.silveira.vinicius.med.voll.api.domain.exceptions.ValidacaoException;

@Component
public class ValidadorPacienteSemOutraConsultaNoDia implements ValidadoresAgendamentoDeConsulta {

    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoDTO dados) {

        var primeiroHoriario = dados.data().withHour(7);
        var ultimoHorario = dados.data().withHour(18);
        var pacientePossuiOutraConsultaNoDia = repository
                .existsByPacienteIdAndDataBetweenAndMotivoCancelamentoIsNull(dados.idPaciente(), primeiroHoriario, ultimoHorario);
        if (pacientePossuiOutraConsultaNoDia)
            throw new ValidacaoException("Paciente já possui uma consulta agendada nesse dia");

    }

}
