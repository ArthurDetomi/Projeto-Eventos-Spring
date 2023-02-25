package com.br.eventoapp.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

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

	public ModelAndView getListaEventos() {
		ModelAndView mv = new ModelAndView("index");
		List<EventoModel> eventoslista = eventoRepository.findAll().stream().map(EventoModel::new).toList();
		mv.addObject("eventos", eventoslista);
		return mv;
	}

}
