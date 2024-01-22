package factories.tipo;

import core.BusinessRuleValidationException;
import java.util.UUID;
import model.TipoPropiedad;

public interface TipoFactory {
  TipoPropiedad create(UUID id, String nombre) throws BusinessRuleValidationException;
}
