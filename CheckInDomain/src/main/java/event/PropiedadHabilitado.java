package event;

import core.DomainEvent;
import model.Propiedad;

import java.util.Date;


public class PropiedadHabilitado extends DomainEvent {

    public Propiedad propiedadHabilitada;

    public PropiedadHabilitado(Propiedad propiedadHabilitada, Date occuredOn) {
        super(occuredOn);
        this.propiedadHabilitada = propiedadHabilitada;
    }
}
