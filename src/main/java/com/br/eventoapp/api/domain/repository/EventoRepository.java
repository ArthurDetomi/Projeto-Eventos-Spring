package com.br.eventoapp.api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.eventoapp.api.domain.entity.Evento;

public interface EventoRepository extends JpaRepository<Evento, Integer>{
	

}
