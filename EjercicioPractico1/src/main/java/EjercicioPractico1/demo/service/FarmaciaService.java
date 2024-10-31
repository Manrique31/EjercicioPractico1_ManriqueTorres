package EjercicioPractico1.demo.service;


import EjercicioPractico1.demo.domain.Farmacia;
import java.util.List;

public interface FarmaciaService {

    // Se recupera la lista de Farmacia 
    //de la tabla Farmacia dentro de un arrayList
    public List<Farmacia> getFarmacias(boolean activo);

    // Se obtiene un registro de farmacia 
    // objeto de tipo Farmacia
    public Farmacia getFarmacias(Farmacia farmacia);

    // Se crea un nuevo registro en la tabla Farmacia.
    // Se actualiza el regitro en la tabla 
    public void save(Farmacia farmacia);

    // Se elimina el registro en la tabla
    public void delete(Farmacia farmacia);

}
