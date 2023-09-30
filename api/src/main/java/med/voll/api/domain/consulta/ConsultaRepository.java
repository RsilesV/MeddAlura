package med.voll.api.domain.consulta;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;


public interface ConsultaRepository extends JpaRepository<Consulta,Long> {


    boolean existsByPacienteIdAndFechaBetween(Long idpaciente, LocalDateTime primerHorario, LocalDateTime ultimoHorario);

    boolean existsByMedicoIdAndFecha(Long aLong, LocalDateTime fecha);
}
