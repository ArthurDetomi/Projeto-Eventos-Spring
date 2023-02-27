package com.br.eventoapp.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.br.eventoapp.api.model.ConvidadoModel;
import com.br.eventoapp.api.model.EventoModel;
import com.br.eventoapp.api.service.EventoService;

import jakarta.validation.Valid;

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

	@RequestMapping(value = "/eventos", method = RequestMethod.GET)
	public ModelAndView listaEventos() {
		return eventoService.getListaEventos();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView detalhesEvento(@PathVariable("id") int id) {
		return eventoService.getDetalhesEvento(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String cadastrarConvidado(@PathVariable("id") int id, @Valid ConvidadoModel convidadoModel, 
			BindingResult result, RedirectAttributes atributes) {
		if (result.hasErrors()) {
			atributes.addFlashAttribute("mensagem", "Verifique os campos");
		    return "redirect:/{id}";
		}
		
		atributes.addFlashAttribute("mensagem", "Convidado adicionado com sucesso");		
		return eventoService.cadastrarConvidado(id, convidadoModel);
	}

}
