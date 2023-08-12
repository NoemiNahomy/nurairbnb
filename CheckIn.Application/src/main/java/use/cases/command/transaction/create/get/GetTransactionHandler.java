package use.cases.command.transaction.create.get;

import an.awesome.pipelinr.Command;
import core.BusinessRuleValidationException;
import dtos.PropiedadDto;
import dtos.TransactionPagoDto;
import model.Propiedad;
import model.TransaccionPago;
import org.springframework.stereotype.Component;
import repositories.PropiedadRepository;
import repositories.TransactionPagoRepository;
import utils.PropiedadMapper;
import utils.TransaccionMapper;

import java.util.List;
import java.util.UUID;

@Component
public class GetTransactionHandler
  implements Command.Handler<GetTransactionQuery, List<TransactionPagoDto>> {

  private final TransactionPagoRepository propiedadRepository;

  public GetTransactionHandler(TransactionPagoRepository propiedadRepository) {
    this.propiedadRepository = propiedadRepository;
  }

  @Override
  public List<TransactionPagoDto> handle(GetTransactionQuery command) {
    try {
      List<TransaccionPago> propiedades = propiedadRepository.findByTransactionCode(
              UUID.fromString(command.id)
      );
      return propiedades.stream().map(TransaccionMapper::from).toList();
    } catch (BusinessRuleValidationException e) {
      e.printStackTrace();
      return null;
    }
  }
}
