package ribeiro.silveira.vinicius.med.voll.api.domain.consulta.validacoes.cancelamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ribeiro.silveira.vinicius.med.voll.api.domain.consulta.ConsultaRepository;
import ribeiro.silveira.vinicius.med.voll.api.domain.consulta.DadosCancelamentoDTO;
import ribeiro.silveira.vinicius.med.voll.api.domain.exceptions.ValidacaoException;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorAntecedenciaCancelamento implements ValidadoresCancelamentodeConsutla {

    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosCancelamentoDTO dados) {
        var consulta = repository.getReferenceById(dados.idConsulta());
        var agora = LocalDateTime.now();
        var diferenca = Duration.between(agora, consulta.getData()).toHours();
        if (diferenca < 24) throw new ValidacaoException("É necessário ao menos 30 minutos de antecedência para marcação");
    }
}
