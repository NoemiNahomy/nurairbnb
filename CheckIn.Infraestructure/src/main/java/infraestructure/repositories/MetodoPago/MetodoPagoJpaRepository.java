package infraestructure.repositories.MetodoPago;

import core.BusinessRuleValidationException;
import infraestructure.model.MetodoPagoJpaModel;
import infraestructure.utils.MetodoPagoUtils;
import model.MetodoPago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;
import repositories.MetodoPagoRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Primary
@Repository
public class MetodoPagoJpaRepository implements MetodoPagoRepository {

  @Autowired
  private MetodoPagoCrudRepository baggageCrudRepository;

  @Override
  public UUID update(MetodoPago baggage) {

    MetodoPagoJpaModel jpaModel = MetodoPagoUtils.baggageToJpaEntity(
      baggage
    );
    return baggageCrudRepository.save(jpaModel).getId();
  }

  @Override
  public List<MetodoPago> findMetodoPagoById(UUID metodoId)
    throws BusinessRuleValidationException {

    List<MetodoPagoJpaModel> jpaModels = baggageCrudRepository.findMetodoPagoById(metodoId
    );
    List<MetodoPago> baggages = new ArrayList<>();
    if (
      jpaModels == null || jpaModels.isEmpty()
    ) return Collections.emptyList();
    for (MetodoPagoJpaModel jpaModel : jpaModels) {
      baggages.add(MetodoPagoUtils.jpaToBaggage(jpaModel));
    }
    return baggages;
  }

  @Override
  public List<MetodoPago> getAll() throws BusinessRuleValidationException {
    List<MetodoPagoJpaModel> jpaModels = Streamable
            .of(baggageCrudRepository.findAll())
            .toList();
    List<MetodoPago> passengers = new ArrayList<>();
    for (MetodoPagoJpaModel jpaModel : jpaModels) {
      passengers.add(MetodoPagoUtils.jpaToBaggage(jpaModel));
    }
    return passengers;
  }

  public void setBaggageCrudRepository(
    MetodoPagoCrudRepository baggageCrudRepository
  ) {
    this.baggageCrudRepository = baggageCrudRepository;
  }


}
