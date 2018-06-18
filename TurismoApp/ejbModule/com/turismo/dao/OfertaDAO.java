package com.turismo.dao;

import java.time.LocalDateTime;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.turismo.entities.Agencia;
import com.turismo.entities.Destino;
import com.turismo.entities.Establecimiento;
import com.turismo.entities.MedioPago;
import com.turismo.entities.Oferta;
import com.turismo.entities.OfertaTipo;

@Stateless
@LocalBean
public class OfertaDAO {
	@PersistenceContext(unitName = "MyPU")
	private EntityManager entityManager;

	public Oferta nuevaOfertaHotelera(String nombre, int cupo, LocalDateTime fecha_desde, LocalDateTime fecha_hasta,
			float precio, String tipo_habitacion, String politicas, String servicios, Destino destino,
			String foto_paquete, MedioPago medioPago, Establecimiento establecimiento, OfertaTipo ofertaTipo) {
		Oferta oferta = new Oferta();
		oferta.setNombre(nombre);
		oferta.setCupo(cupo);
		oferta.setFecha_desde(fecha_desde);
		oferta.setFecha_hasta(fecha_hasta);
		oferta.setPrecio(precio);
		oferta.setTipo_habitacion(tipo_habitacion);
		oferta.setPoliticas(politicas);
		oferta.setServicios(servicios);
		oferta.setDestino(destino);
		oferta.setFoto_paquete(foto_paquete);
		oferta.setMedioPago(medioPago);
		oferta.setEstablecimiento(establecimiento);
		oferta.setAgencia(null);
		oferta.setOfertaTipo(ofertaTipo);
		oferta.setDestino(destino);
		entityManager.persist(oferta);
		return oferta;
	}

	public Oferta nuevaOfertaPaquete(String nombre, int cupo, LocalDateTime fecha_desde, LocalDateTime fecha_hasta,
			float precio, String politicas, String servicios, Destino destino, String foto_paquete,
			String descripcionPaquete, MedioPago medioPago, int cant_personas, Agencia agencia, OfertaTipo ofertaTipo) {
		Oferta oferta = new Oferta();
		oferta.setNombre(nombre);
		oferta.setCupo(cupo);
		oferta.setFecha_desde(fecha_desde);
		oferta.setFecha_hasta(fecha_hasta);
		oferta.setPrecio(precio);
		oferta.setTipo_habitacion(null);
		oferta.setPoliticas(politicas);
		oferta.setServicios(servicios);
		oferta.setDestino(destino);
		oferta.setFoto_paquete(foto_paquete);
		oferta.setMedioPago(medioPago);
		oferta.setCant_personas(cant_personas);
		oferta.setEstablecimiento(null);
		oferta.setAgencia(agencia);
		oferta.setOfertaTipo(ofertaTipo);
		oferta.setDestino(destino);
		oferta.setDescriptionPaquete(descripcionPaquete);
		entityManager.persist(oferta);
		return oferta;
	}

	public void actualizarOferta(int oferta_id, String nombre, int cupo, LocalDateTime fecha_desde,
			LocalDateTime fecha_hasta, float precio, String tipo_habitacion, String politicas, String servicios,
			Destino destino, String foto_paquete, MedioPago medioPago, int cant_personas,
			Establecimiento establecimiento, Agencia agencia, OfertaTipo ofertaTipo) {
		Oferta oferta = buscarPorIdOferta(oferta_id);
		oferta.setNombre(nombre);
		oferta.setCupo(cupo);
		oferta.setFecha_desde(fecha_desde);
		oferta.setFecha_hasta(fecha_hasta);
		oferta.setPrecio(precio);
		oferta.setTipo_habitacion(tipo_habitacion);
		oferta.setPoliticas(politicas);
		oferta.setServicios(servicios);
		oferta.setDestino(destino);
		oferta.setFoto_paquete(foto_paquete);
		oferta.setMedioPago(medioPago);
		oferta.setCant_personas(cant_personas);
		oferta.setEstablecimiento(establecimiento);
		oferta.setAgencia(agencia);
		oferta.setOfertaTipo(ofertaTipo);
		entityManager.merge(oferta);

	}

	public Oferta buscarPorIdOferta(int idOferta) {
		try {
			return entityManager.find(Oferta.class, idOferta);
		} catch (Exception nre) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Oferta> buscarOfertasHotelera(int destinoId, String tipo_Habitacion, LocalDateTime fDesde,
			LocalDateTime fHasta) {
		Query ofertasHotelerasQuery = entityManager.createQuery("SELECT o FROM Oferta o " + " INNER JOIN o.destino d"
				+ " WHERE d.destino_id = :destinoId" + " AND o.tipo_habitacion = :tipo_Habitacion"
				+ " AND o.fecha_desde <= :fDesde" + " OR o.fecha_hasta >= :fHasta" + " AND OfertaTipo = :tipoDeOferta");
		ofertasHotelerasQuery.setParameter("destinoId", destinoId);
		ofertasHotelerasQuery.setParameter("tipo_Habitacion", tipo_Habitacion);
		ofertasHotelerasQuery.setParameter("fDesde", fDesde);
		ofertasHotelerasQuery.setParameter("fHasta", fHasta);
		ofertasHotelerasQuery.setParameter("tipoDeOferta", OfertaTipo.OFERTA_HOTELERA.name());
		return ofertasHotelerasQuery.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Oferta> buscarOfertasPaquete(int destinoId, int cantPersonas, LocalDateTime fDesde,
			LocalDateTime fHasta) {
		Query ofertasHotelerasQuery = entityManager
				.createQuery("SELECT o FROM Oferta o " + " INNER JOIN o.destino d" + " WHERE d.destino_id = :destinoId"
						+ " AND o.cant_personas <= :cantPersonas" + " AND o.fecha_desde <= :fDesde"
						+ " AND o.fecha_hasta >= :fHasta" + " AND OfertaTipo = :tipoDeOferta");
		ofertasHotelerasQuery.setParameter("destinoId", destinoId);
		ofertasHotelerasQuery.setParameter("cantPersonas", cantPersonas);
		ofertasHotelerasQuery.setParameter("fDesde", fDesde);
		ofertasHotelerasQuery.setParameter("fHasta", fHasta);
		ofertasHotelerasQuery.setParameter("tipoDeOferta", OfertaTipo.OFERTA_PAQUETE.name());
		return ofertasHotelerasQuery.getResultList();
	}
}
