package ribeiro.silveira.vinicius.med.voll.api.domain.consulta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ribeiro.silveira.vinicius.med.voll.api.domain.exceptions.ValidacaoException;
import ribeiro.silveira.vinicius.med.voll.api.domain.medico.Medico;
import ribeiro.silveira.vinicius.med.voll.api.domain.medico.MedicoRepository;
import ribeiro.silveira.vinicius.med.voll.api.domain.paciente.PacienteRepository;

@Service
public class AgendaDeConsultas {

    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private MedicoRepository medicoRepository;

    public void agendar(DadosAgendamentoDTO dados) {
        if (!pacienteRepository.existsById(dados.idPaciente()))
            throw new ValidacaoException("Id do paciente informado não existe");
        if (dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico()))
            throw new ValidacaoException("Id do médico informado não existe");


        var medico = escolherMedico(dados);
        var paciente = pacienteRepository.getReferenceById(dados.idPaciente());
        var consulta = new Consulta(null, medico, paciente, dados.data(), null);
        consultaRepository.save(consulta);
    }

    private Medico escolherMedico(DadosAgendamentoDTO dados) {

        if (dados.idMedico() != null)
            return medicoRepository.getReferenceById(dados.idMedico());
        if (dados.especialidade() == null)
            throw new ValidacaoException("A especialidade do médico é obrigatória");

        return medicoRepository.escolherMedicoAleatorio(dados.especialidade(), dados.data());
    }

    public void cancelarConsulta(DadosCancelamentoDTO dados) {

        if (!consultaRepository.existsById(dados.idConsulta()))
            throw new ValidacaoException("Id da consulta informado não existe");

        var consulta = consultaRepository.getReferenceById(dados.idConsulta());
        consulta.cancelar(dados.motivo());
    }
}
