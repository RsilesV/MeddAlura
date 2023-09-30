package med.voll.api.domain.consulta.validaciones;

import med.voll.api.Infra.errores.ValidacionDeIntegridad;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import med.voll.api.domain.medico.MedicoRepository;

public class MedicoActivo implements ValidadorDeConsultas{

    private MedicoRepository repository;

    public void validar(DatosAgendarConsulta datos) {
        if (datos.idMedico()==null){
            return;
        }
        var medicoActivo=repository.findActivoById(datos.idMedico());

        if(!medicoActivo){
            throw new ValidacionDeIntegridad("No se permite medico inactivo");
        }
    }


}

