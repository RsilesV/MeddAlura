package med.voll.api.domain.consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.medico.Especialidad;

import java.time.LocalDate;
import java.time.LocalDateTime;

//@Future es para que no se puedan poner fechas anteriores a la de hoy
public record DatosAgendarConsulta(Long id, @NotNull Long idpaciente, Long idMedico, @NotNull @Future LocalDateTime fecha,
                                   Especialidad especialidad) {
}
