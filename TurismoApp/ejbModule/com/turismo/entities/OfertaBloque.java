package com.turismo.entities;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="oferta_bloques") 
public class OfertaBloque {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int oferta_bloque_id;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="oferta_id")
	private Oferta oferta;
	private LocalDateTime fecha_bloque;
	private int cupo;
	public int getOferta_bloque_id() {
		return oferta_bloque_id;
	}
	public void setOferta_bloque_id(int oferta_bloque_id) {
		this.oferta_bloque_id = oferta_bloque_id;
	}
	public Oferta getOferta() {
		return oferta;
	}
	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}
	public LocalDateTime getFecha_Bloque() {
		return fecha_bloque;
	}
	public void setFecha_Bloque(LocalDateTime fecha_Bloque) {
		this.fecha_bloque = fecha_Bloque;
	}
	public int getCupo() {
		return cupo;
	}
	public void setCupo(int cupo) {
		this.cupo = cupo;
	}
}
