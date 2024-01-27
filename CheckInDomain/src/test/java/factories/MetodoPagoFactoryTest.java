package factories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import core.BusinessRuleValidationException;
import factories.metodopago.MetodoPagoFactory;
import java.util.UUID;
import model.MetodoPago;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MetodoPagoFactoryTest {

  private MetodoPagoFactory metodoPagoFactory;

  @BeforeEach
  void setUp() {
    metodoPagoFactory = new MetodoPagoFactory();
  }

  @Test
  void testCreateMetodoPago() throws BusinessRuleValidationException {
    UUID id = UUID.randomUUID();
    String detalle = "Tarjeta PAYPAL";
    String tipo = "T";

    MetodoPago metodoPago = metodoPagoFactory.create(id, detalle, tipo);

    assertNotNull(metodoPago);
    assertEquals(id, metodoPago.getId());
    assertEquals(detalle, metodoPago.getDetalle());
  }
}
