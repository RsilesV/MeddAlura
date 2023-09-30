package med.voll.api.domain.consulta.validaciones;

import med.voll.api.Infra.errores.ValidacionDeIntegridad;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class HorarioDeFuncionamiento implements ValidadorDeConsultas {
    public void validar(DatosAgendarConsulta datos){
        var domingo= DayOfWeek.SUNDAY.equals(datos.fecha().getDayOfWeek());

        var antesDeApertura=datos.fecha().getHour()<7;
        var despuesDeCierre=datos.fecha().getHour()>19;

        if (domingo||antesDeApertura||despuesDeCierre){
            throw new ValidacionDeIntegridad("El horario de atencion de la clinica es de lunes a sabado de 07:00 a 19:00 horas");
        }
    }
}
