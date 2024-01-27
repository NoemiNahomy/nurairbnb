package factories;

import factories.transaccion.TransactionPagoFactory;
import org.junit.jupiter.api.BeforeEach;

class TransactionPagoFactoryTest {

  private TransactionPagoFactory transactionPagoFactory;

  @BeforeEach
  void setUp() {
    transactionPagoFactory = new TransactionPagoFactory();
  }

  /* @Test
  void testCreateTransaccionPago() throws BusinessRuleValidationException {

    String codeString = "6ba7b810-9dad-11d1-80b4-00c04fd430c8";
    String descripcion = "Transaccion pago";
    double monto = 100.0;
    UUID codeUUID = UUID.fromString(codeString);

    TransaccionPago transaccionPago = transactionPagoFactory.create(codeString, descripcion, monto, null, null,null,null, null,null);

    assertNotNull(transaccionPago);
    assertEquals(codeUUID, transaccionPago.getCode());
    assertEquals(descripcion, transaccionPago.getDescripcion());
    assertEquals(monto, transaccionPago.getMonto(), 0.001);
  }*/
}
