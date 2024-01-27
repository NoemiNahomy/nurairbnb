package dtos;

public class TransactionPagoDto {

  public String code;
  public String descripcion;
  public double monto;
  public String estado;
  public String metodopagoId;
  public String reservaId;

  public String propiedadId;
  public String personaId;

  public String fechaPago;

  public String numeroTarjeta;
  public String fechaVencimiento;
  public String cvc;

  public TransactionPagoDto() {}

  public TransactionPagoDto(
      String code,
      String descripcion,
      double monto,
      String estado,
      String metodopagoId,
      String reservaId,
      String propiedadId,
      String personaId,
      String fechaPago,
      String numeroTarjeta,
      String fechaVencimiento,
      String cvc) {
    this.code = code;
    this.descripcion = descripcion;
    this.monto = monto;
    this.estado = estado;
    this.metodopagoId = metodopagoId;
    this.reservaId = reservaId;
    this.propiedadId = propiedadId;
    this.personaId = personaId;
    this.fechaPago = fechaPago;
    this.numeroTarjeta = numeroTarjeta;
    this.fechaVencimiento = fechaVencimiento;
    this.cvc = cvc;
  }
}
