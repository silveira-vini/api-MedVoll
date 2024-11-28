package ribeiro.silveira.vinicius.med.voll.api.domain.consulta.validacoes.agendamento;

import org.springframework.stereotype.Component;
import ribeiro.silveira.vinicius.med.voll.api.domain.consulta.DadosAgendamentoDTO;
import ribeiro.silveira.vinicius.med.voll.api.domain.exceptions.ValidacaoException;

import java.time.DayOfWeek;

@Component
public class ValidadorHorarioFuncionamentoClinica implements ValidadoresAgendamentoDeConsulta{

    public void validar(DadosAgendamentoDTO dados) {

        var dataConsulta = dados.data();
        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesHorario = dataConsulta.getHour() < 7;
        var depoisHorario = dataConsulta.getHour() > 18;

        if (domingo) throw new ValidacaoException("Não atendemos no domingo");
        if (antesHorario || depoisHorario) throw new ValidacaoException("Horário de atendimento das 7h as 18h");
    }

}
