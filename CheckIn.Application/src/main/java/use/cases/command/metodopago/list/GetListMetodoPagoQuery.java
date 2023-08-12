package use.cases.command.metodopago.list;

import an.awesome.pipelinr.Command;
import dtos.MetodoPagoDto;
import dtos.TipoPropiedadDto;

import java.util.List;

public class GetListMetodoPagoQuery implements Command<List<MetodoPagoDto>> {

  public GetListMetodoPagoQuery() {}
}
