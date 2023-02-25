package com.br.eventoapp.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.eventoapp.api.domain.entity.Evento;
import com.br.eventoapp.api.domain.repository.EventoRepository;
import com.br.eventoapp.api.model.EventoModel;

@Component
public class EventoService {
	
	@Autowired
	private EventoRepository eventoRepository;

	public void cadastrarEvento(EventoModel eventoModel) {
		Evento evento = eventoModel.converter();
		eventoRepository.save(evento);
	}
	
	
	
}
