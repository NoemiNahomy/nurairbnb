package infraestructure.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "tipopropiedad")
public class TipoPropiedadJpaModel {

    @Id
    @Column(nullable = false)
    public UUID id;

    @Column(nullable = false)
    public String nombreTipo;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }
}
