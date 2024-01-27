package factories.transaccion;

import core.BusinessRuleValidationException;
import java.util.UUID;
import model.TransaccionPago;

public class TransactionPagoFactory implements TransaccionPagoFactory {

  @Override
  public TransaccionPago create(
      String code,
      String descripcion,
      double monto,
      String estado,
      String metodopagoId,
      String reservaId,
      String propiedadId,
      String personaId,
      String fechaPago,
      String numeroTarjeta,
      String fechaVencimiento,
      String cvc)
      throws BusinessRuleValidationException {
    return new TransaccionPago(
        UUID.fromString(code),
        descripcion,
        monto,
        estado,
        UUID.fromString(metodopagoId),
        UUID.fromString(reservaId),
        UUID.fromString(propiedadId),
        UUID.fromString(personaId),
        fechaPago,
        numeroTarjeta,
        fechaVencimiento,
        cvc);
  }
}
