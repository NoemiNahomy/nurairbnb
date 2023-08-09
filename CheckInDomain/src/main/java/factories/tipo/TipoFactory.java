package factories.tipo;

import core.BusinessRuleValidationException;
import model.Propiedad;
import model.TipoPropiedad;

import java.util.UUID;

public interface TipoFactory {
    TipoPropiedad create(UUID id, String nombre) throws BusinessRuleValidationException;
}
