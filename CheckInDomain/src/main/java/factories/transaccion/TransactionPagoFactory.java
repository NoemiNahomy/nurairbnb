package factories.transaccion;

import core.BusinessRuleValidationException;
import java.util.UUID;
import model.TransaccionPago;

public class TransactionPagoFactory implements TransaccionPagoFactory {

  @Override
  public TransaccionPago create(String code, String descripcion, double monto)
    throws BusinessRuleValidationException {
    return new TransaccionPago(
      UUID.fromString(code),
      descripcion,
      monto
    );
  }
}
