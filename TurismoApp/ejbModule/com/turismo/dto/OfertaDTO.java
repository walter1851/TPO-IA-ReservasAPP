package com.turismo.dto;

public class OfertaDTO {
	private Integer oferta_id;
	private Integer codigo_oferta;
	private String nombre;
	private Integer cupo;
	private String fecha_desde;
	private String fecha_hasta;
	private float precio;
	private TipoHabitacionDTO tipo_habitacion;
	private String politicas;
	private String servicios;
	private DestinoDTO destinoDTO;
	private String foto_paquete;
	private String descripcionPaquete;
	private MedioPagoDTO medioPagoDTO;
	private Integer cant_personas;
	private EstablecimientoDTO establecimientoDTO;
	private AgenciaDTO agenciaDTO;
	private OfertaTipoDTO ofertaTipoDTO;
	
	public Integer getCodigo_oferta() {
		return codigo_oferta;
	}
	public void setCodigo_oferta(Integer codigo_oferta) {
		this.codigo_oferta = codigo_oferta;
	}
	public String getDescripcionPaquete() {
		return descripcionPaquete;
	}
	public void setDescripcionPaquete(String descripcionPaquete) {
		this.descripcionPaquete = descripcionPaquete;
	}
	public Integer getOferta_id() {
		return oferta_id;
	}
	public void setOferta_id(Integer oferta_id) {
		this.oferta_id = oferta_id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getCupo() {
		return cupo;
	}
	public void setCupo(Integer cupo) {
		this.cupo = cupo;
	}
	public String getFecha_desde() {
		return fecha_desde;
	}
	public void setFecha_desde(String fecha_desde) {
		this.fecha_desde = fecha_desde;
	}
	public String getFecha_hasta() {
		return fecha_hasta;
	}
	public void setFecha_hasta(String fecha_hasta) {
		this.fecha_hasta = fecha_hasta;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public TipoHabitacionDTO getTipo_habitacion() {
		return tipo_habitacion;
	}
	public void setTipo_habitacion(TipoHabitacionDTO tipo_habitacion) {
		this.tipo_habitacion = tipo_habitacion;
	}
	public String getPoliticas() {
		return politicas;
	}
	public void setPoliticas(String politicas) {
		this.politicas = politicas;
	}
	public String getServicios() {
		return servicios;
	}
	public void setServicios(String servicios) {
		this.servicios = servicios;
	}
	public DestinoDTO getDestinoDTO() {
		return destinoDTO;
	}
	public void setDestinoDTO(DestinoDTO destinoDTO) {
		this.destinoDTO = destinoDTO;
	}
	public String getFoto_paquete() {
		return foto_paquete;
	}
	public void setFoto_paquete(String foto_paquete) {
		this.foto_paquete = foto_paquete;
	}
	public MedioPagoDTO getMedioPagoDTO() {
		return medioPagoDTO;
	}
	public void setMedioPagoDTO(MedioPagoDTO medioPagoDTO) {
		this.medioPagoDTO = medioPagoDTO;
	}
	public Integer getCant_personas() {
		return cant_personas;
	}
	public void setCant_personas(Integer cant_personas) {
		this.cant_personas = cant_personas;
	}
	public EstablecimientoDTO getEstablecimientoDTO() {
		return establecimientoDTO;
	}
	public void setEstablecimientoDTO(EstablecimientoDTO establecimientoDTO) {
		this.establecimientoDTO = establecimientoDTO;
	}
	public AgenciaDTO getAgenciaDTO() {
		return agenciaDTO;
	}
	public void setAgenciaDTO(AgenciaDTO agenciaDTO) {
		this.agenciaDTO = agenciaDTO;
	}
	public OfertaTipoDTO getOfertaTipoDTO() {
		return ofertaTipoDTO;
	}
	public void setOfertaTipoDTO(OfertaTipoDTO ofertaTipoDTO) {
		this.ofertaTipoDTO = ofertaTipoDTO;
	}
	
	
}
