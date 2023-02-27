package com.br.eventoapp.api.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.eventoapp.api.domain.entity.Convidado;
import com.br.eventoapp.api.domain.entity.Evento;

public interface ConvidadoRepository extends JpaRepository<Convidado, Integer>{
	
	List<Convidado> findByEvento(Evento evento);
	
}
