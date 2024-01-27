package use.cases.command.transaccion.list;

import an.awesome.pipelinr.Command;
import core.BusinessRuleValidationException;
import dtos.TransactionPagoDto;
import java.util.List;
import model.TransaccionPago;
import org.springframework.stereotype.Component;
import repositories.TransactionPagoRepository;
import utils.TransaccionMapper;

@Component
public class GetListTransactionHandler
    implements Command.Handler<GetListTransactionQuery, List<TransactionPagoDto>> {

  private final TransactionPagoRepository propiedadRepository;

  public GetListTransactionHandler(TransactionPagoRepository propiedadRepository) {
    this.propiedadRepository = propiedadRepository;
  }

  @Override
  public List<TransactionPagoDto> handle(GetListTransactionQuery command) {
    try {
      List<TransaccionPago> propiedad = this.propiedadRepository.getAll();
      return propiedad.stream().map(TransaccionMapper::from).toList();
    } catch (BusinessRuleValidationException e) {
      e.printStackTrace();
      return null;
    }
  }
}
