package use.cases.command.transaction.create;

import an.awesome.pipelinr.Command;
import dtos.TransactionPagoDto;

public class CreateTransactionCommand implements Command<TransactionPagoDto> {

  TransactionPagoDto metodo;

  public CreateTransactionCommand(TransactionPagoDto metodo) {
    this.metodo = metodo;
  }
}
