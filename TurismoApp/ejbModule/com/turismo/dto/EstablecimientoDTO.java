package com.turismo.dto;

import com.turismo.entities.Hotel;

public class EstablecimientoDTO {
	private int establecimiento_id;
	private String nombre;
	private String direccion;
	private String ciudad;
	private String estado;
	private String descripcion;
	private String estrellas;
	private String mapa;
	private String codigo_establecimiento;
	private Hotel hotel;
	public int getEstablecimiento_id() {
		return establecimiento_id;
	}
	public void setEstablecimiento_id(int establecimiento_id) {
		this.establecimiento_id = establecimiento_id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getEstrellas() {
		return estrellas;
	}
	public void setEstrellas(String estrellas) {
		this.estrellas = estrellas;
	}
	public String getMapa() {
		return mapa;
	}
	public void setMapa(String mapa) {
		this.mapa = mapa;
	}
	public String getCodigo_establecimiento() {
		return codigo_establecimiento;
	}
	public void setCodigo_establecimiento(String codigo_establecimiento) {
		this.codigo_establecimiento = codigo_establecimiento;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
}
