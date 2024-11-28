package ribeiro.silveira.vinicius.med.voll.api.domain.consulta;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    boolean existsByMedicoIdAndDataAndMotivoCancelamentoIsNull(Long idMedico, LocalDateTime data);

    boolean existsByPacienteIdAndDataBetweenAndMotivoCancelamentoIsNull(Long pacienteId, LocalDateTime primeiroHoriario, LocalDateTime ultimoHorario);

}