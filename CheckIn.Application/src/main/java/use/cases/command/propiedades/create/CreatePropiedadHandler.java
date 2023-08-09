package use.cases.command.propiedades.create;

import an.awesome.pipelinr.Command;
import core.BusinessRuleValidationException;
import dtos.PropiedadDto;
import dtos.TipoPropiedadDto;
import factories.propiedad.PropiedadFactory;
import factories.tipo.TipoPropiedadFactory;
import model.Propiedad;
import model.TipoPropiedad;
import org.springframework.stereotype.Component;
import repositories.PropiedadRepository;
import repositories.TipoPropiedadRepository;
import utils.PropiedadMapper;
import utils.TipoPropiedadMapper;

import java.util.UUID;

@Component
public class CreatePropiedadHandler
  implements Command.Handler<CreatePropiedadCommand, PropiedadDto> {

  private final PropiedadRepository propiedadRepository;

  private final PropiedadFactory propiedadFactory;


  public CreatePropiedadHandler(
          PropiedadRepository propiedadRepository

  ) {
    this.propiedadRepository = propiedadRepository;

    this.propiedadFactory = new PropiedadFactory();
  }

  @Override
  public PropiedadDto handle(CreatePropiedadCommand request) {
    try {
     Propiedad propiedad =
        propiedadFactory.create(
          UUID.fromString(request.propiedadDto.id.toString()),
          request.propiedadDto.nombre,
                request.propiedadDto.estado,
                request.propiedadDto.precio
        );
      propiedadRepository.update(propiedad);
      return PropiedadMapper.from(propiedad);
    } catch (BusinessRuleValidationException e) {
      return null;
    }
  }
}
