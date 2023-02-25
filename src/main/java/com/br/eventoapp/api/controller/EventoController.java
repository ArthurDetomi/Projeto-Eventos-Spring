package com.br.eventoapp.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.br.eventoapp.api.model.EventoModel;
import com.br.eventoapp.api.service.EventoService;

@Controller
public class EventoController {
	
	@Autowired
	private EventoService eventoService;
	
	@RequestMapping(value = "/cadastrarEvento", method = RequestMethod.GET)
	public String form() {
		return "evento/formEvento";
	}
	
	@RequestMapping(value = "/cadastrarEvento", method = RequestMethod.POST)
	public String formCadastration(EventoModel eventoModel) {
		eventoService.cadastrarEvento(eventoModel);
		return "redirect:/cadastrarEvento";
	}
	
	
}
