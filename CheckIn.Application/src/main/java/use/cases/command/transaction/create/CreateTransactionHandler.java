package use.cases.command.transaction.create;

import an.awesome.pipelinr.Command;
import core.BusinessRuleValidationException;
import dtos.TransactionPagoDto;
import factories.transaccion.TransactionPagoFactory;
import model.TransaccionPago;
import org.springframework.stereotype.Component;
import repositories.TransactionPagoRepository;
import utils.TransaccionMapper;

@Component
public class CreateTransactionHandler
    implements Command.Handler<CreateTransactionCommand, TransactionPagoDto> {

  private final TransactionPagoRepository metodoPagoRepository;

  private final TransactionPagoFactory metodoPagoFactory;

  public CreateTransactionHandler(TransactionPagoRepository metodoPagoRepository) {

    this.metodoPagoRepository = metodoPagoRepository;

    this.metodoPagoFactory = new TransactionPagoFactory();
  }

  @Override
  public TransactionPagoDto handle(CreateTransactionCommand request) {
    try {

      TransaccionPago metodo =
          metodoPagoFactory.create(
              request.metodo.code.toString(), request.metodo.descripcion, request.metodo.monto);
      metodoPagoRepository.update(metodo);
      return TransaccionMapper.from(metodo);
    } catch (BusinessRuleValidationException e) {
      return null;
    }
  }
}
