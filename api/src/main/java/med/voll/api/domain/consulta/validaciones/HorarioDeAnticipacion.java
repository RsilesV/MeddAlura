package med.voll.api.domain.consulta.validaciones;

import med.voll.api.Infra.errores.ValidacionDeIntegridad;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class HorarioDeAnticipacion implements ValidadorDeConsultas {


    public void validar(DatosAgendarConsulta datos){
        var ahora = LocalDateTime.now();
        var horaDeConsulta = datos.fecha();

        var diferencia= Duration.between(ahora,horaDeConsulta).toMinutes()<30;

        if(diferencia){
            throw new ValidacionDeIntegridad("Las consultas tienen que tener al menos 30 min de anticipacion");
        }

        }
    }

