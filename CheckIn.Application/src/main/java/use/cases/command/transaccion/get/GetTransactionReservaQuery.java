package use.cases.command.transaccion.get;

import an.awesome.pipelinr.Command;
import dtos.TransactionPagoDto;

public class GetTransactionReservaQuery implements Command<TransactionPagoDto> {

  String reservaId;

  public GetTransactionReservaQuery(String id) {
    this.reservaId = id;
  }
}
