package com.br.eventoapp.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EventoController {
	
	@RequestMapping("/cadastrarEvento")
	public String form() {
		return "formEvento";
	}
	
}
