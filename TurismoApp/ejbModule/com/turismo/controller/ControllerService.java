package com.turismo.controller;

import java.rmi.RemoteException;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.rpc.ServiceException;

import com.turismo.coreservices.BusquedaService;
import com.turismo.coreservices.ReservaService;
import com.turismo.dto.OfertaDTO;
import com.turismo.dto.ReservaDTO;
import com.turismo.exceptions.ConversionFechaException;
import com.turismo.exceptions.OfertaHoteleraException;
import com.turismo.exceptions.OfertaPaqueteException;
import com.turismo.exceptions.ReservaException;
@Stateless
@LocalBean
public class ControllerService{
	@EJB
	private BusquedaService busquedaOfertaService;
	@EJB
	private ReservaService reservaService;
	
	public List<OfertaDTO> buscarOfertaPaquete(int codigoDestino,int cantPersonas,String fDesde, String fHasta) throws OfertaPaqueteException, ConversionFechaException{
		return busquedaOfertaService.buscarOfertaPaquete(codigoDestino, cantPersonas, fDesde, fHasta);
	}

	public List<OfertaDTO> buscarOfertaHotelera(int codigoDestino,String fDesde, String fHasta, String tipoHabitacion) throws OfertaHoteleraException, ConversionFechaException {
		return busquedaOfertaService.buscarOfertaHotelera(codigoDestino, fDesde, fHasta, tipoHabitacion);
	}
	public ReservaDTO reservarHotel(int ofertaid,String fDesde,String fHasta,String tipoHabitacion,int cantHabitaciones,String nombre,String apellido,String dni,int medioPagoId,String mailUsuario) throws ReservaException, ConversionFechaException, OfertaHoteleraException {
		return reservaService.reservarHotel(ofertaid, fDesde, fHasta, tipoHabitacion, cantHabitaciones, nombre, apellido, dni, medioPagoId,mailUsuario);
	}
	public ReservaDTO reservarPaquete(int ofertaid,String fDesde,String fHasta,int cantPersonas,String nombre,String apellido,String dni,int medioPagoId,String mailUsuario) throws ReservaException, RemoteException, ServiceException, ConversionFechaException, OfertaPaqueteException {
		return reservaService.reservarPaquete(ofertaid, fDesde, fHasta, cantPersonas, nombre, apellido, dni, medioPagoId,mailUsuario);
	}
}
