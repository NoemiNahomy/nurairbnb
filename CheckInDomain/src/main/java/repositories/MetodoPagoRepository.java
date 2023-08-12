package repositories;

import core.BusinessRuleValidationException;
import java.util.List;
import java.util.UUID;
import model.MetodoPago;
import model.Persona;

public interface MetodoPagoRepository {
  UUID update(MetodoPago baggage);

  List<MetodoPago> findMetodoPagoById(UUID metodoId)
    throws BusinessRuleValidationException;

  List<MetodoPago> getAll() throws BusinessRuleValidationException;

}
