package use.cases.command.tipropiedades.get;

import an.awesome.pipelinr.Command;
import core.BusinessRuleValidationException;
import dtos.TipoPropiedadDto;
import java.util.List;
import java.util.UUID;
import model.TipoPropiedad;
import org.springframework.stereotype.Component;
import repositories.TipoPropiedadRepository;
import utils.TipoPropiedadMapper;

@Component
public class GetTipoPropiedadHandler
    implements Command.Handler<GetTipoPropiedadQuery, List<TipoPropiedadDto>> {

  private final TipoPropiedadRepository propiedadRepository;

  public GetTipoPropiedadHandler(TipoPropiedadRepository propiedadRepository) {
    this.propiedadRepository = propiedadRepository;
  }

  @Override
  public List<TipoPropiedadDto> handle(GetTipoPropiedadQuery command) {
    try {
      List<TipoPropiedad> propiedades =
          propiedadRepository.findTipoPropiedadById(UUID.fromString(command.id));
      return propiedades.stream().map(TipoPropiedadMapper::from).toList();
    } catch (BusinessRuleValidationException e) {
      e.printStackTrace();
      return null;
    }
  }
}
