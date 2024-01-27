package repositories;

import core.BusinessRuleValidationException;
import java.util.List;
import java.util.UUID;
import model.TransaccionPago;

public interface TransactionPagoRepository {
  UUID update(TransaccionPago transaccion);

  List<TransaccionPago> findByTransactionCode(UUID pagoId) throws BusinessRuleValidationException;

  TransaccionPago findByReservaId(UUID reservaId) throws BusinessRuleValidationException;

  List<TransaccionPago> getAll() throws BusinessRuleValidationException;
}
