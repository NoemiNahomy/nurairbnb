package use.cases.command.metodopago.list;

import an.awesome.pipelinr.Command;
import core.BusinessRuleValidationException;
import dtos.MetodoPagoDto;
import java.util.List;
import model.MetodoPago;
import org.springframework.stereotype.Component;
import repositories.MetodoPagoRepository;
import utils.MetodoPagoMapper;

@Component
public class GetMetodoHandler
    implements Command.Handler<GetListMetodoPagoQuery, List<MetodoPagoDto>> {

  private final MetodoPagoRepository propiedadRepository;

  public GetMetodoHandler(MetodoPagoRepository propiedadRepository) {
    this.propiedadRepository = propiedadRepository;
  }

  @Override
  public List<MetodoPagoDto> handle(GetListMetodoPagoQuery command) {
    try {
      List<MetodoPago> propiedad = this.propiedadRepository.getAll();
      return propiedad.stream().map(MetodoPagoMapper::from).toList();
    } catch (BusinessRuleValidationException e) {
      e.printStackTrace();
      return null;
    }
  }
}
