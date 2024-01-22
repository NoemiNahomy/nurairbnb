package utils;

import dtos.TransactionPagoDto;
import model.TransaccionPago;

public final class TransaccionMapper {

  public static TransactionPagoDto from(TransaccionPago seat) {
    if (seat == null) return new TransactionPagoDto();
    return new TransactionPagoDto(
        seat.getCode() == null ? "" : seat.getCode().toString(),
        seat.getDescripcion() == null ? "" : seat.getDescripcion(),
        seat.getMonto() == null ? 0.0 : seat.getMonto());
  }
}
