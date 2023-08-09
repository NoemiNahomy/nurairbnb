package factories.transaccion;

import core.BusinessRuleValidationException;
import model.Transaccion;

public interface TransaccionFactory {
  Transaccion create(String code, String descripcion, double monto)
    throws BusinessRuleValidationException;
}
