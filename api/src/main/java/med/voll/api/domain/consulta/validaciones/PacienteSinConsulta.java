package med.voll.api.domain.consulta.validaciones;

import med.voll.api.Infra.errores.ValidacionDeIntegridad;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PacienteSinConsulta implements ValidadorDeConsultas{

    @Autowired
    private ConsultaRepository repository;

    public void validar(DatosAgendarConsulta datos){
        var primerHorario=datos.fecha().withHour(7);
        var ultimoHorario=datos.fecha().withHour(18);

        var pacienteConConsulta=repository.existsByPacienteIdAndFechaBetween(datos.idpaciente(),primerHorario,ultimoHorario);

        if(pacienteConConsulta){
            throw new ValidacionDeIntegridad("No se puede tener dos citas el mismo dia");
        }
    }

}
