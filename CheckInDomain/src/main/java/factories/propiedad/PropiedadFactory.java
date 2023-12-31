package factories.propiedad;

import core.BusinessRuleValidationException;
import model.Propiedad;

import java.util.UUID;

public class PropiedadFactory implements IPropiedadFactory {

    @Override
    public Propiedad create(UUID id, String nombre, String estado, double precio) throws BusinessRuleValidationException {
        return new Propiedad(id,nombre,estado,precio);
    }
}
