package use.cases.command.tipropiedades.list;

import an.awesome.pipelinr.Command;
import core.BusinessRuleValidationException;
import dtos.TipoPropiedadDto;
import model.TipoPropiedad;
import org.springframework.stereotype.Component;
import repositories.TipoPropiedadRepository;
import utils.TipoPropiedadMapper;

import java.util.List;

@Component
public class GetListTipoPropiedadesHandler
        implements Command.Handler<GetListTipoPropiedadesQuery, List<TipoPropiedadDto>> {

  private final TipoPropiedadRepository tipo;

  public GetListTipoPropiedadesHandler(TipoPropiedadRepository tipo) {
    this.tipo = tipo;
  }

  @Override
  public List<TipoPropiedadDto> handle(GetListTipoPropiedadesQuery command) {
    try {
      List<TipoPropiedad> tipo = this.tipo.getAll();
      return tipo.stream().map(TipoPropiedadMapper::from).toList();
    } catch (BusinessRuleValidationException e) {
      e.printStackTrace();
      return null;
    }
  }
}
