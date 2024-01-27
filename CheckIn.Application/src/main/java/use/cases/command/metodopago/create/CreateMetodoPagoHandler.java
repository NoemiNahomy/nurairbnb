package use.cases.command.metodopago.create;

import an.awesome.pipelinr.Command;
import core.BusinessRuleValidationException;
import dtos.MetodoPagoDto;
import factories.metodopago.MetodoPagoFactory;
import java.util.UUID;
import model.MetodoPago;
import org.springframework.stereotype.Component;
import repositories.MetodoPagoRepository;
import utils.MetodoPagoMapper;

@Component
public class CreateMetodoPagoHandler
    implements Command.Handler<CreateMetodoPagoCommand, MetodoPagoDto> {

  private final MetodoPagoRepository metodoPagoRepository;

  private final MetodoPagoFactory metodoPagoFactory;

  public CreateMetodoPagoHandler(MetodoPagoRepository metodoPagoRepository) {

    this.metodoPagoRepository = metodoPagoRepository;

    this.metodoPagoFactory = new MetodoPagoFactory();
  }

  @Override
  public MetodoPagoDto handle(CreateMetodoPagoCommand request) {
    try {

      MetodoPago metodo =
          metodoPagoFactory.create(
              UUID.fromString(request.metodo.id.toString()),
              request.metodo.detalle,
              request.metodo.tipo);
      metodoPagoRepository.update(metodo);
      return MetodoPagoMapper.from(metodo);
    } catch (BusinessRuleValidationException e) {
      return null;
    }
  }
}
