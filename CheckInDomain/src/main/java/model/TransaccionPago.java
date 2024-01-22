package model;

import core.Entity;
import java.util.UUID;

public class TransaccionPago extends Entity {

  private UUID code;
  private String descripcion;
  private Double monto;

  public TransaccionPago(UUID code, String descripcion, Double monto) {
    this.code = code;
    this.descripcion = descripcion;
    this.monto = monto;
  }

  public UUID getCode() {
    return code;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public Double getMonto() {
    return monto;
  }
}
