package infraestructure.MetodoPago;

import core.BusinessRuleValidationException;
import infraestructure.model.MetodoPagoJpaModel;
import infraestructure.repositories.MetodoPago.MetodoPagoCrudRepository;
import infraestructure.repositories.MetodoPago.MetodoPagoJpaRepository;
import model.MetodoPago;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class MetodoPagoJpaRepositoryTest {

  @Mock
  private MetodoPagoCrudRepository mockCrudRepository;

  @InjectMocks
  private MetodoPagoJpaRepository repository;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testUpdate() throws BusinessRuleValidationException {

    MetodoPago baggage = new MetodoPago(UUID.randomUUID(), "Tarjeta", "T");
    MetodoPagoJpaModel jpaModel = new MetodoPagoJpaModel(/*...*/);
    when(mockCrudRepository.save(any(MetodoPagoJpaModel.class))).thenReturn(jpaModel);

    UUID result = repository.update(baggage);

    assertEquals(jpaModel.getId(), result);
  }

  @Test
  void testFindMetodoPagoByIdSuccess() throws BusinessRuleValidationException {
    UUID metodoId = UUID.randomUUID();
    List<MetodoPagoJpaModel> jpaModels = new ArrayList<>();
    jpaModels.add(new MetodoPagoJpaModel());
    when(mockCrudRepository.findMetodoPagoById(metodoId)).thenReturn(jpaModels);
    List<MetodoPago> result = repository.findMetodoPagoById(metodoId);
    assertEquals(jpaModels.size(), result.size());
  }

  @Test
  void testFindMetodoPagoByIdNoResults() throws BusinessRuleValidationException {
    UUID metodoId = UUID.randomUUID();
    when(mockCrudRepository.findMetodoPagoById(metodoId)).thenReturn(null);
    List<MetodoPago> result = repository.findMetodoPagoById(metodoId);
    assertEquals(0, result.size());
  }

  @Test
  void testGetAll() throws BusinessRuleValidationException {
    List<MetodoPagoJpaModel> jpaModels = new ArrayList<>();
    jpaModels.add(new MetodoPagoJpaModel(/*...*/));
    when(mockCrudRepository.findAll()).thenReturn(jpaModels);


    List<MetodoPago> result = repository.getAll();

    assertEquals(jpaModels.size(), result.size());
  }
}
