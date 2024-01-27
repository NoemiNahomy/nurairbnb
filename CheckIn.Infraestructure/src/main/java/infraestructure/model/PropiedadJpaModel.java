package infraestructure.model;

import jakarta.persistence.*;
import java.util.UUID;


@Entity
@Table(name = "propiedades")
public class PropiedadJpaModel {

    @Id
    @Column(name="id",nullable = false)
    public UUID id;

    @Column(nullable = false)
    public String nombre;

    @Column(name="estado",nullable = false)

    public String estado;

    @Column(nullable = false)
    public double precio;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
