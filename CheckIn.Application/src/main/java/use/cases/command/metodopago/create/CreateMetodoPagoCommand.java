package use.cases.command.metodopago.create;

import an.awesome.pipelinr.Command;
import dtos.MetodoPagoDto;
import dtos.TipoPropiedadDto;

public class CreateMetodoPagoCommand implements Command<MetodoPagoDto> {

  MetodoPagoDto metodo;

  public CreateMetodoPagoCommand(MetodoPagoDto metodo) {
    this.metodo = metodo;
  }
}
