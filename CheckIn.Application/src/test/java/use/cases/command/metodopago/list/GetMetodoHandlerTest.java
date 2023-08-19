package use.cases.command.metodopago.list;

import core.BusinessRuleValidationException;
import dtos.MetodoPagoDto;
import model.MetodoPago;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repositories.MetodoPagoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class GetMetodoHandlerTest {

  @Mock
  private MetodoPagoRepository mockRepository;

  private GetMetodoHandler handler;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
    handler = new GetMetodoHandler(mockRepository);
  }

  @Test
  void testHandleSuccess() throws BusinessRuleValidationException {
    List<MetodoPago> fakeMetodos = new ArrayList<>();
    fakeMetodos.add(new MetodoPago( UUID.randomUUID(),"Tarjeta", "T"));

    when(mockRepository.getAll()).thenReturn(fakeMetodos);
    List<MetodoPagoDto> result = handler.handle(new GetListMetodoPagoQuery());
    assertNotNull(result);
    assertEquals(fakeMetodos.size(), result.size());
  }

  @Test
  void testHandleException() throws BusinessRuleValidationException {
    when(mockRepository.getAll()).thenThrow(new BusinessRuleValidationException("Fake exception"));
    List<MetodoPagoDto> result = handler.handle(new GetListMetodoPagoQuery());
    assertNull(result);
  }
}
