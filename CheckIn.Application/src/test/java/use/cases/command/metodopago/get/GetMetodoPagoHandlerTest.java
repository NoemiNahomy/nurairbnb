package use.cases.command.metodopago.get;

import core.BusinessRuleValidationException;
import dtos.MetodoPagoDto;
import dtos.TransactionPagoDto;
import model.MetodoPago;
import model.TransaccionPago;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repositories.MetodoPagoRepository;
import repositories.TransactionPagoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GetMetodoPagoHandlerTest {

  @Mock
  private MetodoPagoRepository mockRepository;

  private GetMetodoPagoHandler handler;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
    handler = new GetMetodoPagoHandler(mockRepository);
  }

  @Test
  void testHandleSuccess() throws BusinessRuleValidationException {
    String fakeId = "6ba7b810-9dad-11d1-80b4-00c04fd430c8";
    UUID fakeUUID = UUID.fromString(fakeId);
    List<MetodoPago> fakeMetodos = new ArrayList<>();
    fakeMetodos.add(new MetodoPago(UUID.randomUUID(),"tarjeta", "T"));

    when(mockRepository.findMetodoPagoById(fakeUUID)).thenReturn(fakeMetodos);
    List<MetodoPagoDto> result = handler.handle(new GetMetodoPagoQuery(fakeId));
    assertNotNull(result);
    assertEquals(fakeMetodos.size(), result.size());
  }

}
