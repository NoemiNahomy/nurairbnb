package infraestructure.model;

import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "transacciones")
public class TransactionJpaModel {

	@Id
	@Column(nullable = false)
	private UUID code;

	@Column()
	private String descripcion;

	@Column(nullable = false)
	private double monto;

	@Column(nullable = false)
	private String estado;

	@Column(nullable = false)
	private UUID metodopagoId;

	@Column(nullable = false)
	private UUID reservaId;

	@Column(nullable = false)
	private UUID propiedadId;

	@Column(nullable = false)
	private UUID personaId;

	@Column
	private String fechaPago;

	@Column
	private String numeroTarjeta;


	@Column
	private String fechaVencimiento;

	@Column
	private String cvc;

	public UUID getCode() {
		return code;
	}

	public void setCode(UUID code) {
		this.code = code;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	public UUID getMetodopagoId() {
		return metodopagoId;
	}

	public void setMetodopagoId(UUID metodopagoId) {
		this.metodopagoId = metodopagoId;
	}

	public UUID getReservaId() {
		return reservaId;
	}

	public void setReservaId(UUID reservaId) {
		this.reservaId = reservaId;
	}

	public UUID getPropiedadId() {
		return propiedadId;
	}

	public void setPropiedadId(UUID propiedadId) {
		this.propiedadId = propiedadId;
	}

	public UUID getPersonaId() {
		return personaId;
	}

	public void setPersonaId(UUID personaId) {
		this.personaId = personaId;
	}

	public String getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public String getCvc() {
		return cvc;
	}

	public void setCvc(String cvc) {
		this.cvc = cvc;
	}
}
