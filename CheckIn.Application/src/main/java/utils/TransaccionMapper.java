package utils;

import dtos.TransactionPagoDto;
import model.TransaccionPago;

public final class TransaccionMapper {

  public static TransactionPagoDto from(TransaccionPago pago) {
    if (pago == null) return new TransactionPagoDto();
    return new TransactionPagoDto(
        pago.getCode().toString(),
        pago.getDescripcion(),
        pago.getMonto(),
        pago.getEstado(),
        pago.getMetodopagoId().toString(),
        pago.getReservaId().toString(),
        pago.getPropiedadId().toString(),
        pago.getPersonaId().toString(),
        pago.getFechaPago(),
        pago.getNumeroTarjeta(),
        pago.getFechaVencimiento(),
        pago.getCvc());
  }
}
