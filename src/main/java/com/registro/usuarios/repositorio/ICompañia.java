package com.registro.usuarios.repositorio;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.registro.usuarios.modelo.Compañia;
@Repository
public interface ICompañia extends JpaRepository<Compañia, Serializable>{
	public abstract Compañia findById(Long id);

}
