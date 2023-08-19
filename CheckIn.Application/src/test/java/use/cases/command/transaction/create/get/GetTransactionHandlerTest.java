package use.cases.command.transaction.create.get;

import core.BusinessRuleValidationException;
import dtos.TransactionPagoDto;
import model.TransaccionPago;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repositories.TransactionPagoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GetTransactionHandlerTest {

  @Mock
  private TransactionPagoRepository mockRepository;

  private GetTransactionHandler handler;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
    handler = new GetTransactionHandler(mockRepository);
  }

  @Test
  public void testHandleSuccess() throws BusinessRuleValidationException {
    String fakeId = "6ba7b810-9dad-11d1-80b4-00c04fd430c8";
    UUID fakeUUID = UUID.fromString(fakeId);
    List<TransaccionPago> fakeTransactions = new ArrayList<>();
    fakeTransactions.add(new TransaccionPago(UUID.randomUUID(), "pago", 200.0));

    when(mockRepository.findByTransactionCode(fakeUUID)).thenReturn(fakeTransactions);

    List<TransactionPagoDto> result = handler.handle(new GetTransactionQuery(fakeId));

    assertNotNull(result);
    assertEquals(fakeTransactions.size(), result.size());
  }

}
