package use.cases.command.metodopago.get;

import an.awesome.pipelinr.Command;
import dtos.MetodoPagoDto;
import java.util.List;

public class GetMetodoPagoQuery implements Command<List<MetodoPagoDto>> {
  String id;

  public GetMetodoPagoQuery(String id) {
    this.id = id;
  }
}
