package repositories;

import core.BusinessRuleValidationException;
import java.util.List;
import java.util.UUID;
import model.TransaccionPago;

public interface TransactionPagoRepository {
  UUID update(TransaccionPago transaccion);

  // List<Transaccion> findByFlightIdAndStatus(UUID flightId, String status)
  // throws BusinessRuleValidationException;

  List<TransaccionPago> findByTransactionCode(UUID flightId) throws BusinessRuleValidationException;

  List<TransaccionPago> getAll() throws BusinessRuleValidationException;
}
