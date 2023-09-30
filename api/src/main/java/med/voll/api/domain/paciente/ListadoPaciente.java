package med.voll.api.domain.paciente;

public record ListadoPaciente(Long id,String nombre, String telefono) {

    public ListadoPaciente(Paciente paciente){
        this(paciente.getId(),paciente.getNombre(),paciente.getTelefono());
    }
}
