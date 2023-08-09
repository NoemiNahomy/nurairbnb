package repositories;

import core.BusinessRuleValidationException;
import java.util.List;
import java.util.UUID;
import model.Transaccion;

public interface TransactionRepository {
  UUID update(Transaccion transaccion);

  //List<Transaccion> findByFlightIdAndStatus(UUID flightId, String status)
    //throws BusinessRuleValidationException;

  List<Transaccion> findByTransactionCode(UUID flightId)
    throws BusinessRuleValidationException;
}
