package factories.tipo;

import core.BusinessRuleValidationException;
import model.TipoPropiedad;

import java.util.UUID;

public class TipoPropiedadFactory implements TipoFactory {

    @Override
    public TipoPropiedad create(UUID id, String nombre) throws BusinessRuleValidationException {
        return new TipoPropiedad(id,nombre);
    }
}
