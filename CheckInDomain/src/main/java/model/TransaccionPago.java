package model;

import core.Entity;

import java.util.UUID;

public class TransaccionPago extends Entity {

	private UUID code;
	private String descripcion;
	private Double monto;

	private String estado;

	private UUID metodopagoId;


	private UUID reservaId;

	private UUID propiedadId;


	private UUID personaId;

	private String fechaPago;

	private String numeroTarjeta;

	private String fechaVencimiento;

	private String cvc;

	public TransaccionPago(UUID code, String descripcion, Double monto, String estado, UUID metodopagoId, UUID reservaId, UUID propiedadId, UUID personaId, String fechaPago, String numeroTarjeta, String fechaVencimiento, String cvc) {
		this.code = code;
		this.descripcion = descripcion;
		this.monto = monto;
		this.estado = estado;
		this.metodopagoId = metodopagoId;
		this.reservaId = reservaId;
		this.propiedadId = propiedadId;
		this.personaId = personaId;
		this.fechaPago = fechaPago;
		this.numeroTarjeta = numeroTarjeta;
		this.fechaVencimiento = fechaVencimiento;
		this.cvc = cvc;
	}

	public UUID getCode() {
		return code;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Double getMonto() {
		return monto;
	}

	public String getEstado() {
		return estado;
	}

	public UUID getMetodopagoId() {
		return metodopagoId;
	}

	public UUID getReservaId() {
		return reservaId;
	}

	public UUID getPropiedadId() {
		return propiedadId;
	}

	public UUID getPersonaId() {
		return personaId;
	}

	public String getFechaPago() {
		return fechaPago;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public String getCvc() {
		return cvc;
	}
}
