package use.cases.command.metodopago.get;

import an.awesome.pipelinr.Command;
import core.BusinessRuleValidationException;
import dtos.MetodoPagoDto;
import java.util.List;
import java.util.UUID;
import model.MetodoPago;
import org.springframework.stereotype.Component;
import repositories.MetodoPagoRepository;
import utils.MetodoPagoMapper;

@Component
public class GetMetodoPagoHandler
    implements Command.Handler<GetMetodoPagoQuery, List<MetodoPagoDto>> {

  private final MetodoPagoRepository metodoRepository;

  public GetMetodoPagoHandler(MetodoPagoRepository metodoRepository) {
    this.metodoRepository = metodoRepository;
  }

  @Override
  public List<MetodoPagoDto> handle(GetMetodoPagoQuery command) {
    try {
      List<MetodoPago> propiedades =
          metodoRepository.findMetodoPagoById(UUID.fromString(command.id));
      return propiedades.stream().map(MetodoPagoMapper::from).toList();
    } catch (BusinessRuleValidationException e) {
      e.printStackTrace();
      return null;
    }
  }
}
