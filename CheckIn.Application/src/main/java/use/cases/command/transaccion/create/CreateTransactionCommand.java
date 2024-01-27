package use.cases.command.transaccion.create;

import an.awesome.pipelinr.Command;
import dtos.TransactionPagoDto;

public class CreateTransactionCommand implements Command<TransactionPagoDto> {

  TransactionPagoDto pago;

  public CreateTransactionCommand(TransactionPagoDto pagoDto) {
    this.pago = pagoDto;
  }
}
