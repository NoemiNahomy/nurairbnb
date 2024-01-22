package infraestructure.repositories.propiedad;

import infraestructure.model.PropiedadJpaModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PropiedadCrudRepository extends CrudRepository<PropiedadJpaModel, UUID> {
  List<PropiedadJpaModel> findByIdAndEstado(UUID id, String estado);

  List<PropiedadJpaModel>findPropiedadById(UUID id);



}
