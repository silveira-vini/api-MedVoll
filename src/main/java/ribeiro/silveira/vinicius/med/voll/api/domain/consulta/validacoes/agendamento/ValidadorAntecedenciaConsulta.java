package ribeiro.silveira.vinicius.med.voll.api.domain.consulta.validacoes.agendamento;

import org.springframework.stereotype.Component;
import ribeiro.silveira.vinicius.med.voll.api.domain.consulta.DadosAgendamentoDTO;
import ribeiro.silveira.vinicius.med.voll.api.domain.exceptions.ValidacaoException;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorAntecedenciaConsulta implements ValidadoresAgendamentoDeConsulta {

    public void validar(DadosAgendamentoDTO dados) {
        var horaConsulta = dados.data();
        var agora = LocalDateTime.now();
        var diferenca = Duration.between(agora, horaConsulta).toMinutes();
        if (diferenca < 30) throw new ValidacaoException("É necessário ao menos 30 minutos de antecedência para marcação");
    }
}
