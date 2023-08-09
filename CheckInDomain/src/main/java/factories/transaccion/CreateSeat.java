package factories.transaccion;

import core.BusinessRuleValidationException;
import java.util.UUID;
import model.Transaccion;

public class CreateSeat implements TransaccionFactory {

  @Override
  public Transaccion create(String code, String descripcion, double monto)
    throws BusinessRuleValidationException {
    return new Transaccion(
      UUID.fromString(code),
      descripcion,
      monto
    );
  }
}
