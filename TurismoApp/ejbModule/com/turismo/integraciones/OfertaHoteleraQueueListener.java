package com.turismo.integraciones;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import com.turismo.coreservices.OfertaService;

/**
 * Message-Driven Bean implementation class for: OfertaHoteleraQueueListener
 */
//cambiar la ruta, por la cola remota
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "java:/jms/queue/TurismoQueue"), @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue")
		}, 
		mappedName = "java:/jms/queue/TurismoQueue")
public class OfertaHoteleraQueueListener implements MessageListener {
	@EJB
	private OfertaService ofertaService;
    public OfertaHoteleraQueueListener() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
    	try {
			String jsonString = ((TextMessage) message).getText();
			OfertaHoteleraMensaje ofertaHoteleraMensaje = (OfertaHoteleraMensaje) JsonConverter.convertToObject(jsonString,
					OfertaHoteleraMensaje.class);
			ofertaService.guardarOfertaHotelera(ofertaHoteleraMensaje);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
