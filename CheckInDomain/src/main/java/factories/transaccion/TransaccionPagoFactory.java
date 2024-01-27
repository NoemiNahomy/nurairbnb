package factories.transaccion;

import core.BusinessRuleValidationException;
import model.TransaccionPago;

public interface TransaccionPagoFactory {


  TransaccionPago create(String code, String descripcion, double monto, String estado, String metodopagoId, String reservaId, String propiedadId,
						 String personaId, String fechaPago, String numeroTarjeta,String fechaVencimiento, String cvc)
      throws BusinessRuleValidationException;
}
