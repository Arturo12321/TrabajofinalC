package com.registro.usuarios.repositorio;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.registro.usuarios.modelo.Reserva;

public interface IReserva extends JpaRepository<Reserva, Serializable>{
	public abstract Reserva findById(Long id);
}
