package com.br.eventoapp.api.model;

import com.br.eventoapp.api.domain.entity.Evento;

import jakarta.validation.constraints.NotBlank;

public class EventoModel {
	
	private Integer id;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String local;
	
	@NotBlank
	private String data;
	
	@NotBlank
	private String horario;
	
	public EventoModel() {
		
	}
	
	public EventoModel(Evento evento) {
		this.id = evento.getId();
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
	
	public Integer getId() {
		return id;
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
