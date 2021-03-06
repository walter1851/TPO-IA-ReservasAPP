package com.turismo.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import com.turismo.entities.Hotel;

@Stateless
@LocalBean
public class HotelDAO {
	@PersistenceContext(unitName = "MyPU")
	private EntityManager entityManager;

	public Hotel nuevoHotel(String nombre, String codigo_hotel) {
		try {
			Hotel hotel = new Hotel();
			hotel.setNombre(nombre);
			hotel.setCodigo_hotel(codigo_hotel);
			entityManager.persist(hotel);
			return hotel;
		} catch (PersistenceException pe) {
			return null;
		}
	}
	public boolean actualizarHotel(int hotel_id, String nombre, String codigo_hotel) {
		try {
			Hotel hotel = buscarPorIdHotel(hotel_id);
			hotel.setNombre(nombre);
			hotel.setCodigo_hotel(codigo_hotel);
			entityManager.merge(hotel);
			return true;
		} catch (PersistenceException pe) {
			return false;
		}
	}

	public Hotel buscarPorCodigoHotel(String codigoHotel) {
		try {
			Query hotelQuery = entityManager
					.createQuery("SELECT h FROM Hotel h " + "WHERE codigo_hotel = :codigoHotel ");
			hotelQuery.setParameter("codigoHotel", codigoHotel);
			return (Hotel) hotelQuery.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	public Hotel buscarPorIdHotel(int hotelId) {
		try {
			return entityManager.find(Hotel.class, hotelId);
		} catch (NoResultException nre) {
			return null;
		}
	}
}
