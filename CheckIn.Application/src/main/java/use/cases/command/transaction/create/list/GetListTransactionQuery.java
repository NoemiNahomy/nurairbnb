package use.cases.command.transaction.create.list;

import an.awesome.pipelinr.Command;
import dtos.TransactionPagoDto;

import java.util.List;

public class GetListTransactionQuery implements Command<List<TransactionPagoDto>> {

  public GetListTransactionQuery() {}
}
