package factories.transaccion;

import core.BusinessRuleValidationException;
import model.TransaccionPago;

public interface TransaccionPagoFactory {
  TransaccionPago create(String code, String descripcion, double monto)
    throws BusinessRuleValidationException;
}
