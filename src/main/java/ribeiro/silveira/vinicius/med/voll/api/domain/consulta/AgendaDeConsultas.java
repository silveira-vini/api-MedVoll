package ribeiro.silveira.vinicius.med.voll.api.domain.consulta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ribeiro.silveira.vinicius.med.voll.api.domain.consulta.validacoes.agendamento.ValidadoresAgendamentoDeConsulta;
import ribeiro.silveira.vinicius.med.voll.api.domain.consulta.validacoes.cancelamento.ValidadoresCancelamentodeConsutla;
import ribeiro.silveira.vinicius.med.voll.api.domain.exceptions.ValidacaoException;
import ribeiro.silveira.vinicius.med.voll.api.domain.medico.Medico;
import ribeiro.silveira.vinicius.med.voll.api.domain.medico.MedicoRepository;
import ribeiro.silveira.vinicius.med.voll.api.domain.paciente.PacienteRepository;

import java.util.List;


@Service
public class AgendaDeConsultas {

    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private List<ValidadoresAgendamentoDeConsulta> validadoresAgendamento;
    @Autowired
    private List<ValidadoresCancelamentodeConsutla> validadoresCancelamento;


    public DetalhamentoConsultaDTO agendar(DadosAgendamentoDTO dados) {
        if (!pacienteRepository.existsById(dados.idPaciente()))
            throw new ValidacaoException("Id do paciente informado não existe");
        if (dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico()))
            throw new ValidacaoException("Id do médico informado não existe");

        validadoresAgendamento.forEach(v -> v.validar(dados));

        var medico = escolherMedico(dados);
        var paciente = pacienteRepository.getReferenceById(dados.idPaciente());
        var consulta = new Consulta(null, medico, paciente, dados.data(), null);
        consultaRepository.save(consulta);

        return new DetalhamentoConsultaDTO(consulta);
    }


    private Medico escolherMedico(DadosAgendamentoDTO dados) {

        if (dados.idMedico() != null)
            return medicoRepository.getReferenceById(dados.idMedico());
        if (dados.especialidade() == null)
            throw new ValidacaoException("A especialidade do médico é obrigatória");

        var medico = medicoRepository.escolherMedicoAleatorioLivreNaData(dados.especialidade(), dados.data());
        if (medico == null)
            throw new ValidacaoException("Não há médico disponível para a especialidade " +
                    dados.especialidade() + " nesse dia e horário");

        return medico;
    }


    public void cancelarConsulta(DadosCancelamentoDTO dados) {

        if (!consultaRepository.existsById(dados.idConsulta()))
            throw new ValidacaoException("Id da consulta informado não existe");

        if(dados.motivo() == null)
            throw new ValidacaoException("Motivo do cancelamento é obrigatório");

        validadoresCancelamento.forEach(v -> v.validar(dados));

        var consulta = consultaRepository.getReferenceById(dados.idConsulta());
        consulta.cancelar(dados.motivo());
    }

}
