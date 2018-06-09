package com.turismo.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
public class OfertaDAO implements OfertaDAOLocal {
	@PersistenceContext(unitName = "MyPU")
	private EntityManager entityManager;

	public void nuevaOferta(String nombre, int cupo, Date fecha_desde, Date fecha_hasta, float precio,
			String tipo_habitacion, String politicas, String servicios, Destino destino, String foto_paquete,
			MedioPago medioPago, int cant_personas, Establecimiento establecimiento, Agencia agencia,
			OfertaTipo ofertaTipo) {
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
		oferta.setCant_personas(cant_personas);
		oferta.setEstablecimiento(establecimiento);
		oferta.setAgencia(agencia);
		oferta.setOfertaTipo(ofertaTipo);
		entityManager.persist(oferta);
	}

	public void actualizarOferta(int oferta_id, String nombre, int cupo, Date fecha_desde, Date fecha_hasta,
			float precio, String tipo_habitacion, String politicas, String servicios, Destino destino,
			String foto_paquete, MedioPago medioPago, int cant_personas, Establecimiento establecimiento,
			Agencia agencia, OfertaTipo ofertaTipo) {
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
		} catch (NoResultException nre) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Oferta> buscarOfertasHotelera(String destino, int cantPersonas, String fDesde, String fHasta) {
			Query ofertasHotelerasQuery = entityManager
					.createQuery("SELECT o FROM Ofertas o " + " INNER JOIN o.destino d"
							+ " INNER JOIN o.ofertaTipo ot " + "WHERE d.nombre = :destino"
							+ " OR o.cant_personas = :cantPersonas" + " OR o.fecha_desde = :fDesde" 
							+ " OR o.fecha_hasta = :fHasta"
							+ " OR ot.nombre = :tipoDeOferta");
			ofertasHotelerasQuery.setParameter("destino", destino);
			ofertasHotelerasQuery.setParameter("cantPersonas", cantPersonas);
			//la fecha esta en null para que no pinche, solo para probar
			ofertasHotelerasQuery.setParameter("fDesde", null);
			//la fecha esta en null para que no pinche, solo para probar
			ofertasHotelerasQuery.setParameter("fHasta", null);
			ofertasHotelerasQuery.setParameter("tipoDeOferta", "hotelera");
			return ofertasHotelerasQuery.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Oferta> buscarOfertasPaquete(String destino, int cantPersonas, String fDesde, String fHasta) {
			Query ofertasHotelerasQuery = entityManager
					.createQuery("SELECT o FROM Oferta o " + " INNER JOIN o.destino d"
							+ " INNER JOIN o.ofertaTipo ot " + "WHERE d.nombre = :destino"
							+ " OR o.cant_personas = :cantPersonas" + " OR o.fecha_desde = :fDesde" + " OR o.fecha_hasta = :fHasta"
							+ " OR ot.nombre = :tipoDeOferta");
			ofertasHotelerasQuery.setParameter("destino", destino);
			ofertasHotelerasQuery.setParameter("cantPersonas", cantPersonas);
			//la fecha esta en null para que no pinche, solo para probar
			ofertasHotelerasQuery.setParameter("fDesde", null);
			//la fecha esta en null para que no pinche, solo para probar
			ofertasHotelerasQuery.setParameter("fHasta", null);
			ofertasHotelerasQuery.setParameter("tipoDeOferta", "paquete");
			return ofertasHotelerasQuery.getResultList();
	}
}
