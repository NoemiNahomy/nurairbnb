package use.cases.command.tipropiedades.create;

import an.awesome.pipelinr.Command;
import core.BusinessRuleValidationException;
import dtos.TipoPropiedadDto;
import factories.tipo.TipoPropiedadFactory;
import model.TipoPropiedad;
import org.springframework.stereotype.Component;
import repositories.TipoPropiedadRepository;
import utils.TipoPropiedadMapper;

import java.util.UUID;

@Component
public class CreateTipoHandler
  implements Command.Handler<CreateTipoCommand, TipoPropiedadDto> {

  private final TipoPropiedadRepository tipoPropiedadRepository;

  private final TipoPropiedadFactory tipoPropiedadFactory;


  public CreateTipoHandler(
          TipoPropiedadRepository checkInRepository

  ) {
    this.tipoPropiedadRepository = checkInRepository;

    this.tipoPropiedadFactory = new TipoPropiedadFactory();
  }

  @Override
  public TipoPropiedadDto handle(CreateTipoCommand request) {
    try {


     TipoPropiedad checkIn =
        tipoPropiedadFactory.create(
          UUID.fromString(request.checkInDto.id.toString()),
          request.checkInDto.nombreTipo
        );
      tipoPropiedadRepository.update(checkIn);
      return TipoPropiedadMapper.from(checkIn);
    } catch (BusinessRuleValidationException e) {
      return null;
    }
  }
}
