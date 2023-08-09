package factories.propiedad;


import core.BusinessRuleValidationException;
import model.Propiedad;

import java.util.UUID;

public interface IPropiedadFactory {
    Propiedad create(UUID id, String nombre, String estado, double precio) throws BusinessRuleValidationException;
}
