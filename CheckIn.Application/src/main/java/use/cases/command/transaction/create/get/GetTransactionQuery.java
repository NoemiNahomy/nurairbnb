package use.cases.command.transaction.create.get;

import an.awesome.pipelinr.Command;
import dtos.TransactionPagoDto;
import java.util.List;

public class GetTransactionQuery implements Command<List<TransactionPagoDto>> {

  String id;

  public GetTransactionQuery(String id) {
    this.id = id;
  }
}
