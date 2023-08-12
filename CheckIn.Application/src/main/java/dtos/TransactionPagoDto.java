package dtos;

public class TransactionPagoDto {

  public String code;
  public String descripcion;
  public double monto;

  public TransactionPagoDto() {}

  public TransactionPagoDto(String code, String descripcion, double monto) {
    this.code = code;
    this.descripcion = descripcion;
    this.monto = monto;
  }
}
