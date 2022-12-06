package com.registro.usuarios.repositorio;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.registro.usuarios.modelo.Pasaje;
@Repository
public interface IPasaje extends JpaRepository<Pasaje, Serializable>{
	public abstract Pasaje findById(Long id);
	public abstract Pasaje findByClase(String Clase);
}
	