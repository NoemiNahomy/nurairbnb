package use.cases.command.transaction.create.list;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import core.BusinessRuleValidationException;
import dtos.TransactionPagoDto;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repositories.TransactionPagoRepository;
import use.cases.command.transaccion.list.GetListTransactionHandler;
import use.cases.command.transaccion.list.GetListTransactionQuery;

public class GetListTransactionHandlerTest {

  @Mock private TransactionPagoRepository mockRepository;

  private GetListTransactionHandler handler;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
    handler = new GetListTransactionHandler(mockRepository);
  }

  /*@Test
  void testHandleSuccess() throws BusinessRuleValidationException {
    List<TransaccionPago> fakeTransactions = new ArrayList<>();
    fakeTransactions.add(new TransaccionPago(UUID.randomUUID(), "pago", 100.0));

    when(mockRepository.getAll()).thenReturn(fakeTransactions);
    List<TransactionPagoDto> result = handler.handle(new GetListTransactionQuery());

    assertNotNull(result);
    assertEquals(fakeTransactions.size(), result.size());
  }*/

  @Test
  void testHandleException() throws BusinessRuleValidationException {
    when(mockRepository.getAll()).thenThrow(new BusinessRuleValidationException("Fake exception"));
    List<TransactionPagoDto> result = handler.handle(new GetListTransactionQuery());
    assertNull(result);
  }
}
