package ribeiro.silveira.vinicius.med.voll.api.domain.consulta.validacoes.agendamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ribeiro.silveira.vinicius.med.voll.api.domain.consulta.DadosAgendamentoDTO;
import ribeiro.silveira.vinicius.med.voll.api.domain.exceptions.ValidacaoException;
import ribeiro.silveira.vinicius.med.voll.api.domain.medico.MedicoRepository;

@Component
public class ValidadorMedicoAtivo implements ValidadoresAgendamentoDeConsulta{

    @Autowired
    private MedicoRepository repository;

    public void validar(DadosAgendamentoDTO dados) {

        if (dados.idMedico() == null) return;

        var medicoEstaAtivo = repository.findAtivoById(dados.idMedico());
        if (Boolean.FALSE.equals(medicoEstaAtivo)) throw new ValidacaoException("Consulta não pode ser marcada com médico inativo");
    }
}
