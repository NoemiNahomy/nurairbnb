package repositories;

import core.BusinessRuleValidationException;
import java.util.List;
import java.util.UUID;
import model.MetodoPago;

public interface MetodoPagoRepository {
  UUID update(MetodoPago baggage);

  List<MetodoPago> findMetodoPagoById(UUID metodoId)
    throws BusinessRuleValidationException;
}
