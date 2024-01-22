package controllers;

import an.awesome.pipelinr.Pipeline;
import dtos.TransactionPagoDto;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import use.cases.command.transaction.create.CreateTransactionCommand;
import use.cases.command.transaction.create.get.GetTransactionQuery;
import use.cases.command.transaction.create.list.GetListTransactionQuery;

@CrossOrigin(origins = "*")
@RestController
public class TransacctionController {

  Logger logger = LoggerFactory.getLogger(TransacctionController.class);
  final Pipeline pipeline;

  public TransacctionController(Pipeline pipeline) {
    this.pipeline = pipeline;
  }

  @GetMapping("/transaction/{id}")
  public List<TransactionPagoDto> getMetodoPago(@PathVariable String id) {
    GetTransactionQuery query = new GetTransactionQuery(id);
    return query.execute(pipeline);
  }

  @GetMapping("/transacction-list")
  public List<TransactionPagoDto> getListAllTipoPropiedades() {
    GetListTransactionQuery query = new GetListTransactionQuery();
    return query.execute(pipeline);
  }

  @PostMapping("/transacction/create")
  public TransactionPagoDto createTipo(@RequestBody TransactionPagoDto metodoDto) {

    CreateTransactionCommand createMetodoCommand = new CreateTransactionCommand(metodoDto);
    return createMetodoCommand.execute(pipeline);
  }
}
