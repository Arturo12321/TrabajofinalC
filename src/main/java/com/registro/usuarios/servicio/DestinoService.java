package com.registro.usuarios.servicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.registro.usuarios.modelo.Destino;
import com.registro.usuarios.repositorio.IDestino;
@Service("destino")
public class DestinoService { 
	@Autowired
	IDestino iDestino;
	public void guardar (Destino destino) {
		iDestino.save(destino);
	}
	public List<Destino> listar() {
		return iDestino.findAll();
	}
	public Destino buscar (Long id) {
		return iDestino.findById(id);
	}
	public Destino buscar (String ciudad_dest) {
		return iDestino.findByDestino(ciudad_dest);
	}
	public boolean eliminar(Long id) {
		try {
			iDestino.delete(iDestino.findById(id));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
