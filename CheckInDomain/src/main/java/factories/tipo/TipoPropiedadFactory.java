package factories.tipo;

import core.BusinessRuleValidationException;
import java.util.UUID;
import model.TipoPropiedad;

public class TipoPropiedadFactory implements TipoFactory {

  @Override
  public TipoPropiedad create(UUID id, String nombre) throws BusinessRuleValidationException {
    return new TipoPropiedad(id, nombre);
  }
}
