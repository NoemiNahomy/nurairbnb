package event;

import core.DomainEvent;
import model.Propiedad;

import java.util.Date;

public class PropiedadEliminado extends DomainEvent {
    public Propiedad propiedadEliminada;

    public PropiedadEliminado(Propiedad propiedadEliminada, Date occuredOn) {
        super(occuredOn);
        this.propiedadEliminada = propiedadEliminada;
    }
}
