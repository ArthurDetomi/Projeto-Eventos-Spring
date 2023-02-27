package com.br.eventoapp.api.model;

import com.br.eventoapp.api.domain.entity.Convidado;

public class ConvidadoModel {
	
	private String nomeConvidado;
	
	private String rg;
	
	public ConvidadoModel() {
		
	}
	
	public Convidado converter() {
		Convidado convidado = new Convidado();
		convidado.setNome(nomeConvidado);
		convidado.setRg(rg);
		return convidado;
	}

	public String getNomeConvidado() {
		return nomeConvidado;
	}

	public void setNomeConvidado(String nomeConvidado) {
		this.nomeConvidado = nomeConvidado;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}
	
	
	
}
