package com.br.eventoapp.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.br.eventoapp.api.domain.entity.Convidado;
import com.br.eventoapp.api.domain.entity.Evento;
import com.br.eventoapp.api.domain.repository.ConvidadoRepository;
import com.br.eventoapp.api.domain.repository.EventoRepository;
import com.br.eventoapp.api.model.ConvidadoModel;
import com.br.eventoapp.api.model.EventoModel;

@Component
public class EventoService {

	@Autowired
	private EventoRepository eventoRepository;
	
	@Autowired
	private ConvidadoRepository convidadoRepository;

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

	public ModelAndView getDetalhesEvento(Integer id) {
		Evento evento = eventoRepository.getReferenceById(id);
		EventoModel eventoModel = new EventoModel(evento);
		
		ModelAndView mv = new ModelAndView("evento/detalhesEvento");
		mv.addObject("evento", eventoModel);
		
		List<Convidado> convidados = convidadoRepository.findByEvento(evento);
		mv.addObject("convidados",convidados);
		
		return mv;
	}

	public String cadastrarConvidado(int id, ConvidadoModel convidadoModel) {
		Evento evento = eventoRepository.getReferenceById(id);	
		Convidado convidado = convidadoModel.converter();
		convidado.setEvento(evento);
		
		convidadoRepository.save(convidado);
		return "redirect:/{id}";
	}

}
