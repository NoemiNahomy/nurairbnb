package factories.metodopago;

import core.BusinessRuleValidationException;
import java.util.UUID;
import model.MetodoPago;

public class MetodoPagoFactory implements MetodoFactory {

  @Override
  public MetodoPago create(UUID id, String detalle, String tipo)
      throws BusinessRuleValidationException {
    return new MetodoPago(id, detalle, tipo);
  }
}
