package com.registro.usuarios.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.registro.usuarios.modelo.Pasaje;
import com.registro.usuarios.repositorio.IPasaje;
@Service("pasaje")
public class PasajeService {
	@Autowired
	IPasaje iPasaje;
	public void guardar (Pasaje pasaje) {
		iPasaje.save(pasaje);
	}
	public List<Pasaje> listar() {
		return iPasaje.findAll();
	}
	public Pasaje buscar (Long id) {
		return iPasaje.findById(id);
	}
	public Pasaje buscar (String clase) {
		return iPasaje.findByClase(clase);
	}
	public boolean eliminar(Long id) {
		try {
			iPasaje.delete(iPasaje.findById(id));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
