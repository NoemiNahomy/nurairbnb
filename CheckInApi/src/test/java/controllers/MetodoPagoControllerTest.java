package controllers;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.anyObject;
import static org.mockito.Mockito.when;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Pipeline;
import dtos.MetodoPagoDto;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class MetodoPagoControllerTest {
  @Mock Pipeline pipeline;

  private static final UUID FLIGHT_ID = UUID.randomUUID();

  @BeforeEach
  public void init() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void testGetMetodoPagoById() {
    List<MetodoPagoDto> seatDtos = new ArrayList<>();
    MetodoPagoDto dto = new MetodoPagoDto(UUID.randomUUID(), "test", "T");
    seatDtos.add(dto);
    when(pipeline.send((Command<Object>) anyObject())).thenReturn(seatDtos);

    MetodoPagoController controller = new MetodoPagoController(pipeline);
    List<MetodoPagoDto> response = controller.getMetodoPago(FLIGHT_ID.toString());
    assertNotNull(response);
  }
}
