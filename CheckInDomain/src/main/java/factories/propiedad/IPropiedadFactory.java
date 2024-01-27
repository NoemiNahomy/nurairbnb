package factories.propiedad;

import core.BusinessRuleValidationException;
import java.util.UUID;
import model.Propiedad;

public interface IPropiedadFactory {
  Propiedad create(UUID id, String nombre, String estado, double precio)
      throws BusinessRuleValidationException;
}
