package factories.metodopago;

import core.BusinessRuleValidationException;
import java.util.UUID;
import model.MetodoPago;

public interface MetodoFactory {
  MetodoPago create(UUID id, String detalle, String tipo) throws BusinessRuleValidationException;
}
