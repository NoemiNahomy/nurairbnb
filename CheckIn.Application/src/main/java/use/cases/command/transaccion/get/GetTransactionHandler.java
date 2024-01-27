package use.cases.command.transaccion.get;

import an.awesome.pipelinr.Command;
import core.BusinessRuleValidationException;
import dtos.TransactionPagoDto;
import java.util.List;
import java.util.UUID;
import model.TransaccionPago;
import org.springframework.stereotype.Component;
import repositories.TransactionPagoRepository;
import utils.TransaccionMapper;

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
      List<TransaccionPago> propiedades =
          propiedadRepository.findByTransactionCode(UUID.fromString(command.id));
      return propiedades.stream().map(TransaccionMapper::from).toList();
    } catch (BusinessRuleValidationException e) {
      e.printStackTrace();
      return null;
    }
  }
}
