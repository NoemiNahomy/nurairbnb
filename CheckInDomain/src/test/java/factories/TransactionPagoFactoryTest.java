package factories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import core.BusinessRuleValidationException;
import factories.transaccion.TransactionPagoFactory;
import java.util.UUID;
import model.TransaccionPago;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TransactionPagoFactoryTest {

  private TransactionPagoFactory transactionPagoFactory;

  @BeforeEach
  void setUp() {
    transactionPagoFactory = new TransactionPagoFactory();
  }

  @Test
  void testCreateTransaccionPago() throws BusinessRuleValidationException {

    String codeString = "6ba7b810-9dad-11d1-80b4-00c04fd430c8";
    String descripcion = "Transaccion pago";
    double monto = 100.0;
    UUID codeUUID = UUID.fromString(codeString);
    TransaccionPago transaccionPago = transactionPagoFactory.create(codeString, descripcion, monto);

    assertNotNull(transaccionPago);
    assertEquals(codeUUID, transaccionPago.getCode());
    assertEquals(descripcion, transaccionPago.getDescripcion());
    assertEquals(monto, transaccionPago.getMonto(), 0.001);
  }
}
