package infraestructure.repositories.MetodoPago;

import infraestructure.model.MetodoPagoJpaModel;
import infraestructure.model.CheckInJpaModel;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetodoPagoCrudRepository
  extends CrudRepository<MetodoPagoJpaModel, UUID> {

  List<MetodoPagoJpaModel> findMetodoPagoById(UUID id);
}
