package ribeiro.silveira.vinicius.med.voll.api.domain.consulta.validacoes.agendamento;

import ribeiro.silveira.vinicius.med.voll.api.domain.consulta.DadosAgendamentoDTO;

public interface ValidadoresAgendamentoDeConsulta {

    public void validar(DadosAgendamentoDTO dados);
}
