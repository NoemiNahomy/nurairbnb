package dtos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TransactionPagoDtoTest {

  /* @Test
  void testConstructorAndGetters() {
    String code = "123";
    String descripcion = "Pago airbnb";
    double monto = 100.0;

    TransactionPagoDto dto = new TransactionPagoDto(code, descripcion, monto);

    assertEquals(code, dto.code);
    assertEquals(descripcion, dto.descripcion);
    assertEquals(monto, dto.monto, 0.001);
  }*/

  @Test
  void testDefaultConstructor() {
    TransactionPagoDto dto = new TransactionPagoDto();
    assertEquals(null, dto.code);
    assertEquals(null, dto.descripcion);
    assertEquals(0.0, dto.monto, 0.001);
  }
}
