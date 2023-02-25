package com.br.eventoapp.api.model;

import com.br.eventoapp.api.domain.entity.Evento;

public class EventoModel {
	
	private String nome;

	private String local;

	private String data;

	private String horario;
	
	public EventoModel() {
		
	}
	
	public EventoModel(Evento evento) {
		this.nome = evento.getName();
		this.horario = evento.getHorario();
		this.data = evento.getData();
		this.local = evento.getLocal();
	}

	public Evento converter() {
		Evento evento = new Evento();
		evento.setName(nome);
		evento.setLocal(local);
		evento.setData(data);
		evento.setHorario(horario);
		return evento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

}
