package com.registro.usuarios.repositorio;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.registro.usuarios.modelo.Compania;
@Repository
public interface ICompania extends JpaRepository<Compania, Serializable>{
	public abstract Compania findById(Long id);

}
