package ribeiro.silveira.vinicius.med.voll.api.domain.consulta.validacoes.cancelamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ribeiro.silveira.vinicius.med.voll.api.domain.consulta.ConsultaRepository;
import ribeiro.silveira.vinicius.med.voll.api.domain.consulta.DadosCancelamentoDTO;
import ribeiro.silveira.vinicius.med.voll.api.domain.exceptions.ValidacaoException;

@Component
public class ValidadorConsultaJaCancelada implements ValidadoresCancelamentodeConsutla{

    @Autowired
    private ConsultaRepository repository;

    @Override
    public void validar(DadosCancelamentoDTO dados) {
        var consulta = repository.getReferenceById(dados.idConsulta());
        if (consulta.getMotivoCancelamento() != null)
            throw new ValidacaoException("Consulta já cancelada anteriormente. Motivo: " + consulta.getMotivoCancelamento());
    }
}
