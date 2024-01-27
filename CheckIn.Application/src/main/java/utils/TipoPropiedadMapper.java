package utils;

import dtos.TipoPropiedadDto;
import java.util.UUID;
import model.TipoPropiedad;

public final class TipoPropiedadMapper {

  public static TipoPropiedadDto from(TipoPropiedad tipo) {
    if (tipo == null) return new TipoPropiedadDto();
    return new TipoPropiedadDto(
        tipo.getId() == null ? UUID.randomUUID() : tipo.getId(),
        tipo.getNombreTipo() == null ? "" : tipo.getNombreTipo());
  }
}
