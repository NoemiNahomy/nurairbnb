package dtos;

import java.util.UUID;

public class MetodoPagoDto {

  public UUID id;
  public String detalle;
  public String tipo;

  public MetodoPagoDto() {}

  public MetodoPagoDto(UUID id,String detalle, String tipo) {
    this.id = id;
    this.detalle = detalle;
    this.tipo = tipo;
  }

  @Override
  public String toString() {
    return (
      "{" +
      "detalle:" +
      detalle +
      ", type:'" +
      tipo + '}'
    );
  }
}
